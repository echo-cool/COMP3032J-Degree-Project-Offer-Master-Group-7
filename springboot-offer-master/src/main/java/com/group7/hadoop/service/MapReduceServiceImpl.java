package com.group7.hadoop.service;

/**
 * @Author: WangYuyang
 * @Date: 2023/5/3-23:11
 * @Project: springboot-offer-master
 * @Package: com.group7.hadoop.service
 * @Description:
 **/
import com.group7.hadoop.config.ReduceJobsConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;

@Service
public class MapReduceServiceImpl implements MapReduceService {

    @Autowired
    private HDFSService hdfsService;

    @Autowired
    private ReduceJobsConfiguration reduceJobsConfiguration;

    @Override
    public HashMap<String, Object> wordCount(String jobName, String inputPath, String outputPath) throws Exception {
        if (StringUtils.isEmpty(jobName) || StringUtils.isEmpty(inputPath)) {
            return null;
        }
        // 输出目录 = output/当前Job,如果输出路径存在则删除，保证每次都是最新的
        if (hdfsService.existFile(outputPath)) {
            System.out.println("输出路径存在，删除中...");
            hdfsService.deleteFile(outputPath);
        }
        return reduceJobsConfiguration.getWordCountJobsConf(jobName, inputPath, outputPath);

    }
}