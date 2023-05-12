package com.group7.controller.dashboard;

import com.group7.db.jpa.*;
import com.group7.db.jpa.utils.EStatus;
import com.group7.utils.common.R;
import jakarta.annotation.Resource;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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

    @GetMapping("/get-info-each-month")
    public R getInfoEachMonth() {
        // Get Current Year
        Calendar currCal = Calendar.getInstance();
        int currentYear = currCal.get(Calendar.YEAR);
//        Application application = new Application();
        int[][] tmp = new int[13][3];

        List<Application> applicationList = applicationRepository.findAll();
//        System.out.println(applicationList.get(0).getReportedTime());
//        System.out.println(applicationList.get(0).getReportedTime().getYear() + " -- report year");
//        System.out.println((new Date(currentYear, 1, 1)).getTime());
//        System.out.println("==========");
        for (int i = 0; i < 12; i++){
            for (Application application : applicationList) {
//                System.out.println(application.getReportedTime().getMonth() + " month");
//                System.out.println(application.getReportedTime().getYear() + 1900 + " year");
                if ( (application.getReportedTime().getMonth() == i) && (application.getReportedTime().getYear() == (currentYear - 1900))) {
                    System.out.println(application.getReportedTime() + "  :  month = " + i + 1);
                    if (application.geteStatus() == EStatus.ADMITTED) {
                        tmp[i][0]++;
                    } else if (application.geteStatus() == EStatus.AWAITING_DECISION) {
                        tmp[i][1]++;
                    } else if (application.geteStatus() == EStatus.REJECTED) {
                        tmp[i][2]++;
                    }
                }
            }

        }
        return R.ok().data("data", tmp);
    }

}
