package com.group7.db.jpa;

import cn.hutool.core.date.DateTime;
import jakarta.persistence.*;
import lombok.experimental.Accessors;

import java.util.Date;

@Entity
@Accessors(chain = true)
@Table(name = "chat",
        uniqueConstraints = {
        })
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String sender;

    @Column(nullable = false)
    private String receiver;

    @Column(nullable = false)
    private Long senderId;

    @Column(nullable = false)
    private Long receiverId;

    @Column(nullable = false)
    private String content;

    @Temporal(TemporalType.TIME)
    @Column(length = 1000) //1000 will be fine
    private DateTime createdAt = new DateTime();

    public Chat() {
    }

    public Chat(String sender, String receiver, Long senderId, Long receiverId, String content) {
        this.sender = sender;
        this.receiver = receiver;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.content = content;
    }


    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public Long getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Long receiverId) {
        this.receiverId = receiverId;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public DateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(DateTime createdAt) {
        this.createdAt = createdAt;
    }
}
