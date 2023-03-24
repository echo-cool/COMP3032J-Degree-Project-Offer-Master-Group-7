package com.group7.controller.program;

import com.group7.db.jpa.Program;
import com.group7.db.jpa.ProgramRepository;
import com.group7.db.jpa.School;
import com.group7.db.jpa.SchoolRepository;
import com.group7.entitiy.ProgramQueryVo;
import com.group7.entitiy.ProgramUpdateVo;
import com.group7.entitiy.SchoolQueryVo;
import com.group7.entitiy.SchoolUpdateVo;
import com.group7.service.ProgramService;
import com.group7.service.SchoolService;
import com.group7.utils.common.R;
import jakarta.annotation.Resource;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/program")
public class ProgramController {

    @Resource
    private ProgramRepository programRepository;

    @Resource
    private SchoolRepository schoolRepository;

    @Resource
    private ProgramService programService;

    @RequestMapping("/condition-query/{current}/{limit}")
    public R conditionQuery(@PathVariable("current") long current,
                            @PathVariable("limit") long limit,
                            @RequestBody(required = false) ProgramQueryVo programQueryVo) {
        Page<Program> map = programService.pageByVo(current-1, limit, programQueryVo);
        return R.ok().data("data", map);
    }


    @RequestMapping("/update/{id}")
    public R updateProgram(@PathVariable("id") long id, @RequestBody(required = false) ProgramUpdateVo program) {
        Program programOld = programRepository.findById(id).orElse(null);
        System.out.println(programOld);
        if (programOld != null){
            programOld.setName(program.getName());
            School school = schoolRepository.getById(program.getSchoolID());
            programOld.setSchool(school);
            programRepository.saveAndFlush(programOld);
            return R.ok();
        }
        return R.error();
    }

    @RequestMapping("/create")
    public R createProgram(@RequestBody(required = false) ProgramUpdateVo program) {
        School school = schoolRepository.getById(program.getSchoolID());
        Program programTmp = new Program(program.getName(), school);
        programRepository.save(programTmp);
        return R.ok().data("id", programTmp.getId());
    }

    /**
     * Popularity accords to the number of likes
     */
    @RequestMapping("/public/get-popular-programs/{degree}/{limit}")
    public R getPopularPrograms(@PathVariable("degree") String degree,
                                 @PathVariable("limit") long limit) {

        if (degree.isBlank()){
            return R.error().message("Invalid degree");
        }

        if (limit < 0){
            return R.error().message("Invalid limit number");
        }

        List<Program> popularPrograms = programService.getPopularProgramsByDegree(degree, limit);

        // get school of each program (this is also need at frontend)
        List<School> schoolsOfPrograms = new ArrayList<>();
        for (Program p : popularPrograms){
            schoolsOfPrograms.add(p.getSchool());
        }

        return R.ok().data("popularPrograms", popularPrograms).data("schoolsOfPrograms", schoolsOfPrograms);
    }


}
