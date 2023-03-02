package com.group7.db.jpa;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

/**
 * @Author: WangYuyang
 * @Date: 2023/2/27-16:11
 * @Project: COMP3032J_FYP_Thesis_Group_7
 * @Package: com.group7.db.jpa
 * @Description:
 **/

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 45)
    private String username;

    @Column(nullable = false, length = 45)
    private String email = "NULL";

    @Column(nullable = false, length = 45)
    private String password;

    @Column(nullable = false)
    private String avatar = "profile-01.jpg";

    @Column(nullable = false, length = 45)
    private String openId = "NULL";
    @Temporal(TemporalType.DATE)
    private Date createdAt = new Date();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profile_id", referencedColumnName = "id")
    private Profile profile = new Profile(this);
    @Column(nullable = false, length = 45)
    private String roles = "USER";

    // The applicant background of this user
    @OneToOne
    @JoinColumn(name = "background", referencedColumnName = "id")
    private Profile backgroundId;

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User(String username, String email, String password, String roles) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public User() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

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

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getRoles() {
        return roles;
    }

    public void setRole(String roles) {
        this.roles = roles;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public Profile getBackgroundId() {
        return backgroundId;
    }

    public void setBackgroundId(Profile backgroundId) {
        this.backgroundId = backgroundId;
    }
}
