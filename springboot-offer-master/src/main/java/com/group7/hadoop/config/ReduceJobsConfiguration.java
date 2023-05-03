package com.group7.hadoop.config;

/**
 * @Author: WangYuyang
 * @Date: 2023/5/3-23:10
 * @Project: springboot-offer-master
 * @Package: com.group7.hadoop.config
 * @Description:
 **/

import com.group7.MainApplication;
import com.group7.hadoop.mapReduce.WordReduce;
import com.group7.hadoop.mapper.WordMapper;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.HashMap;

@Component
public class ReduceJobsConfiguration {

    @Value("${hdfs.hdfsPath}")
    private String hdfsPath;

    /**
     * 获取HDFS配置信息
     *
     * @return
     */
    public Configuration getConfiguration() {
        Configuration configuration = new Configuration();
        configuration.set("fs.defaultFS", hdfsPath);
        configuration.set("mapred.job.tracker", hdfsPath);

        // 运行在yarn的集群模式
        configuration.set("mapreduce.framework.name", "yarn");
        // 设置yarn的resourcemanager的地址
        configuration.set("yarn.resourcemanager.hostname", "hadoop-master");
        // 设置yarn的ResourceManager的地址
        configuration.set("yarn.resourcemanager.address", "hadoop-master:8032");
        // 设置yarn的ResourceManager的scheduler的地址
        configuration.set("yarn.resourcemanager.scheduler.address", "hadoop-master:8030");
        // 设置yarn的ResourceManager的resource-tracker的地址
        configuration.set("yarn.resourcemanager.resource-tracker.address", "hadoop-master:8031");
        // 设置yarn的ResourceManager的admin的地址
        configuration.set("yarn.resourcemanager.admin.address", "hadoop-master:8033");
        // 设置yarn的ResourceManager的webapp的地址
        configuration.set("yarn.resourcemanager.webapp.address", "hadoop-master:8088");
        // 设置yarn的ResourceManager的webapp的https地址
        configuration.set("yarn.resourcemanager.webapp.https.address", "hadoop-master:8090");
        configuration.set("yarn.application.classpath", "/home/hadoop/mapredjars/*:/home/hadoop/hadoop/etc/hadoop:/home/hadoop/hadoop/share/hadoop/common/lib/*:/home/hadoop/hadoop/share/hadoop/common/*:/home/hadoop/hadoop/share/hadoop/hdfs:/home/hadoop/hadoop/share/hadoop/hdfs/lib/*:/home/hadoop/hadoop/share/hadoop/hdfs/*:/home/hadoop/hadoop/share/hadoop/mapreduce/*:/home/hadoop/hadoop/share/hadoop/yarn:/home/hadoop/hadoop/share/hadoop/yarn/lib/*:/home/hadoop/hadoop/share/hadoop/yarn/*");

        // 这个配置是让main方法寻找该机器的mr环境
        configuration.set("yarn.resourcemanmager.hostname", "hadoop-master");
        return configuration;
    }

    /**
     * 获取单词统计的配置信息
     *
     * @param jobName
     * @param inputPath
     * @param outputPath
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws InterruptedException
     */
    public HashMap<String, Object> getWordCountJobsConf(String jobName, String inputPath, String outputPath)
            throws IOException, ClassNotFoundException, InterruptedException {
        Configuration conf = getConfiguration();
        System.out.println(conf);
        Job job = Job.getInstance(conf, jobName);
//        System.out.println(job);
        job.setMapperClass(WordMapper.class);
        job.setCombinerClass(WordReduce.class);
        job.setJarByClass(MainApplication.class);
        job.setReducerClass(WordReduce.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        FileInputFormat.addInputPath(job, new Path(inputPath));
        FileOutputFormat.setOutputPath(job, new Path(outputPath));
        System.out.println("hi");
        System.out.println(job.waitForCompletion(true));
//        job.submit();

        HashMap<String, Object> map = new HashMap<>();
        map.put("JobID", job.getJobID());
        map.put("SchedulingInfo", job.getSchedulingInfo());
        map.put("conf", conf);
        map.put("status", job.getJobState());
        map.put("TrackingURL", job.getTrackingURL());
        System.out.println(hdfsPath);
        System.out.println(job);

        return map;
    }

    @PostConstruct
    public void getPath() {
        hdfsPath = this.hdfsPath;
    }

    public String getHdfsPath() {
        return hdfsPath;
    }
}