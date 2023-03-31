package com.group7.controller.program;

import com.group7.db.jpa.*;
import com.group7.entitiy.ProgramQueryVo;
import com.group7.entitiy.ProgramUpdateVo;
import com.group7.service.ProgramService;
import com.group7.utils.common.JwtUtils;
import com.group7.utils.common.MyRandomUtils;
import com.group7.utils.common.R;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import static com.group7.utils.common.ListToPage.listToPage;

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

    @Resource
    private UserRepository userRepository;

    @Resource
    JwtUtils jwtUtils;

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


    @RequestMapping("/like-program/{programId}")
    public R likeProgram(@PathVariable("programId") long programId, HttpServletRequest request) {
        // get current user
        User user = jwtUtils.getUserFromRequestByToken(request);

        // get the program
        Program program = programRepository.findById(programId).orElse(null);

        if (program == null){
            return R.error().message("invalid program id!");
        }

        // check if the user liked this program (must use id)
        boolean alreadyLiked = false;
        Program likedProgram = null;
        for(Program p : user.getLikedPrograms()){
            if(p.getId() == programId){
                alreadyLiked = true;
                likedProgram = p;
                break;
            }
        }

        // remove like or add new like
        if (alreadyLiked){
            // remove the like relation
            user.getLikedPrograms().remove(likedProgram);
            // remove the user instance in the like list of this program
            // (the user obj is not the same reference stored in the list!)
            for (User u : program.getLikeUsers()){
                if (Objects.equals(u.getId(), user.getId())){
                    program.getLikeUsers().remove(u);
                    break;
                }
            }
        }else{
            // add this like relation
            user.getLikedPrograms().add(program);
            program.getLikeUsers().add(user);
        }

        userRepository.save(user);
        programRepository.save(program);

        return R.ok().data("likes", program.getLikesNumber());
    }

    @RequestMapping("/is-program-liked/{programId}")
    public R isProgramLiked(@PathVariable("programId") long programId, HttpServletRequest request) {
        // get user
        User user = jwtUtils.getUserFromRequestByToken(request);
        // get program
        Program program = programRepository.findById(programId).orElse(null);

        if (program == null){
            return R.error().message("invalid program id!");
        }

        // check if the user liked this program
        boolean isLiked = false;
        for(Program p : user.getLikedPrograms()){
            if(p.getId() == programId){
                isLiked = true;
                break;
            }
        }

        return R.ok().data("isLiked", isLiked);
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

    @RequestMapping("/public/get-programs-by-query/{limit}/{current}")
    public R getProgramsByQuery(@PathVariable("limit") long limit, @PathVariable("current") long current, @RequestBody(required = false) ProgramQueryVo programQueryVo) {

        // get query items
        String likes = programQueryVo.getLikes();
        String degree = programQueryVo.getDegree();
        String major = programQueryVo.getMajor();

        Page<Program> programList;
        Page<School> schoolList;

        if (likes == null || degree == null || major == null ||
                likes.isBlank() || degree.isBlank() || major.isBlank()){
            return R.error().message("Invalid query (blank)");
        }

        if (limit < -1){
            return R.error().message("Invalid limit number");
        }

        List<Program> programs = programService.getProgramsByQuery(programQueryVo);

        // get school of each program (this is also need at frontend)
        List<School> schoolsOfPrograms = new ArrayList<>();
        for (Program p : programs){
            schoolsOfPrograms.add(p.getSchool());
        }

        if (limit == -1) {
            limit = schoolsOfPrograms.size();
        }

        Pageable pageable = PageRequest.of((int)current - 1, (int)limit);

        programList = listToPage(programs, pageable);
        schoolList = listToPage(schoolsOfPrograms, pageable);

        return R.ok().data("programs", programList).data("schoolsOfPrograms", schoolList);
    }

    @RequestMapping("/public/getRandomPrograms/{size}")
    public R getRandomPrograms(@PathVariable("size") long size){
        Random random = MyRandomUtils.getRandom();
        List<Program> programs = programRepository.findAll();
        List<Program> res = new ArrayList<>();
        for(int i = 0; i < size; i++){
            res.add(programs.get(random.nextInt(0, programs.size())));
        }
        return R.ok().data("programs", res);
    }

    @RequestMapping("/public/getSchoolByProgram/{id}")
    public R getSchoolByProgram(@PathVariable("id") long id){
        Optional<Program> program = programRepository.findById(id);
        if (program.isPresent()){
            School school = program.get().getSchool();
            return R.ok().data("school", school);
        }
        return R.error();

    }

    @RequestMapping("/public/getProgramsBySchool/{id}")
    public R getProgramsBySchool(@PathVariable("id") long id){
        Optional<School> school = schoolRepository.findById(id);
        if (school.isPresent()){
            Set<Program> programs = school.get().getPrograms();
            return R.ok().data("programs", programs);
        }
        return R.error();

    }

    @GetMapping("/public/getAllPrograms")
    public R getAllPrograms(){
        List<Program> allPrograms = programRepository.findAll();
        System.out.println("============");
        System.out.println(allPrograms);
        System.out.println("============");
        return R.ok().data("programs", allPrograms);
    }



}
