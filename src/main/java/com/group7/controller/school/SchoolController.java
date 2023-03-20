package com.group7.controller.school;

import com.group7.db.jpa.School;
import com.group7.db.jpa.SchoolRepository;
import com.group7.entitiy.SchoolQueryVo;
import com.group7.entitiy.SchoolUpdateVo;
import com.group7.service.SchoolService;
import com.group7.utils.common.R;
import jakarta.annotation.Resource;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/school")
public class SchoolController {

    @Resource
    private SchoolRepository schoolRepository;

    @Resource
    private SchoolService schoolService;

    @RequestMapping("/condition-query/{current}/{limit}")
    public R conditionQuery(@PathVariable("current") long current,
                            @PathVariable("limit") long limit,
                            @RequestBody(required = false) SchoolQueryVo schoolQueryVo) {
        Page<School> map = schoolService.pageByVo(current-1, limit, schoolQueryVo);
        return R.ok().data("data", map);
    }


    @RequestMapping("/update/{id}")
    public R updateSchool(@PathVariable("id") long id, @RequestBody(required = false) SchoolUpdateVo school) {
        School schoolOld = schoolRepository.findById(id).orElse(null);
        System.out.println(schoolOld);
        if (schoolOld != null){
            schoolOld.setName(school.getName());
            schoolRepository.saveAndFlush(schoolOld);
            return R.ok();
        }
        return R.error();
    }

    @RequestMapping("/create")
    public R createSchool(@RequestBody(required = false) SchoolUpdateVo school) {
        School schoolTmp = new School(school.getName());
        schoolRepository.save(schoolTmp);
        return R.ok().data("id", schoolTmp.getId());
    }


}
