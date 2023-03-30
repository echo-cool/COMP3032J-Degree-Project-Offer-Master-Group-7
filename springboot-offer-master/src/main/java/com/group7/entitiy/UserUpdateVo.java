package com.group7.entitiy;

import com.group7.db.jpa.Role;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Set;

@Data
@Accessors(chain = true)
public class UserUpdateVo {
    private long id;
    private String username;
    private String password;
    private String email;
    private Set<String> roles;
}
