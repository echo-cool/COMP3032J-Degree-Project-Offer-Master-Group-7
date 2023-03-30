package com.group7.db.jpa.utils;

import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @Author: WangYuyang
 * @Date: 2023/3/8-16:30
 * @Project: COMP3032J_FYP_Thesis_Group_7
 * @Package: com.group7.db.jpa.utils
 * @Description:
 **/
public class SpecificationsBuilder<Entity> {

    private final List<SearchCriteria> params;

    // 初始化 params，保证每次实例都是一个新的 ArrayList
    public SpecificationsBuilder() {
        params = new ArrayList<>();
    }

    // 利用正则表达式取我们search参数里面的值，解析成SearchCriteria对象
    public Specification<Entity> buildSpecification(String search) {
        Pattern pattern = Pattern.compile("(\\w+?)([:<>])(\\w+?),");
        Matcher matcher = pattern.matcher(search + ",");
        while (matcher.find()) {
            this.with(matcher.group(1), Operator.fromOperator(matcher.group(2)), matcher.group(3));
        }
        return this.build();
    }

    // 根据参数返回我们刚才创建的 SearchCriteria
    private SpecificationsBuilder<Entity> with(String key, Operator operation, Object value) {
        params.add(new SearchCriteria(key, operation, value));
        return this;
    }

    // 根据我们刚才创建的 MySpecification 返回所需要的 Specification
    private Specification<Entity> build() {
        if (params.size() == 0) {
            return null;
        }

        List<Specification<Entity>> specs = params.stream()
                .map(MySpecification<Entity>::new)
                .collect(Collectors.toList());

        Specification<Entity> result = specs.get(0);

        for (int i = 1; i < params.size(); i++) {
            result = Specification.where(result).and(specs.get(i));
        }
        return result;
    }
}
