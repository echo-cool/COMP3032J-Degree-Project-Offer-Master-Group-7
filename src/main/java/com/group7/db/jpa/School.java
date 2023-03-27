package com.group7.db.jpa;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: WangYuyang
 * @Date: 2023/2/28-15:38
 * @Project: COMP3032J_FYP_Thesis_Group_7
 * @Package: com.group7.db.jpa
 * @Description:
 **/
@Entity
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name = "NULL";

    @Column
    private int rankQS;

    @Column
    private int rankUSNews;

    @Column
    private String logo = "default/default-logo.jpg";

    @Column
    private String img = "default/default.jpg";

    @OneToMany(mappedBy="school")
    @JsonManagedReference(value = "programs")
    private Set<Program> programs = new HashSet<>();

    public School(String name, Set<Program> programs) {
        this.name = name;
        this.programs = programs;
    }

    public School(String name) {
        this.name = name;
    }

    public School(String name, String img) {
        this.name = name;
        this.img = img;
    }

    public School(String name, int rankQS, int rankUSNews) {
        this.name = name;
        this.rankQS = rankQS;
        this.rankUSNews = rankUSNews;
    }

    public School(String name, int rankQS, int rankUSNews, String logo, String img) {
        this.name = name;
        this.rankQS = rankQS;
        this.rankUSNews = rankUSNews;
        this.logo = "upload/img/" + logo;
        this.img = "upload/img/" +img;
    }

    public School(String name, int rankQS, int rankUSNews, String img) {
        this.name = name;
        this.rankQS = rankQS;
        this.rankUSNews = rankUSNews;
        this.img = "upload/img/" + img;
    }

    public School() {

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

    @JsonManagedReference
    public Set<Program> getPrograms() {
        return programs;
    }

    public void setPrograms(Set<Program> programs) {
        this.programs = programs;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = "upload/img/" + img;
    }

    public int getRankQS() {
        return rankQS;
    }

    public void setRankQS(int rankQS) {
        this.rankQS = rankQS;
    }

    public int getRankUSNews() {
        return rankUSNews;
    }

    public void setRankUSNews(int rankUSNews) {
        this.rankUSNews = rankUSNews;
    }
}
