package com.group7.service.impl;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import com.alibaba.excel.EasyExcel;
import com.group7.db.jpa.ProfileRepository;
import com.group7.db.jpa.User;
import com.group7.db.jpa.UserRepository;
import com.group7.entitiy.excel.GradeData;
import com.group7.listener.GradeDataListener;
import com.group7.service.GPAConvertingService;
import com.group7.utils.handler.exception.Group7Exception;
import jakarta.servlet.http.HttpServletRequest;
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
    public void convertGPA(MultipartFile file, ProfileRepository profileRepository, User user) throws Group7Exception{
        try {
            // read in the Excel data
            InputStream fis = file.getInputStream();

            // check the empty template uploading
            ExcelReader reader = ExcelUtil.getReader(fis, 0);
            int rowCount = reader.getRowCount();
            if (rowCount <= 1) {
                throw new Group7Exception(20001, "An empty template is uploaded! Please fill in the template before uploading.");
            }

            // need to get stream again, otherwise there is an exception
            fis = file.getInputStream();
            // read data row by row
            EasyExcel.read(fis, GradeData.class, new GradeDataListener(profileRepository, user)).sheet().doRead();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
