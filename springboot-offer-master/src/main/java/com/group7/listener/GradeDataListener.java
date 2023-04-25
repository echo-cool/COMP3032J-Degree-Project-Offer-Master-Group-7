package com.group7.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.group7.entitiy.excel.GradeData;
import com.group7.service.GPAConvertingService;
import com.group7.utils.handler.exception.Group7Exception;

/**
 * @Author: LiuZhe
 * @Date: 2023/4/25 - 15:10
 */
public class GradeDataListener extends AnalysisEventListener<GradeData> {

    private GPAConvertingService gpaConvertingService;

    // grade point multiplied by the number of credit
    private float totalUSGradePoint;

    public GradeDataListener() {};
    public GradeDataListener(GPAConvertingService gpaConvertingService){
        this.gpaConvertingService = gpaConvertingService;
    }


    @Override
    public void invoke(GradeData gradeData, AnalysisContext analysisContext) {
        // for each row in Excel (except header), this will be executed

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

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        // for test
        System.out.println("US total points: " + this.totalUSGradePoint);
    }
}
