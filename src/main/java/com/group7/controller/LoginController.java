//package com.group7.controller;
//
//import com.group7.controller.auth.LoginDTO;
//import com.group7.controller.auth.LoginService;
//import com.group7.utils.common.R;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
///**
// * @author xujinfengxu
// */
//@RestController
//public class LoginController {
//    @Autowired
//    LoginService loginService;
//
//    @PostMapping(value = "/api/login")
//    @CrossOrigin
//    public R login(@RequestBody LoginDTO loginDTO){
//        return loginService.login(loginDTO);
//    }
//}