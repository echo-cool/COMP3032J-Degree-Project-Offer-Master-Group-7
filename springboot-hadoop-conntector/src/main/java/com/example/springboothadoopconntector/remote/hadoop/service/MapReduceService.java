package com.example.springboothadoopconntector.remote.hadoop.service;

import java.util.HashMap;

/**
 * @Author: WangYuyang
 * @Date: 2023/5/3-23:11
 * @Project: springboot-offer-master
 * @Package: com.group7.hadoop.service
 * @Description:
 **/
public interface MapReduceService {

    HashMap<String, Object> wordCount(String jobName, String inputPath, String outputPath) throws Exception;

}