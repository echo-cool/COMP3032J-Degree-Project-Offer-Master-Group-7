package com.group7.config;

import com.group7.db.jpa.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SchoolRepository schoolRepository;


    @Autowired
    private ProgramRepository programRepository;
    @Bean
    CommandLineRunner initDatabase() {
        School school1 = new School("Duke University");
        School school2 = new School("University of Toronto");
        School school3 = new School("University of Waterloo");
        School school4 = new School("University of British Columbia");
        School school5 = new School("Stanford University");
        School school6 = new School("University of California, Berkeley");

        log.info("Preloading " + schoolRepository.save(school1));
        log.info("Preloading " + schoolRepository.save(school2));
        log.info("Preloading " + schoolRepository.save(school3));
        log.info("Preloading " + schoolRepository.save(school4));
        log.info("Preloading " + schoolRepository.save(school5));
        log.info("Preloading " + schoolRepository.save(school6));

        Program program1 = new Program("Computer Science", school1);
        Program program2 = new Program("Computer Engineering", school3);
        Program program3 = new Program("Software Engineering", school2);
        Program program4 = new Program("Computer Science", school6);


        log.info("Preloading " + programRepository.save(program1));
        log.info("Preloading " + programRepository.save(program2));
        log.info("Preloading " + programRepository.save(program3));
        log.info("Preloading " + programRepository.save(program4));




        return args -> {
            log.info("Preloading " + userRepository.save(new User("test", "me@echo.cool", "111")));
            log.info("Preloading " + userRepository.save(new User("1112", "me@echo.cool", "111")));
            log.info("Preloading " + userRepository.save(new User("111", "me@echo.cool", "111", "admin")));



        };
    }
}