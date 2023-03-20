package com.group7.service.impl;

import com.group7.db.jpa.School;
import com.group7.db.jpa.SchoolRepository;
import com.group7.entitiy.SchoolQueryVo;
import com.group7.service.SchoolService;
import jakarta.annotation.Resource;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.group7.utils.common.ListToPage.listToPage;

@Service
public class SchoolServiceImpl implements SchoolService {

    @Resource
    private SchoolRepository schoolRepository;

    @Override
    public Page<School> pageByVo(long current, long limit, SchoolQueryVo schoolQueryVo) {
        Page<School> schoolList;
        Sort sort;
        if (schoolQueryVo.getSort()) {
            sort = Sort.by("name").ascending();
        }else {
            sort = Sort.by("name").descending();
        }
        Pageable pageable = PageRequest.of((int)current, (int)limit, sort);
        if (!schoolQueryVo.getName().isBlank()) {
            List<School> schools = schoolRepository.findByNameContaining(schoolQueryVo.getName(),sort);
            schoolList = listToPage(schools, pageable);
        }
        else{
            schoolList = schoolRepository.findAll(pageable);
        }

        System.out.println(schoolList);
        return schoolList;
    }


}
