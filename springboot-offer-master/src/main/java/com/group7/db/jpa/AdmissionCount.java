package com.group7.db.jpa;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

/**
 * @Author: LiuZhe
 * @Date: 2023/5/10 - 19:01
 */
@Entity
@Table(name = "admissionCount",
        uniqueConstraints = {
        })
public class AdmissionCount {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JsonBackReference
    private Program program;

    @Column
    private int weekNum;

    @Column
    private Long admissionCount;

    @Column
    private int whichYear; // 0 this year, 1 last year

    public AdmissionCount() {

    }


    public AdmissionCount(Program program, int whichYear, int weekNum, Long admissionCount) {
        this.program = program;
        this.whichYear = whichYear;
        this.weekNum = weekNum;
        this.admissionCount = admissionCount;
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

    public int getWeekNum() {
        return weekNum;
    }

    public void setWeekNum(int weekNum) {
        this.weekNum = weekNum;
    }

    public Long getAdmissionCount() {
        return admissionCount;
    }

    public void setAdmissionCount(Long admissionCount) {
        this.admissionCount = admissionCount;
    }

    public int getWhichYear() {
        return whichYear;
    }

    public void setWhichYear(int whichYear) {
        this.whichYear = whichYear;
    }
}
