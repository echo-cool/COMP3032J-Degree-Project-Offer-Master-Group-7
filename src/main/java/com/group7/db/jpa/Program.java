package com.group7.db.jpa;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;

import java.util.Date;
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
@Table(name = "program",
        uniqueConstraints = {
//                @UniqueConstraint(columnNames = "username"),
//                @UniqueConstraint(columnNames = "email")
        })
@JsonIdentityInfo(generator= ObjectIdGenerators.UUIDGenerator.class, property="@Id")
public class Program {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name = "NULL";

    @Column
    private String status;  // admitted, rejected, awaiting review, awaiting decision

    @Column
    private String degree; // Phd, MS, MEng...

    @Temporal(TemporalType.DATE)
    private Date deadLine;

    @ManyToOne
//    @JoinColumn(name="program_id")
    private School school;

//    @OneToOne(mappedBy = "program")
//    private Application application;

//    @OneToMany(mappedBy = "program", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
//    @JsonManagedReference
//    private Set<ProgramSelection> programSelections;

    // who selected this program in their list
//    @ManyToMany(mappedBy = "selectedPrograms",fetch = FetchType.EAGER, cascade = {CascadeType.MERGE}) //建议MERGE//mappedBy对方配置关系的属性名称,表示由对方来维护中间表关系
//    private Set<User> users = new HashSet<>();

//    @JsonBackReference
//    @ManyToMany(mappedBy = "selectedPrograms") //建议MERGE//mappedBy对方配置关系的属性名称,表示由对方来维护中间表关系
//    private Set<User> users = new HashSet<>();

//    @JsonIgnore
//    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE})
//    @JoinTable(name = "user_programs",
//            joinColumns = {@JoinColumn(name = "program_id", referencedColumnName = "id")},
//            inverseJoinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")})
//    private Set<User> users = new HashSet<>();

    @OneToMany(mappedBy = "program")
    Set<Application> applications = new HashSet<>();


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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public Date getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(Date deadLine) {
        this.deadLine = deadLine;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public Set<Application> getApplications() {
        return applications;
    }

    public void setApplications(Set<Application> applications) {
        this.applications = applications;
    }
}
