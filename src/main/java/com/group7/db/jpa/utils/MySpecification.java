package com.group7.db.jpa.utils;


import com.group7.db.jpa.utils.SearchCriteria;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import static cn.hutool.http.HtmlUtil.*;
import static com.group7.db.jpa.utils.Operator.LK;

/**
 * @Author: WangYuyang
 * @Date: 2023/3/8-16:14
 * @Project: COMP3032J_FYP_Thesis_Group_7
 * @Package: com.group7.db.jpa
 * @Description:
 **/
public class MySpecification<Entity> implements Specification<Entity> {
    private final SearchCriteria criteria;

    public MySpecification(SearchCriteria criteria) {
        this.criteria = criteria;
    }

    /**
     * 实现实体根据不同的字段、不同的Operator组合成不同的Predicate条件
     *
     * @param root    must not be {@literal null}.
     * @param query   must not be {@literal null}.
     * @param builder must not be {@literal null}.
     * @return a {@link Predicate}, may be {@literal null}.
     */
    @Override
    public Predicate toPredicate(Root<Entity> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        switch (criteria.getOperation()) {
            case GT:
                return builder.greaterThanOrEqualTo(root.get(criteria.getKey()), criteria.getValue().toString());
            case LT:
                return builder.lessThanOrEqualTo(root.get(criteria.getKey()), criteria.getValue().toString());
            case LK:
                if (root.get(criteria.getKey()).getJavaType() == String.class) {
                    return builder.like(root.get(criteria.getKey()), "%" + criteria.getValue() + "%");
                } else {
                    return builder.equal(root.get(criteria.getKey()), criteria.getValue());
                }
            default:
                return null;
        }
    }
}
