package com.group7.db.jpa.utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: WangYuyang
 * @Date: 2023/3/8-16:20
 * @Project: COMP3032J_FYP_Thesis_Group_7
 * @Package: com.group7.db.jpa.utils
 * @Description:
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SearchCriteria {
    private String key;
    private Operator operation;
    private Object value;
}
