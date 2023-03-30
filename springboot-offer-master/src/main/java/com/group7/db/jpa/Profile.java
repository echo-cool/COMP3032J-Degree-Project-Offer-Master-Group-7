package com.group7.db.jpa;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;


@Entity
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "profile")
    @JsonBackReference(value = "user-profile")
    private User user;

    // Application Target

    @Column(length = 45)
    private String applicationRound;

    @Column(length = 45)
    private String TargetDegree;

    @Column(length = 45)
    private String TargetMajor;

    @Column(length = 45)
    private String TargetOfferType;

    // Undergraduate Background

    @Column
    private double gpa;

    @Column
    private int rank;

    @Column(length = 45)
    private String underGradSchoolCate;

    @Column(length = 64)
    private String underGradSchoolName;

    @Column(length = 45)
    private String underGradMajor;

    // English Proficiency Tests

    @Column(length = 6)
    private String testType;

    @Column
    private double totalIELTS;

    @Column
    private double listeningIELTS;

    @Column
    private double speakingIELTS;

    @Column
    private double readingIELTS;

    @Column
    private double writingIELTS;

    @Column
    private int totalTOEFL;

    @Column
    private int listeningTOEFL;

    @Column
    private int speakingTOEFL;

    @Column
    private int readingTOEFL;

    @Column
    private int writingTOEFL;

    // GRE scores

    @Column
    private int greTotal;

    @Column
    private int greAnalyticalWriting;

    @Column
    private int greVerbal;

    @Column
    private int greQuantitative;



    public Profile(User user) {
        this.user = user;
    }

    public Profile(String applicationRound, String targetDegree, String targetMajor, String targetOfferType, double gpa, int rank, String underGradSchoolCate, String underGradSchoolName, String underGradMajor, String testType, double totalIELTS, double listeningIELTS, double speakingIELTS, double readingIELTS, double writingIELTS, int totalTOEFL, int listeningTOEFL, int speakingTOEFL, int readingTOEFL, int writingTOEFL, int greTotal, int greAnalyticalWriting, int greVerbal, int greQuantitative) {
        this.applicationRound = applicationRound;
        TargetDegree = targetDegree;
        TargetMajor = targetMajor;
        TargetOfferType = targetOfferType;
        this.gpa = gpa;
        this.rank = rank;
        this.underGradSchoolCate = underGradSchoolCate;
        this.underGradSchoolName = underGradSchoolName;
        this.underGradMajor = underGradMajor;
        this.testType = testType;
        this.totalIELTS = totalIELTS;
        this.listeningIELTS = listeningIELTS;
        this.speakingIELTS = speakingIELTS;
        this.readingIELTS = readingIELTS;
        this.writingIELTS = writingIELTS;
        this.totalTOEFL = totalTOEFL;
        this.listeningTOEFL = listeningTOEFL;
        this.speakingTOEFL = speakingTOEFL;
        this.readingTOEFL = readingTOEFL;
        this.writingTOEFL = writingTOEFL;
        this.greTotal = greTotal;
        this.greAnalyticalWriting = greAnalyticalWriting;
        this.greVerbal = greVerbal;
        this.greQuantitative = greQuantitative;
    }

    public Profile() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public String getApplicationRound() {
        return applicationRound;
    }

    public void setApplicationRound(String applicationRound) {
        this.applicationRound = applicationRound;
    }

    public String getTargetDegree() {
        return TargetDegree;
    }

    public void setTargetDegree(String targetDegree) {
        TargetDegree = targetDegree;
    }

    public String getTargetMajor() {
        return TargetMajor;
    }

    public void setTargetMajor(String targetMajor) {
        TargetMajor = targetMajor;
    }

    public String getTargetOfferType() {
        return TargetOfferType;
    }

    public void setTargetOfferType(String targetOfferType) {
        TargetOfferType = targetOfferType;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getUnderGradSchoolCate() {
        return underGradSchoolCate;
    }

    public void setUnderGradSchoolCate(String underGradSchoolCate) {
        this.underGradSchoolCate = underGradSchoolCate;
    }

    public String getUnderGradSchoolName() {
        return underGradSchoolName;
    }

    public void setUnderGradSchoolName(String underGradSchoolName) {
        this.underGradSchoolName = underGradSchoolName;
    }

    public String getUnderGradMajor() {
        return underGradMajor;
    }

    public void setUnderGradMajor(String underGradMajor) {
        this.underGradMajor = underGradMajor;
    }

    public String getTestType() {
        return testType;
    }

    public void setTestType(String testType) {
        this.testType = testType;
    }

    public double getTotalIELTS() {
        return totalIELTS;
    }

    public void setTotalIELTS(double totalIELTS) {
        this.totalIELTS = totalIELTS;
    }

    public double getListeningIELTS() {
        return listeningIELTS;
    }

    public void setListeningIELTS(double listeningIELTS) {
        this.listeningIELTS = listeningIELTS;
    }

    public double getSpeakingIELTS() {
        return speakingIELTS;
    }

    public void setSpeakingIELTS(double speakingIELTS) {
        this.speakingIELTS = speakingIELTS;
    }

    public double getReadingIELTS() {
        return readingIELTS;
    }

    public void setReadingIELTS(double readingIELTS) {
        this.readingIELTS = readingIELTS;
    }

    public double getWritingIELTS() {
        return writingIELTS;
    }

    public void setWritingIELTS(double writingIELTS) {
        this.writingIELTS = writingIELTS;
    }

    public int getTotalTOEFL() {
        return totalTOEFL;
    }

    public void setTotalTOEFL(int totalTOEFL) {
        this.totalTOEFL = totalTOEFL;
    }

    public int getListeningTOEFL() {
        return listeningTOEFL;
    }

    public void setListeningTOEFL(int listeningTOEFL) {
        this.listeningTOEFL = listeningTOEFL;
    }

    public int getSpeakingTOEFL() {
        return speakingTOEFL;
    }

    public void setSpeakingTOEFL(int speakingTOEFL) {
        this.speakingTOEFL = speakingTOEFL;
    }

    public int getReadingTOEFL() {
        return readingTOEFL;
    }

    public void setReadingTOEFL(int readingTOEFL) {
        this.readingTOEFL = readingTOEFL;
    }

    public int getWritingTOEFL() {
        return writingTOEFL;
    }

    public void setWritingTOEFL(int writingTOEFL) {
        this.writingTOEFL = writingTOEFL;
    }

    public int getGreTotal() {
        return greTotal;
    }

    public void setGreTotal(int greTotal) {
        this.greTotal = greTotal;
    }

    public int getGreAnalyticalWriting() {
        return greAnalyticalWriting;
    }

    public void setGreAnalyticalWriting(int greAnalyticalWriting) {
        this.greAnalyticalWriting = greAnalyticalWriting;
    }

    public int getGreVerbal() {
        return greVerbal;
    }

    public void setGreVerbal(int greVerbal) {
        this.greVerbal = greVerbal;
    }

    public int getGreQuantitative() {
        return greQuantitative;
    }

    public void setGreQuantitative(int greQuantitative) {
        this.greQuantitative = greQuantitative;
    }
}