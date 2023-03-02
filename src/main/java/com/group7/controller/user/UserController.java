package com.group7.controller.user;


import com.group7.db.jpa.User;
import com.group7.db.jpa.UserRepository;
import com.group7.service.UserService;
import com.group7.utils.common.JwtUtil;
import com.group7.utils.common.R;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Objects;


@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    private static final String[] PIC_TYPES = new String[]{"bmp", "jpg", "jpeg", "png", "gif"};

    @RequestMapping("/getUser")
    public R getUser(HttpServletRequest request) {
        if (Objects.equals(request.getMethod(), "GET")) {
            String id = request.getAttribute("id").toString();
            User user = userRepository.findById(Long.valueOf(id)).orElse(null);
            if (user != null) {
                return R.ok().data("data", user);
            } else {
                return R.error();
            }
        } else {
            return R.error().message("error");
        }
    }

    @PostMapping("/uploadAvatar")
    public R uploadAvatar(MultipartFile file, HttpServletRequest request){
        // check empty file
        if (file.isEmpty()){
            return R.error().message("Upload failed - empty picture");
        }

        // check file type
        String ext = file.getOriginalFilename().split("\\.")[1];
        boolean isValidType = false;
        for (String type : PIC_TYPES){
            if (type.equals(ext)){
                isValidType = true;
                break;
            }
        }
        if(!isValidType){
            return R.error().message("Upload failed - the picture type should be the following: " +
                    "\"bmp\", \"jpg\", \"jpeg\", \"png\", \"gif\"");
        }

        // get user id from the token in the header of http request
        Long userId = JwtUtil.getUserIdByToken(request);
        // find user from db
        User user = userRepository.findById(userId).orElse(null);
        if (user == null){
            return R.error().message("Upload failed - user not found!");
        }

        // store the file locally
        String avatarPath = userService.uploadAvatar(file);

        if (avatarPath == null){
            return R.error().message("Upload failed - Try it again latter.");
        }

        // update the user avatar in db
        user.setAvatar(avatarPath);
        userRepository.save(user);

        return R.ok().data("avatar", avatarPath).data("user", user);
    }


}
