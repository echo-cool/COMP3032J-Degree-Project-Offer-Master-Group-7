package com.group7.db.jpa;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: WangYuyang
 * @Date: 2023/2/28-15:38
 * @Project: COMP3032J_FYP_Thesis_Group_7
 * @Package: com.group7.db.jpa
 * @Description:
 **/
@Entity
public class Program {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name = "NULL";

    @ManyToOne
//    @JoinColumn(name="program_id")
    private School school;

    @OneToOne(mappedBy = "program")
    private Application application;

    @OneToMany(mappedBy = "program", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    private Set<ProgramSelection> programSelections;


    public Program(String name, School school) {
        this.name = name;
        this.school = school;
    }

    public Program() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<ProgramSelection> getProgramSelections() {
        return programSelections;
    }

    public void setProgramSelections(Set<ProgramSelection> programSelections) {
        this.programSelections = programSelections;
    }
}
