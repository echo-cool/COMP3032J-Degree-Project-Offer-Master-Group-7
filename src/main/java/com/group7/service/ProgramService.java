package com.group7.service;

import com.group7.db.jpa.Program;
import com.group7.db.jpa.School;
import com.group7.entitiy.ProgramQueryVo;
import com.group7.entitiy.SchoolQueryVo;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProgramService {

    public Page<Program> pageByVo(long current, long limit, ProgramQueryVo programQueryVo);

    public List<Program> getPopularProgramsByDegree(String degree, long limit);

}
