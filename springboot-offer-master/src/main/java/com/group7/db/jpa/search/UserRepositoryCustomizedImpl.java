//package com.group7.db.jpa.search;
//
//import com.group7.db.jpa.User;
//import com.group7.db.jpa.UserRepository;
//import com.group7.db.jpa.utils.SpecificationsBuilder;
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.PersistenceContext;
//import org.hibernate.validator.internal.util.stereotypes.Lazy;
//import org.springframework.data.jpa.domain.Specification;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//
///**
// * @Author: WangYuyang
// * @Date: 2023/3/9-21:57
// * @Project: COMP3032J_FYP_Thesis_Group_7
// * @Package: com.group7.db.jpa
// * @Description:
// **/
//
//@Component
//public class UserRepositoryCustomizedImpl implements UserRepositoryCustomized {
//
////    @Lazy
//    private final UserRepository userRepository;
//
//    @PersistenceContext
//    private EntityManager entityManager;
//
//    public UserRepositoryCustomizedImpl(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    @Override
//    public List<User> searchBy(String query) {
//        Specification<User> spec = new SpecificationsBuilder<User>().buildSpecification(query);
//        return userRepository.findAll(spec);
//    }
//}
