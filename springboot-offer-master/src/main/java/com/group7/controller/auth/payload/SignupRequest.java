package com.group7.controller.auth.payload;

/**
 * @Author: WangYuyang
 * @Date: 2023/3/2-17:57
 * @Project: COMP3032J_FYP_Thesis_Group_7
 * @Package: com.group7.controller.auth.reg
 * @Description:
 **/
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Set;


public class SignupRequest {
    @NotBlank(message = "The username cannot be empty!")
    @Size(message = "The username should in length between {min} - {max} chars.", min = 3, max = 20)
    private String username;

    @NotBlank(message = "The email cannot be empty!")
    @Size(message = "The email cannot be more than {max} chars!", max = 50)
    @Email
    private String email;

    private Set<String> role;

    @NotBlank(message = "The password cannot be empty!")
    @Size(message = "The password length should between {min} - {max} chars", min = 6, max = 40)
    private String password;

    @NotBlank(message = "You should enter your password again!")
    @Size(message = "The password length should between {min} - {max} chars", min = 6, max = 40)
    private String RePassword;

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

    public Set<String> getRole() {
        return this.role;
    }

    public void setRole(Set<String> role) {
        this.role = role;
    }

    public String getRePassword() {
        return RePassword;
    }

    public void setRePassword(String rePassword) {
        RePassword = rePassword;
    }
}