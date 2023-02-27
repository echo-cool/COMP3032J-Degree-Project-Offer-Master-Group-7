package com.group7.config;

import com.group7.db.jpa.User;
import com.group7.db.jpa.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @Author: WangYuyang
 * @Date: 2023/2/27-15:29
 * @Project: COMP3032J_FYP_Thesis_Group_7
 * @Package: com.group7.config
 * @Description:
 **/
@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(UserRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new User("test", "me@echo.cool", "111")));
            log.info("Preloading " + repository.save(new User("1112", "me@echo.cool", "111")));
            log.info("Preloading " + repository.save(new User("111", "me@echo.cool", "111", "admin")));

        };
    }
}