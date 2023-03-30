package com.group7.service;

import com.group7.db.jpa.Program;
import com.group7.db.jpa.User;

import java.util.List;

public interface RecommendationServiceKNN {

    public List<Program> similarityCalculate(User user);

}
