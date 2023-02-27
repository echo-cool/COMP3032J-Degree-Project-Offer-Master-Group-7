package com.group7.controller.user;


import com.group7.db.jpa.User;
import com.group7.db.jpa.UserRepository;
import com.group7.utils.common.R;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;


@RestController
@RequestMapping("/secure")
public class UserController {

    @Resource
    private UserRepository userRepository;

    @RequestMapping("/user")
    public R getUser(HttpServletRequest request) {
        if (Objects.equals(request.getMethod(), "GET")) {
            String id = request.getAttribute("id").toString();
            User user = userRepository.findById(Long.valueOf(id)).orElse(null);
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
