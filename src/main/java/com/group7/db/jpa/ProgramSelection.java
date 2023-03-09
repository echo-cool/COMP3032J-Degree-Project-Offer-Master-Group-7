package com.group7.db.jpa;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: LiuZhe
 * @Date: 2023/3/8 - 17:00
 */
@Entity
public class ProgramSelection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH}, optional=false)     // optional=false, means user cannot be null. delete the selection, the user will not be affected
    @JoinColumn(name="user_id")     // The foreign key in this ProgramSelection table
    @JsonBackReference
    private User user;

    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH}, optional=false)     // optional=false, means program cannot be null. delete the selection, the program will not be affected
    @JoinColumn(name="program_id")     // The foreign key in this ProgramSelection table
    @JsonBackReference
    private Program program;

    public ProgramSelection(User user, Program program) {
        this.user = user;
        this.program = program;
    }

    public ProgramSelection() {

    }

    public Long getId() {
        return id;
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
