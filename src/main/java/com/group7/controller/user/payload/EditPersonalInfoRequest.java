package com.group7.controller.user.payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * @Author: LiuZhe
 * @Date: 2023/3/5 - 22:44
 */
public class EditPersonalInfoRequest {

    @NotBlank(message = "The email cannot be empty!")
    @Size(message = "The email cannot be more than {max} chars!", max = 50)
    @Email
    private String email;

    @NotBlank(message = "The username cannot be empty!")
    @Size(message = "The username should in length between {min} - {max} chars.", min = 3, max = 20)
    private String username;

    @Size(message = "Your introduction cannot exceed {max} chars.", max = 1200)
    private String bio;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
