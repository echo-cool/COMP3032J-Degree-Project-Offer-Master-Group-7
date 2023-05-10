package com.group7.controller.dashboard;

import com.group7.db.jpa.*;
import com.group7.utils.common.R;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    @Resource
    ProgramRepository programRepository;

    @Resource
    UserRepository userRepository;

    @Resource
    SchoolRepository schoolRepository;

    @Resource
    ApplicationRepository applicationRepository;

    @GetMapping("/getBasicInfo")
    public R getBasicInfo() {
        Long UserNum = userRepository.count();
        Long SchoolNum = schoolRepository.count();
        Long ProgramNum = programRepository.count();
        Long ApplicationNum = applicationRepository.count();
        return R.ok().data("UserNum", UserNum).data("SchoolNum", SchoolNum).data("ProgramNum", ProgramNum).data("ApplicationNum", ApplicationNum);
    }

}
