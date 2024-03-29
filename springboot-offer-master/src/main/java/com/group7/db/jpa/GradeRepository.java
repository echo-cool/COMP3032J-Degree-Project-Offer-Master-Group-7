package com.group7.db.jpa;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * @Author: LiuZhe
 * @Date: 2023/4/25 - 21:48
 */
@Transactional
public interface GradeRepository extends JpaRepository<Grade, Long>, PagingAndSortingRepository<Grade, Long>, CrudRepository<Grade, Long> {

    void deleteAllByUser(User user);

    List<Grade> findAllByUser(User user);
}
