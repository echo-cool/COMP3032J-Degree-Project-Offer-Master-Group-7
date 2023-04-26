package com.group7.entitiy;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ChatFrontDto {
    String type = "text";

    Long author;

    String content;
}
