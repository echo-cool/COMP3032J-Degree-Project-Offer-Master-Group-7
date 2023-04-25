package com.group7.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.group7.db.jpa.*;
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
    private Map<Integer, Double> convertMapChina;

    private Set<Grade> userGrades = new HashSet<>();  // for updating the Grade table in db


    public GradeDataListener() {};
    public GradeDataListener(UserRepository userRepository, ProfileRepository profileRepository, GradeRepository gradeRepository, User user){
        this.userRepository = userRepository;
        this.profileRepository = profileRepository;
        this.gradeRepository = gradeRepository;
        this.user = user;
        initGradeConvertMap();
        resetUserGrade(this.user);
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
        double gradePointUS = this.convertMapUCD.get(gradeData.getGrade());
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
        String headerGrade = "Grade (A - F)";
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


    private void initGradeConvertMap(){
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

    private void resetUserGrade(User user){
        this.gradeRepository.deleteAllByUser(user);
    }
}
