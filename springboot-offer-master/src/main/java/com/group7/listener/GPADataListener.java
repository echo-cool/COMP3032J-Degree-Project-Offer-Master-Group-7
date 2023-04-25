package com.group7.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.read.listener.ReadListener;
import com.group7.entitiy.excel.GradeData;
import com.group7.service.GPAConvertingService;
import com.group7.utils.handler.exception.Group7Exception;
import lombok.extern.slf4j.Slf4j;

import java.io.Reader;

/**
 * @Author: LiuZhe
 * @Date: 2023/4/25 - 15:10
 */
public class GPADataListener implements ReadListener<GradeData> {

    private GPAConvertingService gpaConvertingService;

    public GPADataListener() {};
    public GPADataListener(GPAConvertingService gpaConvertingService){
        this.gpaConvertingService = gpaConvertingService;
    }


    @Override
    public void invoke(GradeData gradeData, AnalysisContext analysisContext) {
        // empty file
        if (gradeData == null){
            throw new Group7Exception(20001, "empty GPA Converting file");
        }

        // for test
        System.out.println("==================================================================================================================================================================");
        System.out.printf("courseName: " + gradeData.getCourseName());
        System.out.printf("grade: " + gradeData.getGrade());
        System.out.println("credits: " + gradeData.getCredits());
        System.out.println("==================================================================================================================================================================");

    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
