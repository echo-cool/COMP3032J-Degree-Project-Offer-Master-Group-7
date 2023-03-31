package com.group7.db.jpa;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "post",
        uniqueConstraints = {
        })
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @ManyToOne
    private PostCategory category;

    @Column
    private String img = "default/default.jpg";

    @ManyToOne
    private User author;

    @OneToMany(mappedBy = "post")
    @JsonManagedReference(value = "comments")
    private Set<PostComment> comments = new HashSet<>();

    @Temporal(TemporalType.DATE)
    private Date createdAt = new Date();

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public PostCategory getCategory() {
        return category;
    }

    public void setCategory(PostCategory category) {
        this.category = category;
    }

    public Post() {

    }

    public String getImg() {
        return img;
    }

    public Post(String title, String content, PostCategory category, String img, User author) {
        this.title = title;
        this.content = content;
        this.category = category;
        this.img = img;
        this.author = author;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Post(String title, String content, PostCategory category, User author) {
        this.title = title;
        this.content = content;
        this.category = category;
        this.author = author;
    }
}
