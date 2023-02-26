package com.group7.db.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.group7.db.domain.User;
import com.group7.db.service.UserService;
import com.group7.db.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author yuyangwang
* @description 针对表【User】的数据库操作Service实现
* @createDate 2023-02-26 19:52:50
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




