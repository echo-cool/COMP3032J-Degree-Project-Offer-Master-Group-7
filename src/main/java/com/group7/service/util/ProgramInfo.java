package com.group7.service.util;

import com.group7.db.jpa.Program;

public class ProgramInfo {
    Program program;

    Double avgGPA;

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
            case "gpa":
                this.setAvgGPA(value);
                break;
            case "ielts":
                break;
            case "tofel":
                break;
        }
    }

    public ProgramInfo(Program program) {
        this.program = program;
    }
}
