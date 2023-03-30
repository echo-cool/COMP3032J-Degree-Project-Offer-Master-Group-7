package com.group7.entitiy;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @Author: LiuZhe
 * @Date: 2023/3/30 - 19:04
 */
@Data
@Accessors(chain = true)
public class ApplicationUpdateVo {

    private long id;
    private String status;
    private String round;
    private String deadline;

}
