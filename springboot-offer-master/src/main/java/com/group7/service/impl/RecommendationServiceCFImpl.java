package com.group7.service.impl;

import com.group7.db.jpa.*;
import com.group7.service.RecommendationServiceCF;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RecommendationServiceCFImpl implements RecommendationServiceCF {

    @Resource
    UserRepository userRepository;

    @Resource
    ApplicationRepository applicationRepository;

    @Resource
    ProgramRepository programRepository;

    @Override
    public List<User> similarityCalculate(User user) {
        Set<Application> applications = user.getApplications();
        List<User> allUsers = userRepository.findAll();

        allUsers.removeIf(filter -> Objects.equals(filter.getId(), user.getId()));

        Map<User, Double> userScore = new HashMap<>();



        return null;
    }

    @Override
    public List<long[]> getData() {
        List<long[]> result = new ArrayList<>();
        List<Application> applications = applicationRepository.findAll();

        for (Application application: applications) {
            result.add(new long[]{application.getUser().getId(), application.getProgram().getId(), 1});
        }



        return null;
    }
}
