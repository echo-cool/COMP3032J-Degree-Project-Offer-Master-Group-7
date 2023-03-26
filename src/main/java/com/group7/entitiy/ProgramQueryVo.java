package com.group7.entitiy;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ProgramQueryVo {
    private String name;

    /**
     * 0 顺序 1 逆序
     */
    private Boolean sort;

    private String major;
    private String degree;
    private String likes;   // most-liked or least-liked
}
