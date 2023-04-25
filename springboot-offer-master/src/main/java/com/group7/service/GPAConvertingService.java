package com.group7.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @Author: LiuZhe
 * @Date: 2023/4/25 - 14:03
 */
public interface GPAConvertingService {

    // convert GPA to 4.0 scale by Excel file
    void convertGPA(MultipartFile file, GPAConvertingService gpaConvertingService);
}
