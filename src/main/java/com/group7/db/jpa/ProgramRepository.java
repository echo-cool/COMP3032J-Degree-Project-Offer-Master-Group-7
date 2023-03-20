package com.group7.db.jpa;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * @Author: WangYuyang
 * @Date: 2023/2/28-16:12
 * @Project: COMP3032J_FYP_Thesis_Group_7
 * @Package: com.group7.db.jpa
 * @Description:
 **/
@RepositoryRestResource
public interface ProgramRepository extends JpaRepository<Program, Long>, PagingAndSortingRepository<Program, Long>, CrudRepository<Program, Long>, JpaSpecificationExecutor<School> {

    List<Program> findByNameContaining(String name, Sort sort);
}
