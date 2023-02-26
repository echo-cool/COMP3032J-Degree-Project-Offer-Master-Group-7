package com.group7.controller.auth;

import com.group7.utils.common.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @GetMapping(value = "/hello")
    public R hello(){
        return R.ok().message("hello");
    }
}
