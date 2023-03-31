package com.group7.db.jpa;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

/**
 * @Author: WangYuyang
 * @Date: 2023/2/28-16:11
 * @Project: COMP3032J_FYP_Thesis_Group_7
 * @Package: com.group7.db.jpa
 * @Description:
 **/
@RepositoryRestResource
public interface SchoolRepository extends JpaRepository<School, Long>, PagingAndSortingRepository<School, Long>, CrudRepository<School, Long>, JpaSpecificationExecutor<School> {

    List<School> findByNameContaining(String name, Sort sort);
}
