package com.group7.service.impl;

import com.alibaba.excel.EasyExcel;
import com.group7.entitiy.excel.GradeData;
import com.group7.listener.GradeDataListener;
import com.group7.service.GPAConvertingService;
import com.group7.utils.handler.exception.Group7Exception;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: LiuZhe
 * @Date: 2023/4/25 - 14:04
 */
@Service
public class GPAConvertingServiceImpl implements GPAConvertingService {

    @Override
    public void convertGPA(MultipartFile file, GPAConvertingService gpaConvertingService) throws Group7Exception{
        try {
            // read in the Excel data
            InputStream fis = file.getInputStream();
            // read data row by row
            EasyExcel.read(fis, GradeData.class, new GradeDataListener(gpaConvertingService)).sheet().doRead();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
