package com.group7.service.util;

import com.group7.db.jpa.Program;

public class ProgramInfo {
    Program program;

    Double avgGPA;

    Double avgIELTS;

    Double avgTOEFL;

    Double avgRank;

    public void setAvgRank(Double avgRank) {
        this.avgRank = avgRank;
    }

    public Double getAvgIELTS() {
        return avgIELTS;
    }

    public void setAvgIELTS(Double avgIELTS) {
        this.avgIELTS = avgIELTS;
    }

    public Double getAvgTOEFL() {
        return avgTOEFL;
    }

    public void setAvgTOEFL(Double avgTOEFL) {
        this.avgTOEFL = avgTOEFL;
    }

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }

    public Double getAvgGPA() {
        return avgGPA;
    }

    public void setAvgGPA(Double avgGPA) {
        this.avgGPA = avgGPA;
    }

    public void setEntry(String entryName, Double value) {
        switch (entryName) {
            case "gpa" -> this.setAvgGPA(value);
            case "ielts" -> this.setAvgIELTS(value);
            case "toefl" -> this.setAvgTOEFL(value);
            case "rank" -> this.setAvgRank(value);
        }
    }

    public ProgramInfo(Program program) {
        this.program = program;
    }

    public Double getAvgRank() {
        return avgRank;
    }
}
