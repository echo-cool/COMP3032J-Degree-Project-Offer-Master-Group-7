package com.group7.controller.auth;

/**
 * @Author: WangYuyang
 * @Date: 2023/2/26-18:23
 * @Project: COMP3032J_FYP_Thesis_Group_7
 * @Package: com.group7.controller.auth
 * @Description:
 **/
public class LoginDTO {
    private String username;
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