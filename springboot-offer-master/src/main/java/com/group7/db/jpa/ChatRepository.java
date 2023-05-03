package com.group7.db.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface ChatRepository extends JpaRepository<Chat, Long>, PagingAndSortingRepository<Chat, Long>, CrudRepository<Chat, Long> {
    List<Chat> findAllBySender(String sender);
    List<Chat> findAllByReceiver(String receiver);
    List<Chat> findAllBySenderIdAndReceiverId(Long senderId, Long receiverId);
    List<Chat> findAllByReceiverId(Long Id);
}
