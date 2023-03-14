package com.group7.controller.school;

import com.group7.db.jpa.School;
import com.group7.db.jpa.SchoolRepository;
import com.group7.db.jpa.UserRepository;
import com.group7.entitiy.SchoolQueryVo;
import com.group7.service.SchoolService;
import com.group7.utils.common.R;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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

}
