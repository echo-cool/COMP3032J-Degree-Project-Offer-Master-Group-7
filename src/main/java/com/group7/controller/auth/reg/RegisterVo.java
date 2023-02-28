package com.group7.controller.auth.reg;

/**
 * @Author: LiuZhe
 * @Date: 2023/2/28 - 21:32
 */
public class RegisterVo {
    private String username;

    private String email;

    private String password;

    private String rePassword;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRePassword() {
        return rePassword;
    }

    public void setRePassword(String rePassword) {
        this.rePassword = rePassword;
    }
}
