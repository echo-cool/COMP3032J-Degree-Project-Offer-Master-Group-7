package com.group7.controller.user.payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Set;

/**
 * @Author: LiuZhe
 * @Date: 2023/3/5 - 20:26
 */
public class ChangePasswordRequest {

    @NotBlank(message = "You should fill in all the blanks!")
    @Size(message = "The email cannot be more than {max} chars!", max = 50)
    @Email
    private String email;

    @NotBlank(message = "You should fill in all the blanks!")
    private String oldPassword;

    @NotBlank(message = "You should fill in all the blanks!")
    @Size(message = "The password length should between {min} - {max} chars", min = 6, max = 40)
    private String newPassword;

    @NotBlank(message = "You should fill in all the blanks!")
    @Size(message = "The password length should between {min} - {max} chars", min = 6, max = 40)
    private String reNewPassword;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getReNewPassword() {
        return reNewPassword;
    }

    public void setReNewPassword(String reNewPassword) {
        this.reNewPassword = reNewPassword;
    }
}
