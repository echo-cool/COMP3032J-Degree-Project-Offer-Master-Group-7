package com.group7.db.jpa;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.group7.utils.common.MyRandomUtils;
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

    @Column(nullable = false)
    private String lat;     // Latitude for virtual campus tour

    @Column(nullable = false)
    private String lng;     // Longitude for virtual campus tour

    @Column
    private String logo = "default/default-logo.jpg";

    @Column
    private String img = "default/default.jpg";

    @OneToMany(mappedBy="school")
    @JsonManagedReference(value = "programs")
    private Set<Program> programs = new HashSet<>();

    private String extraImages = "default/default.jpg;default/default.jpg;default/default.jpg";

    @Column
    private long likes = MyRandomUtils.getRandomInt(100, 3200);

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

    public School(String name, int rankQS, int rankUSNews, String logo, String img, String lat, String lng, String[] extraImages) {
        this.name = name;
        this.rankQS = rankQS;
        this.rankUSNews = rankUSNews;
        this.logo = "upload/img/" + logo;
        this.img = "upload/img/" +img;
        this.lat = lat;
        this.lng = lng;
        List<String> tmp = new ArrayList<>(Arrays.asList(extraImages));
        tmp.add(0, this.logo);
        tmp.add(0, this.img);

        setExtraImages(tmp.toArray(new String[]{}));
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

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String[] getExtraImages() {
        return extraImages.split(";");
    }

    public void setExtraImages(String[] extraImages) {
        this.extraImages = String.join(";", extraImages);
    }


    public long getLikes() {
        return likes;
    }

    public void setLikes(long likes) {
        this.likes = likes;
    }
}
