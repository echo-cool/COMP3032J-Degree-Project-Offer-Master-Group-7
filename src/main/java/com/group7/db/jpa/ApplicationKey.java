package com.group7.db.jpa;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * @Author: LiuZhe
 * @Date: 2023/3/9 - 14:03
 */
@Embeddable
public class ApplicationKey implements Serializable {

    @Column(name = "user_id")
    Long userId;

    @Column(name = "program_id")
    Long programId;

    // standard constructors, getters, and setters
    public ApplicationKey() {
    }

    public ApplicationKey(Long userId, Long programId) {
        this.userId = userId;
        this.programId = programId;
    }



    // hashcode and equals implementation
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        ApplicationKey that = (ApplicationKey) o;
//        return userId.equals(that.userId) && programId.equals(that.programId);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(userId, programId);
//    }


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getProgramId() {
        return programId;
    }

    public void setProgramId(Long programId) {
        this.programId = programId;
    }
}
