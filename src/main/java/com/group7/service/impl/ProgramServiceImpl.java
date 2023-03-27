package com.group7.service.impl;

import com.group7.db.jpa.Program;
import com.group7.db.jpa.ProgramRepository;
import com.group7.db.jpa.utils.EMajor;
import com.group7.entitiy.ProgramQueryVo;
import com.group7.service.ProgramService;
import jakarta.annotation.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    @Override
    public List<Program> getProgramsByQuery(ProgramQueryVo programQueryVo, long limit) {
        Stream<Program> programs;
        List<Program> programList;
        Sort sort;

        // get query items
        String likes = programQueryVo.getLikes();
        String degree = programQueryVo.getDegree();
        String major = programQueryVo.getMajor();
        String query = programQueryVo.getQuery();

        // sort by like numbers
        if (likes.equals("most-liked")){
            sort = Sort.by("likes").descending();

        } else if (likes.equals("least-liked")) {
            sort = Sort.by("likes").ascending();

        }else{
            sort = Sort.unsorted();
        }

        List<Program> programsByQuery = programRepository.findBySchool_NameContainingOrNameContaining(query, query);

        // determine whether degree and major are "all"
        if (degree.equals("all") && major.equals("all")){
            programs = programsByQuery.stream().filter(item -> programRepository.findAll(sort).stream().map(Program::getId).anyMatch(id -> Objects.equals(item.getId(), id)));

        } else if (degree.equals("all")) {
            programs = programsByQuery.stream().filter(item -> programRepository.findByMajor(EMajor.valueOf(major), sort).stream().map(Program::getId).anyMatch(id -> Objects.equals(item.getId(), id)));

        } else if (major.equals("all")) {
            if (degree.equals("PhD")){
                programs = programsByQuery.stream().filter(item -> programRepository.findByDegree(degree, sort).stream().map(Program::getId).anyMatch(id -> Objects.equals(item.getId(), id)));
            }else{
                programs = programsByQuery.stream().filter(item -> programRepository.findByDegreeNot("PhD", sort).stream().map(Program::getId).anyMatch(id -> Objects.equals(item.getId(), id)));
            }

        }else{
            if (degree.equals("PhD")){
                programs = programsByQuery.stream().filter(item -> programRepository.findByDegreeAndMajor(degree, EMajor.valueOf(major), sort).stream().map(Program::getId).anyMatch(id -> Objects.equals(item.getId(), id)));
            }else{
                programs = programsByQuery.stream().filter(item -> programRepository.findByDegreeNotAndMajor("PhD", EMajor.valueOf(major), sort).stream().map(Program::getId).anyMatch(id -> Objects.equals(item.getId(), id)));
            }
        }

        programList = programs.collect(Collectors.toList());

        // limit the number of programs when return
        // if less than the limit, we return all
        if (programList.size() > limit){
            // return limited number
            programList = programList.subList(0, (int) limit);
        }

        return programList;
    }


}
