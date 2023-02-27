package com.group7.controller.admin;

import com.group7.utils.common.R;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: WangYuyang
 * @Date: 2023/2/27-12:59
 * @Project: COMP3032J_FYP_Thesis_Group_7
 * @Package: com.group7.controller.admin
 * @Description:
 **/
@RestController
@RequestMapping("/admin")
public class AdminController {
    @RequestMapping("/isAdmin")
    public R getUser(HttpServletRequest request) {
        Boolean isAdmin = (Boolean) request.getAttribute("isAdmin");
        if (isAdmin == null || !isAdmin) {
            return R.error().message("not admin");
        }
        return R.ok().message("admin user");
    }
}
