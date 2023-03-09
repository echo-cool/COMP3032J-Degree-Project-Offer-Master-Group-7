package com.group7.db.jpa;

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

    @EmbeddedId
    ApplicationKey id = new ApplicationKey();

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    User user;

    @ManyToOne
    @MapsId("programId")
    @JoinColumn(name = "program_id")
    Program program;


    public Application(ApplicationKey id, User user, Program program) {
        this.id = id;
        this.user = user;
        this.program = program;
    }

    public Application() {
    }

    public ApplicationKey getId() {
        return id;
    }

    public void setId(ApplicationKey id) {
        this.id = id;
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
}
