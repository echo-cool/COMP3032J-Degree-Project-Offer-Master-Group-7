package com.example.springboothadoopconntector.remote.hadoop.mapper;

/**
 * @Author: WangYuyang
 * @Date: 2023/5/4-18:19
 * @Project: springboot-hadoop-conntector
 * @Package: com.example.springboothadoopconntector.remote.hadoop.mapper
 * @Description:
 **/
import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.mahout.math.VarLongWritable;
import org.apache.mahout.math.VectorWritable;
import org.apache.mahout.math.Vector;

public class ToItemCooccurrenceMapper extends Mapper<VarLongWritable, VectorWritable, IntWritable, IntWritable> {
    public void map(VarLongWritable userID, VectorWritable userVector, Context context)
            throws IOException, InterruptedException {
        Iterator<Vector.Element> it1 = userVector.get().nonZeroes().iterator();
        while (it1.hasNext()) {
            int idx1 = it1.next().index();
            Iterator<Vector.Element> it2 = userVector.get().nonZeroes().iterator();
            while (it2.hasNext()) {
                int idx2 = it2.next().index();
                context.write(new IntWritable(idx1), new IntWritable(idx2));
            }
        }
    }
}