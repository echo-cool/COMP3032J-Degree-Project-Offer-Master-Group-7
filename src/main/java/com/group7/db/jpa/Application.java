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
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private Program program;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }
}
