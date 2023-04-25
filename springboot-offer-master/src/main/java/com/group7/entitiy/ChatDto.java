package com.group7.entitiy;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ChatDto {
    private String sender;
    private String receiver;
    private Long senderId;
    private Long receiverId;

    private String content;
}
