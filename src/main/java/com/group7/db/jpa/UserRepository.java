package com.group7.db.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @Author: WangYuyang
 * @Date: 2023/2/27-16:17
 * @Project: COMP3032J_FYP_Thesis_Group_7
 * @Package: com.group7.db.jpa
 * @Description:
 **/
public interface UserRepository  extends JpaRepository<User, Long>{
    User findByUsername(String username);


}
