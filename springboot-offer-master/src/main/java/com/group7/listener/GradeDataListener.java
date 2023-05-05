package com.group7.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.group7.db.jpa.*;
import com.group7.db.jpa.utils.EGPAScale;
import com.group7.entitiy.excel.GradeData;
import com.group7.service.GPAConvertingService;
import com.group7.utils.common.JwtUtils;
import com.group7.utils.handler.exception.Group7Exception;
import jakarta.servlet.http.HttpServletRequest;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author: LiuZhe
 * @Date: 2023/4/25 - 15:10
 */
public class GradeDataListener extends AnalysisEventListener<GradeData> {

    // we have to get them from constructor
    // because Spring cannot control this class
    private ProfileRepository profileRepository;
    private UserRepository userRepository;
    private GradeRepository gradeRepository;
    private User user;


    // grade point multiplied by the number of credit
    private double totalUSGradePoints = 0;
    private double totalCredits = 0;

    // map the original grade to the US grade point
    private Map<String, String> convertMapUCDtoUS; // UCD grade : US grade
    private Map<String, Double> convertMapUS;   // US grade : US point
    private  EGPAScale originalScale;

    private Set<Grade> userGrades = new HashSet<>();  // for updating the Grade table in db


    public GradeDataListener() {};
    public GradeDataListener(EGPAScale originalScale, UserRepository userRepository, ProfileRepository profileRepository, GradeRepository gradeRepository, User user){
        this.originalScale = originalScale;
        this.userRepository = userRepository;
        this.profileRepository = profileRepository;
        this.gradeRepository = gradeRepository;
        this.user = user;

        resetUserGrade(this.user);
        initGradeConvertMapUS();
        if (originalScale == EGPAScale.UCD){
            initGradeConvertMapUCDtoUS();
        }
    }

    /**
     * For each row in Excel (except header), this will be called
     */
    @Override
    public void invoke(GradeData gradeData, AnalysisContext analysisContext) {
        // empty file
        if (gradeData == null){
            resetUserGrade(this.user);
            throw new Group7Exception(20001, "empty GPA Converting file");
        }
        // empty row item (any one)
        if (gradeData.getGrade() == null || gradeData.getCredits() == null || gradeData.getCourseName() == null){
            resetUserGrade(this.user);
            throw new Group7Exception(20001, "You should fill in all the blanks for all inputted courses!");
        }

        // parse user inputted credits from string to double
        double credits;
        try{
            credits = Double.parseDouble(gradeData.getCredits());
        }catch (NumberFormatException e){
            resetUserGrade(this.user);
            throw new Group7Exception(20001, "The Credit should be number!");
        }

        // update the total credits
        this.totalCredits += credits;
        // update the total US grade points
        // convert to the US grade e.g. "A" -> "A+" or 90 -> "A"
        String gradeUS;
        if (originalScale == EGPAScale.UCD){
            // UCD 4.2
            if (!this.convertMapUCDtoUS.containsKey(gradeData.getGrade())){
                resetUserGrade(this.user);
                throw new Group7Exception(20001, "The Grade should from A To D with +/- or E, F!");
            }
            gradeUS = this.convertMapUCDtoUS.get(gradeData.getGrade());

        }else{
            // CHINA 0-100
            try{
                double parsedGrade = Double.parseDouble(gradeData.getGrade());
                gradeUS = mapChinaScaleToUS(parsedGrade);
            }catch (NumberFormatException e){
                resetUserGrade(this.user);
                throw new Group7Exception(20001, "The Grade should be number!");
            }
        }
        // convert to the US grade point e.g. "A+" -> 4.0
        double gradePointUS = this.convertMapUS.get(gradeUS);
        this.totalUSGradePoints += gradePointUS * credits;

        // create a new row of Grade table for this user
        Grade grade = new Grade(user, gradeData.getCourseName(), gradeData.getGrade(), gradeUS, credits, gradePointUS);
        this.userGrades.add(grade);
        gradeRepository.save(grade);

    }

    /**
     * This will be called after all the rows are checked
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        // calculate the converted GPA
        double convertedGPA = this.totalUSGradePoints / this.totalCredits;

        //with only 2 decimal places
        convertedGPA = (double) Math.round(convertedGPA * 100) / 100;

        // get the profile of this user
        Profile profile = this.user.getProfile();

        // update the GPA in the profile of this user
        profile.setGpa(convertedGPA);
        this.profileRepository.save(profile);

        // store the grade rows into db
        user.setGrades(userGrades);
        this.userRepository.save(user);

        // for test
//        System.out.println("Converted GPA: " + convertedGPA);
    }

    /**
     * To check the Excel header
     */
    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
        // the correct header
        String headerCourseName = "Course Name";
        String headerGrade = "Grade";
        String headerCredits = "Credits";

        // check the header and template
        if (headMap.size() == 0){
            throw new Group7Exception(20002, "A wrong template is uploaded!");
        }

        if (!headMap.containsValue(headerCredits)
                || !headMap.containsValue(headerCourseName)
                || !headMap.containsValue(headerGrade)) {
            throw new Group7Exception(20002, "A wrong template is uploaded!");
        }
    }

    private void initGradeConvertMapUS(){
        Map<String, Double> convertMapUS = new HashMap<>();
        convertMapUS.put("A+", 4.0);
        convertMapUS.put("A", 4.0);
        convertMapUS.put("A-", 3.7);
        convertMapUS.put("B+", 3.3);
        convertMapUS.put("B", 3.0);
        convertMapUS.put("B-", 2.7);
        convertMapUS.put("C+", 2.3);
        convertMapUS.put("C", 2.0);
        convertMapUS.put("C-", 1.7);
        convertMapUS.put("D+", 1.3);
        convertMapUS.put("D", 1.0);
        convertMapUS.put("D-", 0.7);
        convertMapUS.put("E", 0.3);
        convertMapUS.put("F", 0.0);
        this.convertMapUS = convertMapUS;
    }

    private void initGradeConvertMapUCDtoUS(){
        Map<String, String> convertUCDtoUS = new HashMap<>();
        convertUCDtoUS.put("A+", "A+");
        convertUCDtoUS.put("A", "A+");
        convertUCDtoUS.put("A-", "A");
        convertUCDtoUS.put("B+", "A");
        convertUCDtoUS.put("B", "A-");
        convertUCDtoUS.put("B-", "A-");
        convertUCDtoUS.put("C+", "B+");
        convertUCDtoUS.put("C", "B");
        convertUCDtoUS.put("C-", "B-");
        convertUCDtoUS.put("D+", "C+");
        convertUCDtoUS.put("D", "C");
        convertUCDtoUS.put("D-", "C-");
        convertUCDtoUS.put("E", "D");
        convertUCDtoUS.put("F", "F");
        this.convertMapUCDtoUS = convertUCDtoUS;
    }

    private String mapChinaScaleToUS(double grade){
        if (grade > 100 || grade < 0){
            resetUserGrade(this.user);
            throw new Group7Exception(20001, "The Chinese Grade Scale should range from 0 to 100!");
        } else if (grade >= 90){
            return "A";
        } else if (grade >= 80) {
            return "B";
        } else if (grade >= 70) {
            return "C";
        } else if (grade >= 60) {
            return "D";
        }else{
            return "F";
        }
    }

    private void resetUserGrade(User user){
        this.gradeRepository.deleteAllByUser(user);
    }
}
