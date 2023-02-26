package com.group7.controller.auth;

import com.group7.utils.common.R;

/**
 * @Author: WangYuyang
 * @Date: 2023/2/26-18:22
 * @Project: COMP3032J_FYP_Thesis_Group_7
 * @Package: com.group7.controller.auth
 * @Description:
 **/
public interface LoginService {
    public R login(LoginDTO loginDTO);
}