package com.group7.db.jpa;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.group7.db.jpa.utils.EStatus;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: WangYuyang
 * @Date: 2023/3/6-20:27
 * @Project: COMP3032J_FYP_Thesis_Group_7
 * @Package: com.group7.db.jpa
 * @Description:
 **/
@Entity
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JsonManagedReference(value = "user")
    private User user;

    @ManyToOne
    @JsonManagedReference
    private Program program;

    @Column(nullable = false)
    private EStatus eStatus = EStatus.NULL;


    public Application(User user, Program program) {
        this.user = user;
        this.program = program;
    }

    public Application(User user, Program program, EStatus eStatus) {
        this.user = user;
        this.program = program;
        this.eStatus = eStatus;
    }

    public Application() {
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
