package com.group7.controller.application;

import com.group7.controller.user.payload.EditPersonalInfoRequest;
import com.group7.db.jpa.Application;
import com.group7.db.jpa.ApplicationRepository;
import com.group7.db.jpa.User;
import com.group7.utils.common.JwtUtils;
import com.group7.utils.common.R;
import io.sentry.protocol.App;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

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


}
