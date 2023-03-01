package com.group7.config;

import com.group7.db.jpa.Profile;
import com.group7.db.jpa.Program;
import com.group7.db.jpa.School;
import com.group7.db.jpa.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

/**
 * @Author: WangYuyang
 * @Date: 2023/2/28-17:49
 * @Project: COMP3032J_FYP_Thesis_Group_7
 * @Package: com.group7.config
 * @Description:
 **/
@Configuration
public class RestConfiguration implements RepositoryRestConfigurer {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        config.exposeIdsFor(Profile.class);
        config.exposeIdsFor(Program.class);
        config.exposeIdsFor(School.class);
        config.exposeIdsFor(User.class);
    }



}