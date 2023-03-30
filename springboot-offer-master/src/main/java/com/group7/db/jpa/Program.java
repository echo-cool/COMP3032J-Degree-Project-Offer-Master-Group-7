package com.group7.db.jpa;

import com.fasterxml.jackson.annotation.*;
import com.group7.db.jpa.utils.EMajor;
import com.group7.db.jpa.utils.ESource;
import com.group7.db.jpa.utils.RandomSchoolImage;
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
    private ESource source = ESource.USER;

    @Column
    private String degree;

    @Column
    @Enumerated(EnumType.STRING)
    private EMajor major;

    @Column
    private long likes;

    @ManyToMany(mappedBy = "likedPrograms")
    @JsonBackReference
    private Set<User> likeUsers = new HashSet<>();

    @ManyToOne
    @JoinColumn(name="school")
    private School school;

    @Column
    private String img = "default/default.jpg";

    @OneToMany(mappedBy = "program")
    @JsonManagedReference(value = "program")
    private Set<Application> applications = new HashSet<>();


    public Program(String fullName, ESource source, String degree, School school) {
        this.name = fullName;
        this.source = ESource.OPENCS;
        this.degree = degree;
        this.school = school;
        this.major = EMajor.CS;
        generateRandomLike();
        this.img = RandomSchoolImage.getRandomProgramImage();
    }

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

    public Program(String name, School school, String degree, EMajor major, String img) {
        this.name = name;
        this.degree = degree;
        this.major = major;
        this.school = school;
        generateRandomLike();
        this.img = "upload/img/" + img;
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
        return likes + this.likeUsers.size();
    }

    public void setLikes(long likes) {
        this.likes = likes;
    }

    public Set<User> getLikeUsers() {
        return likeUsers;
    }

    public void setLikeUsers(Set<User> likeUsers) {
        this.likeUsers = likeUsers;
    }

    public Set<Application> getApplications() {
        return applications;
    }

    public void setApplications(Set<Application> applications) {
        this.applications = applications;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
