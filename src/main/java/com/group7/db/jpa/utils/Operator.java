package com.group7.db.jpa.utils;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @Author: WangYuyang
 * @Date: 2023/3/8-16:27
 * @Project: COMP3032J_FYP_Thesis_Group_7
 * @Package: com.group7.db.jpa.utils
 * @Description:
 **/
@Getter
@RequiredArgsConstructor
public enum Operator {
    /**
     * 等于
     */
    EQ("="),
    /**
     * 等于
     */
    LK(":"),
    /**
     * 不等于
     */
    NE("!="),
    /**
     * ⼤于
     */
    GT(">"),
    /**
     * ⼩于
     */
    LT("<"),
    /**
     * ⼤于等于
     */
    GE(">=");

    private final String operator;

    public static Operator fromOperator(String operator) {
        for (Operator v: Operator.values()) {
            if (v.operator.equals(operator)) {
                return v;
            }
        }
        return EQ;
    }
}
