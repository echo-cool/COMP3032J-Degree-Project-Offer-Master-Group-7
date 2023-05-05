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

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;


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

    @RequestMapping("/public/get-top-ranked-schools/{rankRule}/{limit}")
    public R getTopRankedSchools(@PathVariable("rankRule") String rankRule,
                                 @PathVariable("limit") long limit) {

        if (!rankRule.equals("QS") && !rankRule.equals("USNews")){
            return R.error().message("Invalid rank rule");
        }

        if (limit < 0){
            return R.error().message("Invalid limit number");
        }

        List<School> topSchools = schoolService.getTopSchoolByRankRule(rankRule, limit);

        return R.ok().data("topSchools", topSchools);
    }

    @RequestMapping("/public/getRandomSchools/{size}")
    public R getRandomSchools(@PathVariable("size") long size){
        Random random = new Random();
        List<School> schools = schoolRepository.findAll();
        List<School> res = new ArrayList<>();
        for(int i = 0; i < size; i++){
            res.add(schools.get(random.nextInt(0, schools.size())));
        }
        return R.ok().data("schools", res);
    }

    @RequestMapping("/public/getRandomSchools_fake/{size}")
    public R getRandomSchools_fake(@PathVariable("size") long size){
        List<School> schools = schoolRepository.findAll();
        List<School> res = new ArrayList<>();
        res.add(schools.get(0));
        res.add(schools.get(1));
        res.add(schools.get(2));
        res.add(schools.get(3));
        res.add(schools.get(4));

        return R.ok().data("schools", res);
    }

    @GetMapping("/public/getAllSchools")
    public R getAllSchools(){
        List<School> allSchools = schoolRepository.findAll();
        return R.ok().data("schools", allSchools);
    }

    @GetMapping("/public/getById/{id}")
    public R getSchoolById(@PathVariable("id") long id){

        School school = schoolRepository.findById(id).orElse(null);
        System.out.println("=============666");
        System.out.println(school);
        System.out.println("=============666");
        return R.ok().data("school", school);
    }

}
