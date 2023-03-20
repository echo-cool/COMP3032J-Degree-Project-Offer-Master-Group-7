package com.group7.entitiy;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class SchoolUpdateVo {

    private long id;
    private String name;


}
