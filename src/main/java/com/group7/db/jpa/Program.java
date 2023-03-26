package com.group7.db.jpa;

import com.fasterxml.jackson.annotation.*;
import com.group7.db.jpa.utils.EMajor;
import jakarta.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * @Author: WangYuyang
 * @Date: 2023/2/28-15:38
 * @Project: COMP3032J_FYP_Thesis_Group_7
 * @Package: com.group7.db.jpa
 * @Description:
 **/
@Entity
@Table(name = "program",
        uniqueConstraints = {
        })
//@JsonIdentityInfo(generator= ObjectIdGenerators.UUIDGenerator.class, property="@Id")
public class Program {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name = "NULL";

    @Column
    private String degree;

    @Column
    @Enumerated(EnumType.STRING)
    private EMajor major;

    @Column
    private long likes;

    @ManyToOne
    @JoinColumn(name="school")
    private School school;

    @OneToMany(mappedBy = "program")
    @JsonManagedReference(value = "program")
    private Set<Application> applications = new HashSet<>();


    public Program(String name, School school) {
        this.name = name;
        this.school = school;
        generateRandomLike();
    }

    public Program(String name, School school, String degree) {
        this.name = name;
        this.degree = degree;
        this.school = school;
        generateRandomLike();
    }

    public Program(String name, School school, String degree, EMajor major) {
        this.name = name;
        this.degree = degree;
        this.major = major;
        this.school = school;
        generateRandomLike();
    }

    public Program() {
        generateRandomLike();
    }

    /**
     * to generate random like number for a program
     */
    private void generateRandomLike(){
        Random random = new Random();
        this.likes = random.nextInt(0, 501);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public EMajor getMajor() {
        return major;
    }

    public void setMajor(EMajor major) {
        this.major = major;
    }

    @JsonBackReference
    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public long getLikes() {
        return likes;
    }

    public void setLikes(long likes) {
        this.likes = likes;
    }

    public Set<Application> getApplications() {
        return applications;
    }

    public void setApplications(Set<Application> applications) {
        this.applications = applications;
    }
}
