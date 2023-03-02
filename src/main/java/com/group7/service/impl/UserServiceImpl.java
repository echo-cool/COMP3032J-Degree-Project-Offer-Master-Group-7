package com.group7.service.impl;

import com.group7.db.jpa.UserRepository;
import com.group7.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @Author: LiuZhe
 * @Date: 2023/3/1 - 22:25
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public String uploadAvatar(MultipartFile file) {
        // e.g. test.png
        String filename = file.getOriginalFilename();

        // to avoid duplicate name
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        filename = uuid + filename;

        System.out.println("--------------------filename: " + filename);

        // concatenate the path for this avatar
        ApplicationHome applicationHome = new ApplicationHome(this.getClass());
        String pre = applicationHome.getDir().getParentFile().getParentFile().getAbsolutePath()
//                + "\\src\\main\\resources\\static\\upload\\avatar\\";
                + "\\---vue---\\src\\assets\\upload\\avatar\\";
        String savePath = pre + filename;

        // store the file
        try {
            file.transferTo(new File(savePath));
            // create the access path to store in db
            String avatarPath = "@/assets/upload/avatar/" + filename;
            return avatarPath;
        } catch (IOException e) {
            return null;
        }
    }
}
