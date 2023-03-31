package com.group7.db.jpa;

import com.group7.db.jpa.utils.ERole;
import jakarta.persistence.*;

@Entity
@Table(name = "post_category",
        uniqueConstraints = {
        })
public class PostCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(nullable = false)
    private String name;

    public PostCategory() {

    }

    public PostCategory(String name) {
        this.name = name;
    }

}
