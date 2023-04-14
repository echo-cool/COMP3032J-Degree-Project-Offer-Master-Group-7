package com.group7.service;

import com.group7.db.jpa.User;

import java.util.ArrayList;
import java.util.List;

public interface RecommendationServiceCF {

    public List<User> similarityCalculate(User user);

    public List<long []> getData();

}
