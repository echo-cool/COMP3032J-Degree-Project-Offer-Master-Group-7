package com.group7.db.jpa;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Accessors(chain = true)
@Table(name = "article",
        uniqueConstraints = {
        })
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @ManyToOne
    private User user;

    @Temporal(TemporalType.DATE)
    private Date createdAt = new Date();


    public Article(String title, String content, User user) {
        this.title = title;
        this.content = content;
        this.user = user;
    }


    public Article() {
    }
}
