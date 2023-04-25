package com.group7.db.jpa;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

/**
 * @Author: LiuZhe
 * @Date: 2023/4/25 - 21:52
 */
@Entity
@Table(name = "grade",
        uniqueConstraints = {
        })
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JsonBackReference
    private User user;

    @Column
    private String courseName;

    @Column
    private String grade;

    @Column
    private double credits;

    @Column
    private double gradePointUS;


    public Grade(){}

    public Grade(User user, String courseName, String grade, double credits, double gradePointUS) {
        this.user = user;
        this.courseName = courseName;
        this.grade = grade;
        this.credits = credits;
        this.gradePointUS = gradePointUS;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public double getCredits() {
        return credits;
    }

    public void setCredits(double credits) {
        this.credits = credits;
    }

    public double getGradePointUS() {
        return gradePointUS;
    }

    public void setGradePointUS(double gradePointUS) {
        this.gradePointUS = gradePointUS;
    }
}
