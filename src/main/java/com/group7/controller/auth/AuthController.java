package com.group7.controller.auth;

import com.group7.controller.auth.reg.RegisterService;
import com.group7.controller.auth.reg.RegisterVo;
import com.group7.db.jpa.User;
import com.group7.utils.common.JwtUtil;
import com.group7.utils.common.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: WangYuyang
 * @Date: 2023/2/26-18:00
 * @Project: COMP3032J_FYP_Thesis_Group_7
 * @Package: com.group7.controller
 * @Description:
 **/
@RestController
@RequestMapping(value = "/api")
public class AuthController {
    @Autowired
    LoginService loginService;

    @Autowired
    RegisterService registerService;

    @GetMapping(value = "/hello")
    public R hello() {
        return R.ok().message("hello");
    }


    @PostMapping(value = "/login")
    @CrossOrigin
    public R login(@RequestBody LoginDTO loginDTO) {
        return loginService.login(loginDTO);
    }

    @PostMapping(value = "/logout")
    @CrossOrigin
    public R logout() {
        return R.ok();
    }


    @PostMapping(value = "/register")
    public R register(@RequestBody RegisterVo registerVo){
        return registerService.register(registerVo);
    }

    @GetMapping(value = "/getUserInfo")
    public R getUserByToken(String token){
        Long userId = JwtUtil.getUserIdByToken(token);
        // query user from db
        User user = registerService.getUserById(userId);
        if (user == null){
            return R.error().message("User not found");
        }
        return R.ok().data("user", user);
    }

}
