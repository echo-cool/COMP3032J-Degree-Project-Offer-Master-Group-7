package com.group7.controller;

import com.group7.common.R;
import com.group7.db.mapper.UserMapper;
import com.group7.db.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/{id}")
    public R selectOne(@PathVariable("id") String id) {
        User user = userMapper.selectByPrimaryKey(id);
        if (user != null){
            return R.ok().data("data", user);
        }
        else {
            return R.error();
        }
    }

}
