package com.group7.entitiy;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ProgramUpdateVo {
    private long id;
    private String name;
    private long schoolID;
}
