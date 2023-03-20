package com.group7.controller.user.payload;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Range;

/**
 * @Author: LiuZhe
 * @Date: 2023/3/7 - 1:27
 */
public class EditBackgroundRequest {

    // Application Target

    @NotBlank(message = "You should select your application round.")
    @Size(message = "The application round should between {min} and {max} chars.", min = 1, max = 45)
    private String applicationRound;

    @NotBlank(message = "You should select your target degree.")
    @Size(message = "The target degree should between {min} and {max} chars.", min = 1, max = 45)
    private String targetDegree;

    @NotBlank(message = "You should select your target major.")
    @Size(message = "The target major should between {min} and {max} chars.", min = 1, max = 45)
    private String targetMajor;

    @NotBlank(message = "You should select your target offer type.")
    @Size(message = "The target offer type should between {min} and {max} chars.", min = 1, max = 45)
    private String targetOfferType;

    // Undergraduate Background

    @NotNull(message = "You should input your GPA.")
    @Digits(message = "GPA should range from 0 to 4 with at most two decimal digits.", integer = 1, fraction = 2)
    @Range(message = "GPA should range from {min} to {max}", min = 0, max = 4)
    private double gpa;

    @NotNull(message = "You should input the rank.")
    @Range(message = "The rank should larger than or equal to {min}", min = 1)
    private int rank;

    @NotBlank(message = "You should select the classification for your undergraduate school.")
    @Size(message = "The classification should between {min} and {max} chars.", min = 1, max = 45)
    private String underGradSchoolCate;

    @NotBlank(message = "You should input your undergraduate school.")
    @Size(message = "The school name should between {min} and {max} chars.", min = 1, max = 64)
    private String underGradSchoolName;

    @NotBlank(message = "You should select the your undergraduate major.")
    @Size(message = "The undergrad major should between {min} and {max} chars.", min = 1, max = 45)
    private String underGradMajor;

    // English Proficiency Tests

    @NotBlank(message = "You should select your English Proficiency Test type.")
    @Size(message = "The English Proficiency Test type should between {min} and {max} chars.", min = 1, max = 6)
    private String testType;

    @Digits(message = "IELTS score should range from 0 to 9 with at most one decimal digits.", integer = 1, fraction = 1)
    @Range(message = "IELTS score should range from {min} to {max}", min = 0, max = 9)
    private double totalIELTS;

    @Digits(message = "IELTS listening score should range from 0 to 9 with at most one decimal digits.", integer = 1, fraction = 1)
    @Range(message = "IELTS score should range from {min} to {max}", min = 0, max = 9)
    private double listeningIELTS;

    @Digits(message = "IELTS speaking score should range from 0 to 9 with at most one decimal digits.", integer = 1, fraction = 1)
    @Range(message = "IELTS score should range from {min} to {max}", min = 0, max = 9)
    private double speakingIELTS;

    @Digits(message = "IELTS reading score should range from 0 to 9 with at most one decimal digits.", integer = 1, fraction = 1)
    @Range(message = "IELTS score should range from {min} to {max}", min = 0, max = 9)
    private double readingIELTS;

    @Digits(message = "IELTS writing score should range from 0 to 9 with at most one decimal digits.", integer = 1, fraction = 1)
    @Range(message = "IELTS score should range from {min} to {max}", min = 0, max = 9)
    private double writingIELTS;

    @Range(message = "The TOEFL score should range from {min} to {max}", min = 0, max = 120)
    private int totalTOEFL;

    @Range(message = "The TOEFL listening score should range from {min} to {max}", min = 0, max = 30)
    private int listeningTOEFL;

    @Range(message = "The TOEFL speaking score should range from {min} to {max}", min = 0, max = 30)
    private int speakingTOEFL;

    @Range(message = "The TOEFL reading score should range from {min} to {max}", min = 0, max = 30)
    private int readingTOEFL;

    @Range(message = "The TOEFL writing score should range from {min} to {max}", min = 0, max = 30)
    private int writingTOEFL;

    // GRE scores

    @NotNull(message = "You should input your total GRE score.")
    @Range(message = "The GRE score should range from {min} to {max}", min = 260, max = 346)
    private int greTotal;

    @NotNull(message = "You should input your GRE Analytical Writing score.")
    @Range(message = "The GRE Analytical Writing score should range from {min} to {max}", min = 0, max = 6)
    private int greAnalyticalWriting;

    @NotNull(message = "You should input your GRE Verbal score.")
    @Range(message = "The GRE Verbal score should range from {min} to {max}", min = 130, max = 170)
    private int greVerbal;

    @NotNull(message = "You should input your GRE Quantitative score.")
    @Range(message = "The GRE Quantitative score should range from {min} to {max}", min = 130, max = 170)
    private int greQuantitative;


    /* ----------------------------------------------------------- */

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
        return targetDegree;
    }

    public void setTargetDegree(String targetDegree) {
        this.targetDegree = targetDegree;
    }

    public String getTargetMajor() {
        return targetMajor;
    }

    public void setTargetMajor(String targetMajor) {
        this.targetMajor = targetMajor;
    }

    public String getTargetOfferType() {
        return targetOfferType;
    }

    public void setTargetOfferType(String targetOfferType) {
        this.targetOfferType = targetOfferType;
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
