package com.group7.controller;
import com.group7.db.mappers.UserMapper;
import com.group7.db.model.User;
import com.group7.db.model.UserExample;
import com.group7.utils.common.R;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RestController
@RequestMapping("user")
public class UserController {

    @Resource
    private UserMapper userMapper;

    @GetMapping("/{id}")
    public R selectOne(@PathVariable("id") String id) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andIdEqualTo(id);
        User user = userMapper.selectByExample(userExample).get(0);
        if (user != null){
            return R.ok().data("data", user);
        }
        else {
            return R.error();
        }
    }

}
