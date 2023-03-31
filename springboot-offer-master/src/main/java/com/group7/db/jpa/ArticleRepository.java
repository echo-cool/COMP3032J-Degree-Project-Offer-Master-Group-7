package com.group7.db.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface ArticleRepository extends JpaRepository<Article, Long>, PagingAndSortingRepository<Article, Long>, CrudRepository<Article, Long> {

    Optional<Object> findByUser(User user);
}
