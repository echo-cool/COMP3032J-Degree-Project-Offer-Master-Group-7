package com.group7.service;

import com.group7.db.jpa.GradeRepository;
import com.group7.db.jpa.ProfileRepository;
import com.group7.db.jpa.User;
import com.group7.db.jpa.UserRepository;
import com.group7.utils.handler.exception.Group7Exception;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author: LiuZhe
 * @Date: 2023/4/25 - 14:03
 */
public interface GPAConvertingService {

    // convert GPA to 4.0 scale by Excel file
    void convertGPA(MultipartFile file, UserRepository userRepository, ProfileRepository profileRepository, GradeRepository gradeRepository, User user) throws Group7Exception;
}
