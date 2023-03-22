package com.group7.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @Author: LiuZhe
 * @Date: 2023/3/1 - 22:25
 */
public interface UserService {

    /**
     * @param file The avatar file
     * @param preURL e.g. http://127.0.0.1:8080/img/upload/avatar/
     * @return e.g. http://127.0.0.1:8080/img/upload/avatar/user1.png
     */
    public String uploadAvatar(MultipartFile file, String preURL);

//    public void changePassword();

}
