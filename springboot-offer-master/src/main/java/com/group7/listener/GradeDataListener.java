package com.group7.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.group7.entitiy.excel.GradeData;
import com.group7.service.GPAConvertingService;
import com.group7.utils.handler.exception.Group7Exception;

import java.util.Map;

/**
 * @Author: LiuZhe
 * @Date: 2023/4/25 - 15:10
 */
public class GradeDataListener extends AnalysisEventListener<GradeData> {

    private GPAConvertingService gpaConvertingService;

    // grade point multiplied by the number of credit
    private float totalUSGradePoint = 0;

    public GradeDataListener() {};
    public GradeDataListener(GPAConvertingService gpaConvertingService){
        this.gpaConvertingService = gpaConvertingService;
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

        // for test
        System.out.println("==================================================================================================================================================================");
        System.out.println("courseName: " + gradeData.getCourseName());
        System.out.println("grade: " + gradeData.getGrade());
        System.out.println("credits: " + gradeData.getCredits());
        System.out.println("==================================================================================================================================================================");

        this.totalUSGradePoint += (1 * gradeData.getCredits());
    }

    /**
     * This will be called after all the rows are checked
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        // for test
        System.out.println("US total points: " + this.totalUSGradePoint);
    }

    /**
     * To check the Excel header
     */
    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
        // the correct header
        String headerCourseName = "Course Name";
        String headerGrade = "Grade (A - D)";
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
}
