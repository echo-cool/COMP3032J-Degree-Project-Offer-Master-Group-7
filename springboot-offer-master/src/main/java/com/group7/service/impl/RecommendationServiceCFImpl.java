package com.group7.service.impl;

import com.group7.db.jpa.*;
import com.group7.service.RecommendationServiceCF;
import jakarta.annotation.Resource;
import org.apache.mahout.cf.taste.impl.common.FastByIDMap;
import org.apache.mahout.cf.taste.impl.model.GenericDataModel;
import org.apache.mahout.cf.taste.impl.model.GenericUserPreferenceArray;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.CachingRecommender;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.impl.similarity.TanimotoCoefficientSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.model.PreferenceArray;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RecommendationServiceCFImpl implements RecommendationServiceCF {

    @Resource
    UserRepository userRepository;

    @Resource
    ProgramRepository programRepository;

    @Override
    public List<Program> userBasedRecommender(long userID, int size) {
        // step:1 构建模型 2 计算相似度 3 查找k紧邻 4 构造推荐引擎
        List<RecommendedItem> recommendations = null;
        List<Program> programs = new ArrayList<>();
        try {
            DataModel model = this.getData();//构造数据模型
            UserSimilarity similarity = new TanimotoCoefficientSimilarity(model);//用PearsonCorrelation 算法计算用户相似度
            UserNeighborhood neighborhood = new NearestNUserNeighborhood(5, similarity, model);//计算用户的“邻居”，这里将与该用户最近距离为 5 的用户设置为该用户的“邻居”。
            Recommender recommender = new CachingRecommender(new GenericUserBasedRecommender(model, neighborhood, similarity));//采用 CachingRecommender 为 RecommendationItem 进行缓存
            recommendations = recommender.recommend(userID, size);//得到推荐的结果，size是推荐结果的数目

            for (RecommendedItem item: recommendations) {
                programs.add(programRepository.findById(item.getItemID()).orElse(null));
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return programs;
    }

//    private DataModel getDataModel(Map<Long, > listData){
//        FastByIDMap<PreferenceArray> preferenceFastByIDMap = new FastByIDMap();
//        PreferenceArray a = new GenericUserPreferenceArray();
//        a.setUserID();
//
//        GenericDataModel dataModel = new GenericDataModel(preferenceFastByIDMap);
//
//
//    }

    @Override
    public DataModel getData() {
        FastByIDMap<PreferenceArray> preferenceFastByIDMap = new FastByIDMap<>();

        List<User> users = userRepository.findAll();
        List<Program> programs = programRepository.findAll();

        int i = 0;
        for (User user : users) {
            PreferenceArray a = new GenericUserPreferenceArray(programs.size());
            a.setUserID(0, user.getId());
            int c = 0;
            for (Application userApplication: user.getApplications()) {
                a.setItemID(c, userApplication.getProgram().getId());
                a.setValue(c, 1);
                c += 1;
            }

            preferenceFastByIDMap.put(i, a);
            i++;
        }

        return new GenericDataModel(preferenceFastByIDMap);
    }
}
