package com.group7.controller.user;


import com.auth0.jwt.interfaces.Claim;
import com.group7.db.jpa.User;
import com.group7.db.jpa.UserRepository;
import com.group7.utils.common.JwtUtils;
import com.group7.utils.common.R;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Objects;


@RestController
@RequestMapping("/secure")
public class UserController {

    @Resource
    private UserRepository userRepository;

    @Resource
    JwtUtils jwtUtils;

    @RequestMapping("/getUser")
    public R getUser(HttpServletRequest request) {
        if (Objects.equals(request.getMethod(), "GET")) {
            String token = request.getHeader("Authorization");

            String username = jwtUtils.getUserNameFromJwtToken(token.split(" ")[1]);

//            String id = request.getAttribute("id").toString();
            User user = userRepository.findByUsername(username).orElse(null);

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
