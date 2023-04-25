package com.group7.entitiy.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @Author: LiuZhe
 * @Date: 2023/4/25 - 13:53
 */
@Data
public class GradeData {

    @ExcelProperty(index = 0)
    private String courseName;

    @ExcelProperty(index = 1)
    private String grade;

    @ExcelProperty(index = 2)
    private Double credits;
}
