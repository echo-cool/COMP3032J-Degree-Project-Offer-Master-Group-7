package com.group7.entitiy.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.NumberFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Range;

/**
 * @Author: LiuZhe
 * @Date: 2023/4/26 - 17:56
 */
@Data
@EqualsAndHashCode
public class GPAReportData {

    @ExcelProperty(value = "  ", index = 0)
    private int order;

    @ExcelProperty(value = "Course Name", index = 1)
    private String courseName;

//    @NumberFormat("#.#")
    @ExcelProperty(value = "Credits", index = 2)
    private Double credits;

    @ExcelProperty(value = "Grade", index = 3)
    private String grade;

    @ExcelProperty(value = "US Grade", index = 4)
    private String gradeUS;

//    @NumberFormat("#.##")
    @ExcelProperty(value = "US Grade Points", index = 5)
    private Double gradePointsUS;


}
