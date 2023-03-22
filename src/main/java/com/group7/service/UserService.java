package com.group7.service;

import com.group7.db.jpa.School;
import com.group7.db.jpa.User;
import com.group7.entitiy.SchoolQueryVo;
import com.group7.entitiy.UserQueryVo;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author: LiuZhe
 * @Date: 2023/3/1 - 22:25
 */
public interface UserService {

    public String uploadAvatar(MultipartFile file);

    public Page<User> pageByVo(long current, long limit, UserQueryVo userQueryVo);

//    public void changePassword();

}
