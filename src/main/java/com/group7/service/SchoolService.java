package com.group7.service;

import com.group7.db.jpa.Program;
import com.group7.db.jpa.School;
import com.group7.entitiy.SchoolQueryVo;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Set;

public interface SchoolService {

    public Page<School> pageByVo(long current, long limit, SchoolQueryVo schoolQueryVo);

    public List<School> getTopSchoolByRankRule(String rankRule, long limit);


}
