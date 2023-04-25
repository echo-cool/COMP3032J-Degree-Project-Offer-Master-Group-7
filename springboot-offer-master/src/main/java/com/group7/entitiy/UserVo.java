package com.group7.entitiy;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Set;

@Data
@Accessors(chain = true)
public class UserVo {
    private long id;
    private String username;
    private String avatar;
}
