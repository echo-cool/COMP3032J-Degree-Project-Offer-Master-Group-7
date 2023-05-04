package com.example.springboothadoopconntector.remote.hadoop.controller;

import com.example.springboothadoopconntector.remote.hadoop.service.HDFSService;
import com.example.springboothadoopconntector.remote.hadoop.service.MapReduceService;
import com.example.springboothadoopconntector.remote.hadoop.utils.APIResponse;
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
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Api(tags = "map reduce api")
@RestController
@RequestMapping("/api/v1/map-reduce")
public class MapReduceController {

    @Autowired
    private HDFSService hdfsService;

    @Autowired
    private MapReduceService mapReduceService;

    @ApiOperation("count word")
    @PostMapping("/word/count")
    public APIResponse wordCount(
            @ApiParam(name = "jobName", required = true)
            @RequestParam(name = "jobName", required = true)
            String jobName,
            @ApiParam(name = "inputPath", required = true)
            @RequestParam(name = "inputPath", required = true)
            String inputPath,
            @ApiParam(name = "outputPath", required = true)
            @RequestParam(name = "outputPath", required = true)
            String outputPath
    ){
        try {
            mapReduceService.wordCount(jobName, inputPath, outputPath);
            List<Map<String, Object>> output = hdfsService.listFile(outputPath);
//            Map<String, String> fileContent = new HashMap<>();
//            for (Map<String, Object> map : output) {
//                String filePath = map.get("filePath").toString();
//                String content = hdfsService.readFileContent(filePath);
//                fileContent.put(filePath, content);
//            }
            return APIResponse.success(output);
        } catch (Exception e) {
            log.error(e.getMessage());
            return APIResponse.fail(e.getMessage());
        }
    }
}