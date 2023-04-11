package com.group7.db.jpa;

import com.fasterxml.jackson.annotation.*;
import com.group7.db.jpa.utils.EMajor;
import com.group7.db.jpa.utils.ESource;
import com.group7.db.jpa.utils.RandomSchoolImage;
import jakarta.persistence.*;

import java.util.*;

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
public class Program implements Cloneable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    private long likesNumber;

    @ManyToMany(mappedBy = "likedPrograms")
    @JsonBackReference
    private Set<User> likeUsers = new HashSet<>();

    @ManyToOne
    @JoinColumn(name="school")
    private School school;

    @Column
    private String img = "default/default.jpg";

    @Column
    private String extraImages = "default/default.jpg;default/default.jpg;default/default.jpg";

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
        this.extraImages = RandomSchoolImage.getRandomImage() + ";" + RandomSchoolImage.getRandomImage() + ";" + RandomSchoolImage.getRandomImage();
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
        this.likesNumber = random.nextInt(0, 501);
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

    public School getSchool() {
        School newSchool = this.school.clone();
        newSchool.setPrograms(null);
        return newSchool;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public long getLikesNumber() {
        return likesNumber + this.likeUsers.size();
    }

    public void setLikesNumber(long likes) {
        this.likesNumber = likes;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Program program = (Program) o;
        return id.equals(program.id);
    }

    public ESource getSource() {
        return source;
    }

    public void setSource(ESource source) {
        this.source = source;
    }

    public String[] getExtraImages() {
        return extraImages.split(";");
    }

    public void setExtraImages(String[] extraImages) {
        this.extraImages = String.join(";", extraImages);
    }



    @Override
    public String toString() {
        return "Program{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", source=" + source +
                ", degree='" + degree + '\'' +
                ", major=" + major +
                ", likesNumber=" + likesNumber +
                ", likeUsers=" + likeUsers +
                ", school=" + school +
                ", img='" + img + '\'' +
                ", applications=" + applications +
                '}';
    }

    @Override
    public Program clone() {
        try {
            return (Program) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
