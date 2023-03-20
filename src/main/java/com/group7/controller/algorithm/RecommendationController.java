package com.group7.controller.algorithm;

import com.group7.db.jpa.School;
import com.group7.db.jpa.User;
import com.group7.entitiy.SchoolQueryVo;
import com.group7.utils.common.R;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/recommendation")
public class RecommendationController {

    @RequestMapping("/similarity-calculation")
    public R similarityCalculation(@RequestBody(required = false) User user1,
                            @RequestBody(required = false) User user2) {
        Double res = 0d;
        return R.ok().data("data", res);
    }


}
