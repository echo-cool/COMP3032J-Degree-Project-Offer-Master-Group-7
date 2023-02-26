package com.group7.controller;

import com.group7.utils.common.R;
import org.springframework.web.bind.annotation.*;

/**
 * @author xujinfengxu
 */
@RestController
@RequestMapping("/admin/user")
//@Api(tags = "admin login controller")
@CrossOrigin
public class LoginController {
    /**
     * login
     */
//    @ApiOperation("login")
    @RequestMapping("login")
    public R login(){
        return R.ok().data("token","admin");
    }

    /**
     * info
     */
//    @ApiOperation("getInfo")
    @RequestMapping("info")
    public R info(){
        return R.ok().data("roles","admin")
                .data("name","admin")
                .data("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
    }
}
