package com.group7.controller.auth;

import com.group7.utils.common.R;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: WangYuyang
 * @Date: 2023/2/26-22:29
 * @Project: COMP3032J_FYP_Thesis_Group_7
 * @Package: com.group7.controller.auth
 * @Description:
 **/
@RestController
@RequestMapping(value = "/secure")
public class SecureController {
    private final Logger logger = LoggerFactory.getLogger(SecureController.class);
    @RequestMapping("/getUserInfo")
    public R getUserInfo(HttpServletRequest request) {
        String id = request.getAttribute("id").toString();
        String name = request.getAttribute("name").toString();
        String openid = request.getAttribute("openid").toString();
        return R.ok().data("id", id).data("name", name).data("openid", openid);
    }
}
