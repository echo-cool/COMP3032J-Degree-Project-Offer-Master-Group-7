package com.group7.controller;

import com.group7.utils.common.R;
import generator.domain.User;
import generator.mapper.UserMapper;
import generator.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public R selectOne(@PathVariable("id") String id) {
        User user = userService.getById(id);
        if (user != null){
            return R.ok().data("data", user);
        }
        else {
            return R.error();
        }
    }

}
