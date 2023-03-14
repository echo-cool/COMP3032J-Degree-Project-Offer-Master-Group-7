package com.group7.db.jpa;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * @Author: WangYuyang
 * @Date: 2023/2/28-16:11
 * @Project: COMP3032J_FYP_Thesis_Group_7
 * @Package: com.group7.db.jpa
 * @Description:
 **/
@RepositoryRestResource
public interface SchoolRepository extends JpaRepository<School, Long>, PagingAndSortingRepository<School, Long>, CrudRepository<School, Long> {
    List<School> findByNameLike(String name, Sort sort);
}
