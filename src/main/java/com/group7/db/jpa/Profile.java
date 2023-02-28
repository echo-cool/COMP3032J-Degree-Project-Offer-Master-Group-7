package com.group7.db.jpa;

import jakarta.persistence.*;
import lombok.Data;


@Entity
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "profile")
    private User user;

    @Column(nullable = false)
    private String GPA = "NULL";

    public Profile(User user) {
        this.user = user;
    }

    public Profile() {

    }
}