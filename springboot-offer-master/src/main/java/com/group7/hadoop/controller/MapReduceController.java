package com.group7.hadoop.controller;

import com.group7.hadoop.service.MapReduceService;
import com.group7.utils.common.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: WangYuyang
 * @Date: 2023/5/3-23:12
 * @Project: springboot-offer-master
 * @Package: com.group7.hadoop.controller
 * @Description:
 **/
@Slf4j
@RestController
@RequestMapping("/api/v1/map-reduce")
public class MapReduceController {

    @Autowired
    private MapReduceService mapReduceService;

    @PostMapping("/word/count")
    public R wordCount(
            @RequestParam(name = "jobName", required = true)
            String jobName,
            @RequestParam(name = "inputPath", required = true)
            String inputPath,
            @RequestParam(name = "outputPath", required = true)
            String outputPath
    ){
        System.out.println("jobName: " + jobName);
        System.out.println("inputPath: " + inputPath);
        System.out.println("outputPath: " + outputPath);
        try {
            return R.ok().data(mapReduceService.wordCount(jobName, inputPath, outputPath));
        } catch (Exception e) {
            log.error(e.getMessage());
            return R.error().message(e.getMessage());
        }
    }
}