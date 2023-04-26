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
    private Map<String, Double> convertMapUCD;
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
            throw new Group7Exception(20001, "empty GPA Converting file");
        }

        // update the total credits
        this.totalCredits += gradeData.getCredits();
        // update the total US grade points
        double gradePointUS;
        if (originalScale == EGPAScale.UCD){
            // UCD 4.2
            if (!this.convertMapUCD.containsKey(gradeData.getGrade())){
                throw new Group7Exception(20001, "The Grade should from A To D with +/- or E, F!");
            }
            gradePointUS = this.convertMapUCD.get(gradeData.getGrade());

        }else{
            // CHINA 0-100
            try{
                double parsedGrade = Double.parseDouble(gradeData.getGrade());
                gradePointUS = mapChinaScaleToUS(parsedGrade);
            }catch (NumberFormatException e){
                throw new Group7Exception(20001, "The Grade should be number!");
            }
        }
        this.totalUSGradePoints += gradePointUS * gradeData.getCredits();

        // create a new row of Grade table for this user
        Grade grade = new Grade(user, gradeData.getCourseName(), gradeData.getGrade(), gradeData.getCredits(), gradePointUS);
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

        // get the profile of this user
        Profile profile = this.user.getProfile();

        // update the GPA in the profile of this user
        profile.setGpa(convertedGPA);
        this.profileRepository.save(profile);

        // store the grade rows into db
        user.setGrades(userGrades);
        this.userRepository.save(user);

        // for test
        System.out.println("Converted GPA: " + convertedGPA);
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


    private void initGradeConvertMapUCDtoUS(){
        Map<String, Double> convertMapDublin = new HashMap<>();
        convertMapDublin.put("A+", 4.0);
        convertMapDublin.put("A", 4.0);
        convertMapDublin.put("A-", 4.0);
        convertMapDublin.put("B+", 4.0);
        convertMapDublin.put("B", 3.7);
        convertMapDublin.put("B-", 3.7);
        convertMapDublin.put("C+", 3.3);
        convertMapDublin.put("C", 3.0);
        convertMapDublin.put("C-", 2.7);
        convertMapDublin.put("D+", 2.3);
        convertMapDublin.put("D", 2.0);
        convertMapDublin.put("D-", 1.7);
        convertMapDublin.put("E", 1.0);
        convertMapDublin.put("F", 0.0);
        this.convertMapUCD = convertMapDublin;
    }

    private double mapChinaScaleToUS(double grade){
        if (grade >= 90){
            return 4.0;
        } else if (grade >= 80) {
            return 3.0;
        } else if (grade >= 70) {
            return 2.0;
        } else if (grade >= 60) {
            return 1.0;
        }else{
            return 0.0;
        }
    }

    private void resetUserGrade(User user){
        this.gradeRepository.deleteAllByUser(user);
    }
}
