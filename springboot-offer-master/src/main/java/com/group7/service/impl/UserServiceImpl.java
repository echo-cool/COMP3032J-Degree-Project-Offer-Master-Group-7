package com.group7.service.impl;

import com.group7.db.jpa.User;
import com.group7.db.jpa.UserRepository;
import com.group7.entitiy.UserQueryVo;
import com.group7.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import static com.group7.utils.common.ListToPage.listToPage;

/**
 * @Author: LiuZhe
 * @Date: 2023/3/1 - 22:25
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository userRepository;

    @Override
    public String uploadAvatar(MultipartFile file) {
        // e.g. test.png
        String filename = file.getOriginalFilename();

        // to avoid duplicate name
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        filename = uuid + filename;

        // concatenate the path for this avatar
//        ApplicationHome applicationHome = new ApplicationHome(this.getClass());
//        String pre = applicationHome.getDir().getParentFile().getParentFile().getAbsolutePath()
//                + "\\src\\main\\resources\\static\\upload\\avatar\\";

        String projectDir = System.getProperty("user.dir");
        if(Objects.equals(projectDir, "/")){
            projectDir = "";
        }
        String pre = projectDir + File.separatorChar + "src" + File.separatorChar + "main" + File.separatorChar
                + "resources" + File.separatorChar + "static" + File.separatorChar + "upload" + File.separatorChar
                + "avatar" + File.separatorChar;
        String savePath = pre + filename;

        // store the file
        try {
            file.transferTo(new File(savePath));
            // generate the http url for this pic
//            String url = preURL + filename;
            // return the pic url to store in db
            return "upload/avatar/" + filename;
        } catch (IOException e) {
            return null;
        }
    }

    @Override
    public Page<User> pageByVo(long current, long limit, UserQueryVo userQueryVo) {
        Page<User> userList;
        Sort sort;
        if (userQueryVo.getSort()) {
            sort = Sort.by("username").ascending();
        }else {
            sort = Sort.by("username").descending();
        }
        Pageable pageable = PageRequest.of((int)current, (int)limit, sort);

        List<User> users = userRepository.findByUsernameContainingAndEmailContaining(userQueryVo.getUsername(), userQueryVo.getEmail(), sort);
        userList = listToPage(users, pageable);

        
        return userList;
    }

}
