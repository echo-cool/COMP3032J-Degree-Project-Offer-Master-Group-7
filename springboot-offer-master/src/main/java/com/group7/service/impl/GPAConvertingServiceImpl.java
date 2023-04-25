package com.group7.service.impl;

import com.alibaba.excel.EasyExcel;
import com.group7.entitiy.excel.GradeData;
import com.group7.listener.GPADataListener;
import com.group7.service.GPAConvertingService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author: LiuZhe
 * @Date: 2023/4/25 - 14:04
 */
@Service
public class GPAConvertingServiceImpl implements GPAConvertingService {

    @Override
    public void convertGPA(MultipartFile file, GPAConvertingService gpaConvertingService) {
        String filename = file.getOriginalFilename();
        EasyExcel.read(filename, GradeData.class, new GPADataListener(gpaConvertingService)).sheet().doRead();
    }
}
