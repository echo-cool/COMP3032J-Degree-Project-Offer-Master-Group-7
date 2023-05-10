package com.group7.db.jpa.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: LiuZhe
 * @Date: 2023/5/10 - 21:47
 */
public class AdmissionCountData {

    // key: program id, value: count list
    public static Map<Long, long[]> AdmissionCountThisYear = new HashMap<>();
    public static Map<Long, long[]> AdmissionCountLastYear = new HashMap<>();

}
