package com.group7.db.jpa;

import com.group7.db.jpa.utils.EStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * @Author: WangYuyang
 * @Date: 2023/3/6-20:31
 * @Project: COMP3032J_FYP_Thesis_Group_7
 * @Package: com.group7.db.jpa
 * @Description:
 **/
public interface ApplicationRepository extends JpaRepository<Application, Long>, PagingAndSortingRepository<Application, Long>, CrudRepository<Application, Long> {
    List<Application> findApplicationsByeStatus(EStatus status);
    List<Application> findApplicationByeStatusNot(EStatus status);
}
