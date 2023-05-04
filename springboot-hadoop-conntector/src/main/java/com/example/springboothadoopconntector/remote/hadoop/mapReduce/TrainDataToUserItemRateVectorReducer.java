package com.example.springboothadoopconntector.remote.hadoop.mapReduce;

/**
 * @Author: WangYuyang
 * @Date: 2023/5/4-18:45
 * @Project: springboot-hadoop-conntector
 * @Package: com.example.springboothadoopconntector.remote.hadoop.mapReduce
 * @Description:
 **/

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.mahout.math.RandomAccessSparseVector;
import org.apache.mahout.math.VarLongWritable;
import org.apache.mahout.math.VectorWritable;
import org.apache.mahout.math.Vector;

public class TrainDataToUserItemRateVectorReducer
        extends Reducer<VarLongWritable, Text, VarLongWritable, VectorWritable> {

    public void reduce(VarLongWritable userID, Iterable<Text> itemRates, Context context)
            throws IOException, InterruptedException {
        Vector userVector = new RandomAccessSparseVector(Integer.MAX_VALUE);
        //double rate = -1;
        for (Text itemRate : itemRates) {
            String[] itemRateAry = itemRate.toString().split(" ");
            //rate = Double.parseDouble(itemRateAry[1]) == 1.0 ? 1.0: -1;

            userVector.set(Integer.valueOf(itemRateAry[0]), Double.parseDouble(itemRateAry[1]));
        }
        context.write(userID, new VectorWritable(userVector));
    }
}