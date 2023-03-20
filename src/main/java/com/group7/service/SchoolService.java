package com.group7.service;

import com.group7.db.jpa.Program;
import com.group7.db.jpa.School;
import com.group7.entitiy.SchoolQueryVo;
import org.springframework.data.domain.Page;

public interface SchoolService {

    public Page<School> pageByVo(long current, long limit, SchoolQueryVo schoolQueryVo);
}
