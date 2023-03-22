package com.group7.db.jpa;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

/**
 * @Author: WangYuyang
 * @Date: 2023/2/27-16:17
 * @Project: COMP3032J_FYP_Thesis_Group_7
 * @Package: com.group7.db.jpa
 * @Description:
 **/
@RepositoryRestResource
public interface UserRepository extends JpaRepository<User, Long>, PagingAndSortingRepository<User, Long>, CrudRepository<User, Long>, ListCrudRepository<User, Long>, JpaSpecificationExecutor<User>{
    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
    Optional<User> findByEmail(@Param("email") String email);

    List<User> findByUsernameContainingAndEmailContaining(String username, String email, Sort sort);

}

