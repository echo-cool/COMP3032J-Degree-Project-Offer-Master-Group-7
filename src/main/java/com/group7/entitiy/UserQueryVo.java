package com.group7.entitiy;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UserQueryVo {
    private String username;
    private String email;
    private Boolean sort;
}
