package com.group7.controller.auth;

import com.group7.utils.common.R;
import jakarta.servlet.http.HttpServletRequest;
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

    @GetMapping(value = "/hello")
    public R hello() {
        return R.ok().message("hello");
    }


    @PostMapping(value = "/login")
    @CrossOrigin
    public R login(@RequestBody LoginDTO loginDTO) {
        return loginService.login(loginDTO);
    }


}
