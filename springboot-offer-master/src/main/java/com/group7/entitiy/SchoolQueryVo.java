package com.group7.entitiy;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class SchoolQueryVo {

    private String name;

    /**
     * 0 顺序 1 逆序
     */
    private Boolean sort;
}
