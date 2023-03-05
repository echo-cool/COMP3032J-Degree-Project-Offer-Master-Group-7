package com.group7.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @Author: LiuZhe
 * @Date: 2023/3/1 - 22:25
 */
public interface UserService {

    public String uploadAvatar(MultipartFile file);

}
