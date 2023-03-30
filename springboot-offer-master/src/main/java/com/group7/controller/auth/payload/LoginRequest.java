package com.group7.controller.auth.payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * @Author: WangYuyang
 * @Date: 2023/3/2-17:57
 * @Project: COMP3032J_FYP_Thesis_Group_7
 * @Package: com.group7.controller.auth.reg
 * @Description:
 **/

public class LoginRequest {
    @NotBlank(message = "The email cannot be empty!")
    @Email
    private String email;

    @NotBlank(message = "The password cannot be empty!")
    private String password;

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
}