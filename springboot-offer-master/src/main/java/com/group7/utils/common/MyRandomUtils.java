package com.group7.utils.common;

import java.util.Random;

public class MyRandomUtils {
    private static final Random random = new Random();
    public static Integer getRandomInt(Integer a, Integer b){
        return random.nextInt(a, b);
    }
    public static Random getRandom(){
        return random;
    }

}
