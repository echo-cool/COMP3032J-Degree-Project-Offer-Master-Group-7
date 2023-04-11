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

    @Resource
    ProfileRepository profileRepository;

    @Override
    public List<Program> similarityCalculate(User user) {

        List<Application> admittedApplications = applicationRepository.findApplicationsByeStatus(EStatus.ADMITTED);
        List<Program> allPrograms = programRepository.findAll();
        List<ProgramInfo> programs = new ArrayList<>();
        Map<Long, Map<String, double[]>> map = new HashMap<>();
        Map<Program, Double> programScores = new HashMap<>();
        Profile profile = user.getProfile();

        double maxGpa = 0;
        double minGpa = 0;
        double maxIELTS = 0;
        double minIELTS = 0;
        double maxTOEFL = 0;
        double minTOEFL = 0;

        long before = System.currentTimeMillis();

        List<Profile> profiles = profileRepository.findAll();

        if (profileRepository.findByRanking(0).size() != profiles.size() ) {
            List<Profile> profilesSortedByGpa = profiles.stream().filter(filter -> filter.getRanking() != 0).sorted((o1, o2) -> (int) (o1.getGpa() - o2.getGpa())).toList();
            List<Profile> profilesSortedByIELTS = profiles.stream().filter(filter -> filter.getRanking() != 0).sorted((o1, o2) -> (int) (o1.getTotalIELTS() - o2.getTotalIELTS())).toList();
            List<Profile> profilesSortedByTOEFL = profiles.stream().filter(filter -> filter.getRanking() != 0).sorted(Comparator.comparingInt(Profile::getTotalTOEFL)).toList();

            maxGpa = profilesSortedByGpa.get(profilesSortedByGpa.size() - 1).getGpa();
            minGpa = profilesSortedByGpa.get(0).getGpa();
            maxIELTS = profilesSortedByIELTS.get(profilesSortedByGpa.size() - 1).getTotalIELTS();
            minIELTS = profilesSortedByIELTS.get(0).getTotalIELTS();
            maxTOEFL = profilesSortedByTOEFL.get(profilesSortedByGpa.size() - 1).getTotalTOEFL();
            minTOEFL = profilesSortedByTOEFL.get(0).getTotalTOEFL();
        }

        long after = System.currentTimeMillis();

        System.out.println("First:" + (after - before));

        before = System.currentTimeMillis();

        List<Program> result = new ArrayList<>();

        for (Application application: admittedApplications) {
            if (map.containsKey(application.getProgram().getId())) {
                map.get(application.getProgram().getId()).get("gpa")[0] += application.getUser().getProfile().getGpa();
                map.get(application.getProgram().getId()).get("gpa")[1] += 1;

                map.get(application.getProgram().getId()).get("ielts")[0] += application.getUser().getProfile().getTotalIELTS();
                map.get(application.getProgram().getId()).get("ielts")[1] += 1;

                map.get(application.getProgram().getId()).get("toefl")[0] += application.getUser().getProfile().getTotalTOEFL();
                map.get(application.getProgram().getId()).get("toefl")[1] += 1;
            }
            else {
                Map<String, double[]> temp = new HashMap<>();

                temp.put("gpa", new double[]{application.getUser().getProfile().getGpa(), 1});
                temp.put("ielts", new double[]{application.getUser().getProfile().getTotalIELTS(), 1});
                temp.put("toefl", new double[]{application.getUser().getProfile().getTotalTOEFL(), 1});

                map.put(application.getProgram().getId(), temp);
            }
        }

        after = System.currentTimeMillis();

        System.out.println("Second:" + (after - before));

        before = System.currentTimeMillis();

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

        after = System.currentTimeMillis();

        System.out.println("Third:" + (after - before));

        before = System.currentTimeMillis();

        for (ProgramInfo programInfo: programs) {

            double score = 0;
            score += Math.pow(((profile.getGpa() - minGpa) / (maxGpa - minGpa)) - ((programInfo.getAvgGPA() - minGpa) / (maxGpa - minGpa)), 2);
            score += Math.pow(((profile.getTotalIELTS() - minIELTS) / (maxIELTS - minIELTS)) - ((programInfo.getAvgIELTS() - minIELTS) / (maxIELTS - minIELTS)), 2);
            score += Math.pow(((profile.getTotalTOEFL() - minTOEFL) / (maxTOEFL - minTOEFL)) - ((programInfo.getAvgTOEFL() - minTOEFL) / (maxTOEFL - minTOEFL)), 2);

            score = Math.pow(score, 0.5);

            programScores.put(programInfo.getProgram(), score);

        }

        after = System.currentTimeMillis();

        System.out.println("Forth:" + (after - before));

        before = System.currentTimeMillis();

        programScores.entrySet()
                .stream().sorted(Map.Entry.comparingByValue())
                .forEachOrdered(x -> {
                    result.add(x.getKey());
                    allPrograms.removeIf(filter -> Objects.equals(filter.getId(), x.getKey().getId()));
                });

        result.addAll(allPrograms);

        after = System.currentTimeMillis();

        System.out.println("Fifth:" + (after - before));

        return result;

    }

}
