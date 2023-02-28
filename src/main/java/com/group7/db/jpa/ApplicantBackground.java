package com.group7.db.jpa;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;


@Entity
public class ApplicantBackground {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date createdAt = new Date();

    /* target program related */
    @Column(nullable = false, length = 45)
    private String enrollYear;

    @Column(nullable = false, length = 16)
    private String targetDegree;

    @Column(nullable = false, length = 32)
    private String targetProgram;

    @Column(nullable = false, length = 16)
    private String targetFellowship;

    /* undergraduate record related */
    // 211, 985, 海本...
    @Column(nullable = false, length = 32)
    private String undergradLevel;

    @Column(nullable = false, length = 64)
    private String undergradSchool;

    @Column(nullable = false, length = 64)
    private String undergradProgram;

    @Column(nullable = false, precision = 3, scale = 2)
    private BigDecimal gpaOrigin;

    @Column(precision = 3, scale = 2)
    private BigDecimal gpaConverted;

    @Column
    private int undergradRank;

    /* Language Tests */
    // IELTS or TOEFL
    @Column(nullable = false)
    private String languageTestType;

    /* Language Tests - IELTS */
    @Column(precision = 2, scale = 1)
    private BigDecimal IELTSTotal;

    @Column(precision = 2, scale = 1)
    private BigDecimal IELTSListening;

    @Column(precision = 2, scale = 1)
    private BigDecimal IELTSSpeaking;

    @Column(precision = 2, scale = 1)
    private BigDecimal IELTSReading;

    @Column(precision = 2, scale = 1)
    private BigDecimal IELTSWriting;

    /* Language Tests - TOEFL */
    @Column
    private int TOEFLTotal;

    @Column
    private int TOEFLListening;

    @Column
    private int TOEFLSpeaking;

    @Column
    private int TOEFLReading;

    @Column
    private int TOEFLWriting;


    // The owner user of this application background
    @OneToOne(mappedBy = "background")
    private User user;

    /* constructors */
    public ApplicantBackground(String enrollYear, String targetDegree, String targetProgram, String targetFellowship, String undergradLevel, String undergradSchool, String undergradProgram, BigDecimal gpaOrigin, String languageTestType, User user) {
        this.enrollYear = enrollYear;
        this.targetDegree = targetDegree;
        this.targetProgram = targetProgram;
        this.targetFellowship = targetFellowship;
        this.undergradLevel = undergradLevel;
        this.undergradSchool = undergradSchool;
        this.undergradProgram = undergradProgram;
        this.gpaOrigin = gpaOrigin;
        this.languageTestType = languageTestType;
        this.user = user;
    }

    public ApplicantBackground() {

    }

    /* getter and setters */

    public BigDecimal getGpaOrigin() {
        return gpaOrigin;
    }

    public void setGpaOrigin(BigDecimal gpaOrigin) {
        this.gpaOrigin = gpaOrigin;
    }

    public BigDecimal getGpaConverted() {
        return gpaConverted;
    }

    public void setGpaConverted(BigDecimal gpaConverted) {
        this.gpaConverted = gpaConverted;
    }

    public BigDecimal getIELTSTotal() {
        return IELTSTotal;
    }

    public void setIELTSTotal(BigDecimal IELTSTotal) {
        this.IELTSTotal = IELTSTotal;
    }

    public BigDecimal getIELTSListening() {
        return IELTSListening;
    }

    public void setIELTSListening(BigDecimal IELTSListening) {
        this.IELTSListening = IELTSListening;
    }

    public BigDecimal getIELTSSpeaking() {
        return IELTSSpeaking;
    }

    public void setIELTSSpeaking(BigDecimal IELTSSpeaking) {
        this.IELTSSpeaking = IELTSSpeaking;
    }

    public BigDecimal getIELTSReading() {
        return IELTSReading;
    }

    public void setIELTSReading(BigDecimal IELTSReading) {
        this.IELTSReading = IELTSReading;
    }

    public BigDecimal getIELTSWriting() {
        return IELTSWriting;
    }

    public void setIELTSWriting(BigDecimal IELTSWriting) {
        this.IELTSWriting = IELTSWriting;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getEnrollYear() {
        return enrollYear;
    }

    public void setEnrollYear(String enrollYear) {
        this.enrollYear = enrollYear;
    }

    public String getTargetDegree() {
        return targetDegree;
    }

    public void setTargetDegree(String targetDegree) {
        this.targetDegree = targetDegree;
    }

    public String getTargetProgram() {
        return targetProgram;
    }

    public void setTargetProgram(String targetProgram) {
        this.targetProgram = targetProgram;
    }

    public String getTargetFellowship() {
        return targetFellowship;
    }

    public void setTargetFellowship(String targetFellowship) {
        this.targetFellowship = targetFellowship;
    }

    public String getUndergradLevel() {
        return undergradLevel;
    }

    public void setUndergradLevel(String undergradLevel) {
        this.undergradLevel = undergradLevel;
    }

    public String getUndergradSchool() {
        return undergradSchool;
    }

    public void setUndergradSchool(String undergradSchool) {
        this.undergradSchool = undergradSchool;
    }

    public String getUndergradProgram() {
        return undergradProgram;
    }

    public void setUndergradProgram(String undergradProgram) {
        this.undergradProgram = undergradProgram;
    }

    public int getUndergradRank() {
        return undergradRank;
    }

    public void setUndergradRank(int undergradRank) {
        this.undergradRank = undergradRank;
    }

    public String getLanguageTestType() {
        return languageTestType;
    }

    public void setLanguageTestType(String languageTestType) {
        this.languageTestType = languageTestType;
    }

    public int getTOEFLTotal() {
        return TOEFLTotal;
    }

    public void setTOEFLTotal(int TOEFLTotal) {
        this.TOEFLTotal = TOEFLTotal;
    }

    public int getTOEFLListening() {
        return TOEFLListening;
    }

    public void setTOEFLListening(int TOEFLListening) {
        this.TOEFLListening = TOEFLListening;
    }

    public int getTOEFLSpeaking() {
        return TOEFLSpeaking;
    }

    public void setTOEFLSpeaking(int TOEFLSpeaking) {
        this.TOEFLSpeaking = TOEFLSpeaking;
    }

    public int getTOEFLReading() {
        return TOEFLReading;
    }

    public void setTOEFLReading(int TOEFLReading) {
        this.TOEFLReading = TOEFLReading;
    }

    public int getTOEFLWriting() {
        return TOEFLWriting;
    }

    public void setTOEFLWriting(int TOEFLWriting) {
        this.TOEFLWriting = TOEFLWriting;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ApplicantBackground that = (ApplicantBackground) o;
        return id.equals(that.id) && user.equals(that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user);
    }
}
