package com.group7.db.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface PostCategoryRepository extends JpaRepository<PostCategory, Long>, PagingAndSortingRepository<PostCategory, Long>, CrudRepository<PostCategory, Long> {
    Optional<PostCategory> findByName(String name);
}
