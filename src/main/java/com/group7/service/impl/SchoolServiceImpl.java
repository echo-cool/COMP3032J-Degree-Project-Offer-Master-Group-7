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
import java.util.Map;
import java.util.Optional;

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
            System.out.println("name");
            List<School> schools = schoolRepository.findByNameLike(schoolQueryVo.getName(),sort);
            schoolList = listToPage(schools, pageable);
        }
        else{
            System.out.println("name2");
            schoolList = schoolRepository.findAll(pageable);
        }

        // conditio
        System.out.println(schoolList);
        return schoolList;
    }
    public static <T> Page<T> listToPage(List<T> list, Pageable pageable) {
        return getPage(list, pageable);
    }
    private static <T> Page<T> getPage(List<T> list, Pageable pageable) {
        //第n页起始值
        int pageStart = pageable.getPageNumber() * pageable.getPageSize();
        //第n页期望结尾值
        int expectPageEnd = pageStart + pageable.getPageSize() - 1;
        return Optional.of(list.size())
                .filter(size -> size >= pageStart)
                .map(size -> getRealSubList(pageStart, expectPageEnd, list, pageable))
                .orElseGet(() -> getEmptySubList(list, pageable));
    }
    private static <T> PageImpl<T> getRealSubList(int pageStart, int expectPageEnd, List<T> list, Pageable pageable) {
        int realPageEnd = (list.size() > expectPageEnd || list.size() == expectPageEnd) ? expectPageEnd + 1 : list.size();
        return new PageImpl<>(list.subList(pageStart, realPageEnd), pageable, list.size());
    }

    private static <T> PageImpl<T> getEmptySubList(List<T> list, Pageable pageable) {
        return new PageImpl<>(new ArrayList(), pageable, list.size());
    }

}
