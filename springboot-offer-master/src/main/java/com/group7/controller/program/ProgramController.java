package com.group7.controller.program;

import com.group7.db.jpa.*;
import com.group7.db.jpa.utils.EStatus;
import com.group7.entitiy.ProgramQueryVo;
import com.group7.entitiy.ProgramUpdateVo;
import com.group7.service.ProgramService;
import com.group7.utils.common.DateUtil;
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
import java.util.stream.Collectors;

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
            System.out.println(user);
            System.out.println(likedProgram);
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
        System.out.println(user);
        System.out.println(program);

        userRepository.save(user);
        programRepository.save(program);

        return R.ok().data("likesNumber", program.getLikesNumber()).message(String.valueOf(alreadyLiked));
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

        if (likes == null || degree == null || major == null ||
                likes.isBlank() || degree.isBlank() || major.isBlank()){
            return R.error().message("Invalid query (blank)");
        }

        if (limit < -1){
            return R.error().message("Invalid limit number");
        }

        List<Program> programs = programService.getProgramsByQuery(programQueryVo);

        if (limit == -1) {
            limit = programs.size();
        }

        Pageable pageable = PageRequest.of((int)current - 1, (int)limit);

        programList = listToPage(programs, pageable);

        return R.ok().data("programs", programList)
                .data("totalElements", programList.getTotalElements())
                .data("totalPages", programList.getTotalPages());
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
//        System.out.println("============");
//        System.out.println(allPrograms);
//        System.out.println("============");
        return R.ok().data("programs", allPrograms);
    }

    @GetMapping("/public/getById/{id}")
    public R getProgramById(@PathVariable("id") long id){
        Optional<Program> program = programRepository.findById(id);
        if (program.isPresent()){
            return R.ok().data("program", program.get());
        }
        return R.error();
    }

    @GetMapping("/public/getAverageMetricByProgramId/{id}")
    public R getAverageMetricByProgramId(@PathVariable("id") long id){
        Program program = programRepository.findById(id).orElse(null);
        if(program != null){
            List<Application> applications = program.getApplications()
                    .stream()
                    .filter(application -> application.geteStatus() == EStatus.ADMITTED)
                    .toList();
            System.out.println(applications);
            // 0: GPA, 1: GRE Overall, 2: GRE Verbal, 3: GRE Quantitative, 4: GRE Writing
            // 5: IELTS Listening, 6: IELTS Reading, 7: IELTS Writing, 8: IELTS Speaking, 9: IELTS Overall
            // 10: Ranking
            double[] sumMetric = new double[11];
            for(Application application : applications){
                sumMetric[0] += application.getUser().getProfile().getGpa();
                sumMetric[1] += application.getUser().getProfile().getGreTotal();
                sumMetric[2] += application.getUser().getProfile().getGreVerbal();
                sumMetric[3] += application.getUser().getProfile().getGreQuantitative();
                sumMetric[4] += application.getUser().getProfile().getGreAnalyticalWriting();
                sumMetric[5] += application.getUser().getProfile().getListeningIELTS();
                sumMetric[6] += application.getUser().getProfile().getReadingIELTS();
                sumMetric[7] += application.getUser().getProfile().getWritingIELTS();
                sumMetric[8] += application.getUser().getProfile().getSpeakingIELTS();
                sumMetric[9] += application.getUser().getProfile().getTotalIELTS();
                sumMetric[10] += application.getUser().getProfile().getRanking();
            }
            for(int i = 0; i < sumMetric.length; i++){
                sumMetric[i] /= applications.size();
            }
            return R.ok()
//                    .data("0-averageMetric", sumMetric)
                    .data("ApplicationCount", applications.size())
                    .data("gpa", sumMetric[0])
                    .data("greTotal", sumMetric[1])
                    .data("greVerbal", sumMetric[2])
                    .data("greQuantitative", sumMetric[3])
                    .data("greAnalyticalWriting", sumMetric[4])
                    .data("listeningIELTS", sumMetric[5])
                    .data("readingIELTS", sumMetric[6])
                    .data("writingIELTS", sumMetric[7])
                    .data("speakingIELTS", sumMetric[8])
                    .data("totalIELTS", sumMetric[9])
                    .data("ranking", sumMetric[10])
                    ;
        }
        return R.error();
    }



    @GetMapping("/public/get-weekly-ad-count/{id}")
    public R getWeeklyAdmissionCountByProgramId(@PathVariable("id") long id){
        Program program = programRepository.findById(id).orElse(null);
        if (program == null){
            return R.error().message("invalid program id");
        }

        // get all applications of this program
        Set<Application> applications = program.getApplications();

        // get the current year and last year
        Calendar currCal=Calendar.getInstance();
        int currentYear = currCal.get(Calendar.YEAR);
        int lastYear = currentYear - 1;
        int lastLastYear = currentYear - 2;
        // get the last day of the last year
        Date lastDateOfLastYear = DateUtil.getLastDateOfYear(lastYear);
        // get the first day of this year
        Date firstDateOfThisYear = DateUtil.getFirstDateOfYear(currentYear);
        // get the last day of the year before last year
        Date lastDateOfLLYear = DateUtil.getLastDateOfYear(lastLastYear);

        // filter out the applications with status of admitted or rejected
        List<Application> reportedApplications = applications.stream().filter(a -> (a.geteStatus().equals(EStatus.ADMITTED) || a.geteStatus().equals(EStatus.REJECTED))).toList();


        // filter out the applications of this year
        List<Application> applicationsThisYear = reportedApplications.stream().filter(a -> a.getReportedTime().after(lastDateOfLastYear)).toList();
        // filter out the applications of last year
        List<Application> applicationsLastYear = reportedApplications.stream().filter(a -> a.getReportedTime().after(lastDateOfLLYear)).filter(a -> a.getReportedTime().before(firstDateOfThisYear)).toList();

        // get the list of weekly admission count
        long[] countLstThisYear = program.getCountLstThisYear();
        long[] countLstLastYear = program.getCountLstLastYear();
        // add real count to the baseline
        for (int i = 0; i < 52; i++){
            // the week num this index is representing
            int week = i + 1;
            // count the admissions in this week
            countLstThisYear[i] += applicationsThisYear.stream().filter(a -> a.getReportWeekNum() == week).count();
            countLstLastYear[i] += applicationsLastYear.stream().filter(a -> a.getReportWeekNum() == week).count();
        }

        return R.ok().data("countLstThisYear", countLstThisYear).data("countLstLastYear", countLstLastYear);
    }

}
