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

    @RequestMapping("/getUser")
    public R getUser(HttpServletRequest request) {
        if (Objects.equals(request.getMethod(), "GET")) {
            String id = request.getAttribute("id").toString();
            User user = userRepository.findById(Long.valueOf(id)).orElse(null);
            if (user != null) {
                return R.ok().data("data", user);
            } else {
                return R.error();
            }
        } else {
            return R.error().message("error");

        }

    }

}
