package com.example.springboothadoopconntector.remote.hadoop.mapper;

/**
 * @Author: WangYuyang
 * @Date: 2023/5/4-18:45
 * @Project: springboot-hadoop-conntector
 * @Package: com.example.springboothadoopconntector.remote.hadoop.mapper
 * @Description:
 **/
import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.mahout.math.VarLongWritable;

public final class TrainDataToUserTextMapper extends Mapper<LongWritable, Text, VarLongWritable, Text> {

    @Override
    protected void map(LongWritable key, Text rowText, Context context)
            throws IOException, InterruptedException {
        String[] columns = rowText.toString().split("\t");

        VarLongWritable userID = new VarLongWritable(Long.parseLong(columns[0]));
        Text itemIDRate = new Text(columns[1] + " " + columns[2]);

        context.write(userID, itemIDRate);
    }
}