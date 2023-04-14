package com.group7.service.impl;

import com.group7.db.jpa.*;
import com.group7.service.RecommendationServiceCF;
import jakarta.annotation.Resource;
import org.apache.mahout.cf.taste.impl.common.FastByIDMap;
import org.apache.mahout.cf.taste.impl.model.GenericDataModel;
import org.apache.mahout.cf.taste.impl.model.GenericPreference;
import org.apache.mahout.cf.taste.impl.model.GenericUserPreferenceArray;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.model.Preference;
import org.apache.mahout.cf.taste.model.PreferenceArray;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Consumer;

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

//    private DataModel getDataModel(Map<Long, > listData){
//        FastByIDMap<PreferenceArray> preferenceFastByIDMap = new FastByIDMap();
//        PreferenceArray a = new GenericUserPreferenceArray();
//        a.setUserID();
//
//        GenericDataModel dataModel = new GenericDataModel(preferenceFastByIDMap);
//
//
//    }

    @Override
    public List<long[]> getData() {
        List<long[]> result = new ArrayList<>();
        List<Application> applications = applicationRepository.findAll();

        for (Application application: applications) {
            result.add(new long[]{application.getUser().getId(), application.getProgram().getId(), 1});
        }

        List<User> users = userRepository.findAll();
        List<Program> programs = programRepository.findAll();

        for (User user: users) {
            for (Program program: programs) {
                if (!applicationRepository.existsApplicationByUser_IdAndProgram_Id(user.getId(), program.getId())) {
                    result.add(new long[]{user.getId(), program.getId(), 0});
                }
            }
        }

        return result;
    }
}
