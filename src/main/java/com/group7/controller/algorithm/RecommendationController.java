package com.group7.controller.algorithm;

import com.group7.db.jpa.Program;
import com.group7.db.jpa.User;
import com.group7.service.RecommendationServiceKNN;
import com.group7.utils.common.JwtUtils;
import com.group7.utils.common.R;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/recommendation")
public class RecommendationController {

    @Resource
    JwtUtils jwtUtils;

    @Resource
    RecommendationServiceKNN recommendationServiceKNN;

    @RequestMapping("/similarity-calculation-cf")
    public ResponseEntity<?> similarityCalculationCF(HttpServletRequest request) {

        Double res = 0d;
        return ResponseEntity.ok(R.ok().data("data", res));
    }

    @RequestMapping("/similarity-calculation-knn")
    public ResponseEntity<?> similarityCalculationKNN(HttpServletRequest request) {
        // get the current user
        User user = jwtUtils.getUserFromRequestByToken(request);

        List<Program> res = recommendationServiceKNN.similarityCalculate(user);

        return ResponseEntity.ok(R.ok().data("data", res));
    }

}
