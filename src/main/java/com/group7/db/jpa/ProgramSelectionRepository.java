package com.group7.db.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

/**
 * @Author: LiuZhe
 * @Date: 2023/3/8 - 17:01
 */
@RepositoryRestResource
public interface ProgramSelectionRepository extends JpaRepository<ProgramSelection, Long>, PagingAndSortingRepository<ProgramSelection, Long>, CrudRepository<ProgramSelection, Long>, ListCrudRepository<ProgramSelection, Long>, JpaSpecificationExecutor<ProgramSelection> {
}
