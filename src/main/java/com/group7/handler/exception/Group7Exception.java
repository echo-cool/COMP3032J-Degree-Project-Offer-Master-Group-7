package com.group7.handler.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Group7Exception extends RuntimeException{

    private Integer code;
    private String msg;

}
