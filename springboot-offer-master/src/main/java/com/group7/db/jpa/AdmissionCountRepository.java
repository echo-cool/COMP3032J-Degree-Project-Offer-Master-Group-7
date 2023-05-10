package com.group7.db.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * @Author: LiuZhe
 * @Date: 2023/5/10 - 19:06
 */
public interface AdmissionCountRepository  extends JpaRepository<AdmissionCount, Long>, PagingAndSortingRepository<AdmissionCount, Long>, CrudRepository<AdmissionCount, Long> {

    List<AdmissionCount> findAllByProgramAndWhichYearOrderByWeekNumAsc(Program program, int whichYear);
}
