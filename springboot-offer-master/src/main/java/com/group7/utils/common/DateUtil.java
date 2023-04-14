package com.group7.utils.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * @Author: LiuZhe
 * @Date: 2023/3/29 - 18:59
 */
public class DateUtil {

    public static Date getRandomPastDate() throws ParseException {
        // get current time as end time
        Calendar calendar = Calendar.getInstance();
        long end = calendar.getTimeInMillis();

        // set the start time
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = sdf.parse("2022-01-01 00:00:00");
        long start = date.getTime();

        Random random = new Random();

        // random data
        long randomDate = start + (long) (random.nextFloat() * (end - start + 1));

        return new Date(randomDate);
    }

    public static Date getFirstDateOfYear(int year){
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        return calendar.getTime();
    }

    public static Date getLastDateOfYear(int year){
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        calendar.roll(Calendar.DAY_OF_YEAR, -1);
        return calendar.getTime();
    }

}
