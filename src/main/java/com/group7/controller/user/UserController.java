package com.group7.controller.user;

import com.group7.db.mappers.UserMapper;
import com.group7.db.model.User;
import com.group7.db.model.UserExample;
import com.group7.utils.common.R;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/secure")
public class UserController {

    @Resource
    private UserMapper userMapper;

    @GetMapping("/user")
    public R getUser(HttpServletRequest request) {
        String id = request.getAttribute("id").toString();
        UserExample userExample = new UserExample();
        userExample.createCriteria().andIdEqualTo(Integer.valueOf(id));
        User user = userMapper.selectByExample(userExample).get(0);
        if (user != null) {
            return R.ok().data("data", user);
        } else {
            return R.error();
        }
    }
    @RequestMapping("/getUserInfo")
    public R getUserInfo(HttpServletRequest request) {
        String id = request.getAttribute("id").toString();
        String username = request.getAttribute("username").toString();
        String openid = request.getAttribute("openid").toString();
        String email = request.getAttribute("email").toString();
        String role = request.getAttribute("role").toString();
        return R.ok()
                .data("id", id)
                .data("username", username)
                .data("openid", openid)
                .data("email", email)
                .data("role", role);
    }

}
