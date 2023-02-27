package com.group7.controller.user;

import com.group7.db.mappers.UserMapper;
import com.group7.db.model.User;
import com.group7.db.model.UserExample;
import com.group7.utils.common.R;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;


@RestController
@RequestMapping("/secure")
public class UserController {

    @Resource
    private UserMapper userMapper;

    @RequestMapping("/user")
    public R getUser(HttpServletRequest request) {
        if (Objects.equals(request.getMethod(), "GET")) {
            String id = request.getAttribute("id").toString();
            UserExample userExample = new UserExample();
            userExample.createCriteria().andIdEqualTo(Integer.valueOf(id));
            User user = userMapper.selectByExample(userExample).get(0);
            if (user != null) {
                return R.ok().data("data", user);
            } else {
                return R.error();
            }
        } else if (Objects.equals(request.getMethod(), "POST")) {
            return R.ok().message("post");
        } else if (Objects.equals(request.getMethod(), "PUT")) {
            return R.ok().message("put");
        } else if (Objects.equals(request.getMethod(), "DELETE")) {
            return R.ok().message("delete");
        } else {
            return R.error().message("error");

        }

    }
//    @RequestMapping("/getUserInfo")
//    public R getUserInfo(HttpServletRequest request) {
//        String id = request.getAttribute("id").toString();
//        String username = request.getAttribute("username").toString();
//        String openid = request.getAttribute("openid").toString();
//        String email = request.getAttribute("email").toString();
//        String role = request.getAttribute("role").toString();
//        return R.ok()
//                .data("id", id)
//                .data("username", username)
//                .data("openid", openid)
//                .data("email", email)
//                .data("role", role);
//    }

}
