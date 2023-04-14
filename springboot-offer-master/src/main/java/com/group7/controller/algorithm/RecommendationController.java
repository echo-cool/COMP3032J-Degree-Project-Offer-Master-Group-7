package com.group7.controller.algorithm;

import com.group7.db.jpa.Program;
import com.group7.db.jpa.User;
import com.group7.service.RecommendationServiceCF;
import com.group7.service.RecommendationServiceKNN;
import com.group7.utils.common.JwtUtils;
import com.group7.utils.common.R;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.springframework.http.ResponseEntity;
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

    @Resource
    RecommendationServiceCF recommendationServiceCF;

    @RequestMapping("/similarity-calculation-cf")
    public ResponseEntity<?> similarityCalculationCF(HttpServletRequest request) {

        User user = jwtUtils.getUserFromRequestByToken(request);

        List<RecommendedItem> res = recommendationServiceCF.userBasedRecommender(user.getId(), 5);
        return ResponseEntity.ok(R.ok().data("data", res));
    }

    @GetMapping("/program-recommendation-knn")
    public ResponseEntity<?> programRecommendationKNN(HttpServletRequest request) {
        // get the current user
        User user = jwtUtils.getUserFromRequestByToken(request);

        List<Program> res = recommendationServiceKNN.similarityCalculate(user);

        return ResponseEntity.ok(R.ok().data("data", res));
    }

}
