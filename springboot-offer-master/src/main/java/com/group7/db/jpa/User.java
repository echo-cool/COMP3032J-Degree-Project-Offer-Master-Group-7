package com.group7.db.jpa;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: WangYuyang
 * @Date: 2023/2/27-16:11
 * @Project: COMP3032J_FYP_Thesis_Group_7
 * @Package: com.group7.db.jpa
 * @Description:
 **/

@Entity
@Table(name = "user",
        uniqueConstraints = {
        })
//@JsonIdentityInfo(generator= ObjectIdGenerators.UUIDGenerator.class, property="@Id")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    @Size(max = 20)
    private String username;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @NotBlank
    @Size(max = 120)
    private String password;

    @Size(max = 1200)
    private String bio = ""; // self-intro

    @Column
    private String avatar = "default/default-avatar.jpg";

    @Column(nullable = false, length = 45)
    private String openId = "NULL";

    @Temporal(TemporalType.DATE)
    private Date createdAt = new Date();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profile_id", referencedColumnName = "id")
    @JsonManagedReference
    private Profile profile = new Profile(this);

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_liked_programs",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "program_id"))
    @JsonManagedReference
    private Set<Program> likedPrograms = new HashSet<>();

    @OneToMany(mappedBy = "user")
    @JsonManagedReference(value = "applications")
    private Set<Application> applications = new HashSet<>();




    public User(String username, String email, String password, Set<Role> roles) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Set<Program> getLikedPrograms() {
        return likedPrograms;
    }

    public void setLikedPrograms(Set<Program> likedPrograms) {
        this.likedPrograms = likedPrograms;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Set<Application> getApplications() {
        return applications;
    }

    public void setApplications(Set<Application> applications) {
        this.applications = applications;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", bio='" + bio + '\'' +
                ", avatar='" + avatar + '\'' +
                ", openId='" + openId + '\'' +
                ", createdAt=" + createdAt +
                ", profile=" + profile +
                ", roles=" + roles +
                ", likedPrograms=" + likedPrograms.size() +
                ", applications=" + applications +
                '}';
    }
}
