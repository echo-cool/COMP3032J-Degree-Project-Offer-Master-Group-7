package com.group7.service;

import com.group7.db.jpa.Program;
import com.group7.db.jpa.User;
import org.apache.mahout.cf.taste.model.DataModel;

import java.util.List;

public interface RecommendationServiceCF {

    public DataModel getData();

    public List<Program> userBasedRecommender(long userID, int size);

}
