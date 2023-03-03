package com.group7.controller.auth.payload;

import jakarta.validation.constraints.NotBlank;

/**
 * @Author: WangYuyang
 * @Date: 2023/3/2-17:57
 * @Project: COMP3032J_FYP_Thesis_Group_7
 * @Package: com.group7.controller.auth.reg
 * @Description:
 **/

public class LoginRequest {
    @NotBlank
    private String username;

    @NotBlank
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}