package com.group7.controller.application;

import com.group7.controller.user.payload.EditPersonalInfoRequest;
import com.group7.db.jpa.*;
import com.group7.db.jpa.utils.ERound;
import com.group7.db.jpa.utils.EStatus;
import com.group7.entitiy.ApplicationUpdateVo;
import com.group7.entitiy.ProgramQueryVo;
import com.group7.utils.common.JwtUtils;
import com.group7.utils.common.R;
import io.sentry.protocol.App;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @Author: LiuZhe
 * @Date: 2023/3/20 - 0:20
 */

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/application")
public class ApplicationController {

    @Resource
    ApplicationRepository applicationRepository;

    @Resource
    ProgramRepository programRepository;

    @Resource
    JwtUtils jwtUtils;

    @DeleteMapping("/deleteApplicationByProgramId/{programId}")
    public ResponseEntity<?> deleteApplicationByProgramId(@PathVariable("programId") long programId, HttpServletRequest request){
        // get the current user
        User user = jwtUtils.getUserFromRequestByToken(request);

        // get all the applications of this user
        Set<Application> applications = user.getApplications();
        // loop through applications to find the application with this program
        for (Application ap : applications){
            if (ap.getProgram().getId() == programId){
                // delete this application
                applicationRepository.delete(ap);
                return ResponseEntity.ok(R.ok());
            }
        }

        return ResponseEntity
                .badRequest()
                .body(R.error().message("Failed: The user does not have application of this program."));
    }

    @PostMapping("/addApplication/{programId}")
    public ResponseEntity<?> addApplication(@PathVariable("programId") long programId, HttpServletRequest request){
        // get the current user
        User user = jwtUtils.getUserFromRequestByToken(request);

        // get the program by id
        Program program = programRepository.findById(programId).orElse(null);

        // check the program
        if (program == null){
            return ResponseEntity
                    .badRequest()
                    .body(R.error().message("Failed: No program with this ID."));
        }

        // create a new application
        Application application = new Application(user, program);
        applicationRepository.save(application);

        return ResponseEntity.ok(R.ok());
    }

    /**
     * Applications with status of admitted or rejected
     */
    @RequestMapping("/public/get-decided-applications")
    public R getDecidedApplications() {
        ArrayList<EStatus> filterStatus = new ArrayList<>();
        filterStatus.add(EStatus.ADMITTED);
        filterStatus.add(EStatus.REJECTED);

        Sort sort = Sort.by("reportedTime").descending();

        List<Application> decisions = applicationRepository.findByeStatusIn(filterStatus, sort);

        return R.ok().data("decisions", decisions);
    }

    @RequestMapping("/update-application")
    public R updateApplication(@RequestBody ApplicationUpdateVo applicationUpdateVo) {

        // get query items
        long id = applicationUpdateVo.getId();
        String status = applicationUpdateVo.getStatus();
        String round = applicationUpdateVo.getRound();

        // query the application
        Application application = applicationRepository.findById(id).orElse(null);
        if (application == null){
            return R.error().message("Invalid application id!");
        }

        // update the status and round for this application
        application.seteStatus(EStatus.valueOf(status));
        application.seteRound(ERound.valueOf(round));

        // update the report time if changed to ADMITTED or REJECTED
        if (EStatus.valueOf(status) == EStatus.ADMITTED
                || EStatus.valueOf(status) == EStatus.REJECTED){
            application.setReportedTime(new Date());
        }

        applicationRepository.save(application);

        return R.ok();
    }
}
