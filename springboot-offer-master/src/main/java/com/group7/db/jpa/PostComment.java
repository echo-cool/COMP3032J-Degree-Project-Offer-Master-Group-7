package com.group7.db.jpa;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "post_comment",
        uniqueConstraints = {
        })
public class PostComment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private String content;

    @ManyToOne
    @JsonManagedReference
    private User author;

    @ManyToOne
    @JsonBackReference
    private Post post;

    @Temporal(TemporalType.DATE)
    private Date createdAt = new Date();

    public PostComment() {

    }

    public String getContent() {
        return content;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public PostComment(String content, User author, Post post) {
        this.content = content;
        this.author = author;
        this.post = post;
    }
}
