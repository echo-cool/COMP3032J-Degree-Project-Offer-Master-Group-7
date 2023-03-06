package com.group7.controller.user.payload;

import jakarta.validation.constraints.Digits;

/**
 * @Author: LiuZhe
 * @Date: 2023/3/7 - 1:27
 */
public class EditBackgroundRequest {

    @Digits(message = "GPA should range from 0 to 4 with at most two decimal digits.", integer = 1, fraction = 2)
    private double gpa;

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
}
