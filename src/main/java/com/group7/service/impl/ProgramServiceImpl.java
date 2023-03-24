package com.group7.service.impl;

import com.group7.db.jpa.Program;
import com.group7.db.jpa.ProgramRepository;
import com.group7.db.jpa.School;
import com.group7.entitiy.ProgramQueryVo;
import com.group7.service.ProgramService;
import jakarta.annotation.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.group7.utils.common.ListToPage.listToPage;

@Service
public class ProgramServiceImpl implements ProgramService {

    @Resource
    private ProgramRepository programRepository;

    @Override
    public Page<Program> pageByVo(long current, long limit, ProgramQueryVo programQueryVo) {
        Page<Program> programList;
        Sort sort;
        if (programQueryVo.getSort()) {
            sort = Sort.by("name").ascending();
        } else {
            sort = Sort.by("name").descending();
        }
        Pageable pageable = PageRequest.of((int) current, (int) limit, sort);
        if (!programQueryVo.getName().isBlank()) {
            List<Program> programs = programRepository.findByNameContaining(programQueryVo.getName(), sort);
            programList = listToPage(programs, pageable);
        } else {
            programList = programRepository.findAll(pageable);
        }

        System.out.println(programList);
        return programList;
    }

    @Override
    public List<Program> getPopularProgramsByDegree(String degree, long limit) {
        List<Program> popularPrograms;
        Sort sort;

        // determine popularity on the number of likes
        sort = Sort.by("likes").descending();

        if (degree.equals("PhD")){
            popularPrograms = programRepository.findByDegree(degree, sort);
        }else{
            popularPrograms = programRepository.findByDegreeNot("PhD", sort);
        }

        // limit the number of programs when return
        // if less than the limit, we return all
        if (popularPrograms.size() > limit){
            // return limited number
            popularPrograms = popularPrograms.subList(0, (int) limit);
        }

        return popularPrograms;
    }
}
