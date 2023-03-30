package com.group7.service.impl;

import com.group7.db.jpa.Profile;
import com.group7.db.jpa.User;
import com.group7.db.jpa.UserRepository;
import com.group7.service.RecommendationServiceCF;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RecommendationServiceCFImpl implements RecommendationServiceCF {

    @Resource
    UserRepository userRepository;

    @Override
    public List<User> similarityCalculate(User user) {
        return null;
    }
}
