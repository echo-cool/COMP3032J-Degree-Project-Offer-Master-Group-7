package com.group7.db.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PostCommentRepository extends JpaRepository<PostComment, Long>, PagingAndSortingRepository<PostComment, Long>, CrudRepository<PostComment, Long> {
}
