package com.group7.service.impl;

import com.group7.db.jpa.*;
import com.group7.db.jpa.utils.EStatus;
import com.group7.service.RecommendationServiceKNN;
import com.group7.service.util.ProgramInfo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RecommendationServiceKNNImpl implements RecommendationServiceKNN {

    @Resource
    ApplicationRepository applicationRepository;

    @Resource
    ProgramRepository programRepository;

    @Override
    public List<Program> similarityCalculate(User user) {

        List<Application> admittedApplications = applicationRepository.findApplicationsByeStatus(EStatus.ADMITTED);
        List<Program> allPrograms = programRepository.findAll();
        List<ProgramInfo> programs = new ArrayList<>();
        Map<Long, Map<String, double[]>> map = new HashMap<>();
        Map<Program, Double> programScores = new HashMap<>();
        Profile profile = user.getProfile();

        List<Program> result = new ArrayList<>();

        for (Application application: admittedApplications) {
            if (map.containsKey(application.getProgram().getId())) {
                map.get(application.getProgram().getId()).get("gpa")[0] += application.getUser().getProfile().getGpa();
                map.get(application.getProgram().getId()).get("gpa")[1] += 1;
            }
            else {
                Map<String, double[]> temp = new HashMap<>();
                temp.put("gpa", new double[]{application.getUser().getProfile().getGpa(), 1});
                map.put(application.getProgram().getId(), temp);
            }
        }

        for (long programID: map.keySet()) {
            Program program = programRepository.findById(programID).orElse(null);
            ProgramInfo programInfo = new ProgramInfo(program);
            Map<String, double[]> entries = map.get(programID);
            for (String entryName: map.get(programID).keySet()) {
                double[] tempData = entries.get(entryName);
                programInfo.setEntry(entryName, tempData[0] / tempData[1]);
            }
            programs.add(programInfo);
        }

        for (ProgramInfo programInfo: programs) {

            double score = 0;
            score += Math.pow(profile.getGpa() - programInfo.getAvgGPA(), 2);
            score = Math.pow(score, 0.5);

            programScores.put(programInfo.getProgram(), score);

        }

        programScores.entrySet()
                .stream().sorted(Map.Entry.comparingByValue())
                .forEachOrdered(x -> {
                    result.add(x.getKey());
                    allPrograms.removeIf(filter -> Objects.equals(filter.getId(), x.getKey().getId()));
                });

        result.addAll(allPrograms);

        return result;

    }

}
