package com.group7.config;

import com.group7.db.jpa.*;
import com.group7.db.jpa.utils.ERole;
import com.group7.db.jpa.utils.EStatus;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;


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
    PasswordEncoder encoder;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SchoolRepository schoolRepository;

    @Autowired
    private ProgramRepository programRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private ApplicationRepository applicationRepository;

    @Bean
    CommandLineRunner initDatabase() {
        log.warn("Preloading database...");

        Role role1 = new Role(ERole.ROLE_USER);
        Role role2 = new Role(ERole.ROLE_MODERATOR);
        Role role3 = new Role(ERole.ROLE_ADMIN);
        log.info("Preloading " + roleRepository.save(role1));
        log.info("Preloading " + roleRepository.save(role2));
        log.info("Preloading " + roleRepository.save(role3));

        School school1 = new School("Duke University");
        School school2 = new School("University of Toronto");
        School school3 = new School("University of Waterloo");
        School school4 = new School("University of British Columbia");
        School school5 = new School("Stanford University");
        School school6 = new School("University of California, Berkeley");
        School school7 = new School("Princeton University");
        School school8 = new School("Harvard University");
        School school9 = new School("Yale University");
        School school10 = new School("Dartmouth College");

        log.info("Preloading " + schoolRepository.save(school1));
        log.info("Preloading " + schoolRepository.save(school2));
        log.info("Preloading " + schoolRepository.save(school3));
        log.info("Preloading " + schoolRepository.save(school4));
        log.info("Preloading " + schoolRepository.save(school5));
        log.info("Preloading " + schoolRepository.save(school6));
        log.info("Preloading " + schoolRepository.save(school7));
        log.info("Preloading " + schoolRepository.save(school8));
        log.info("Preloading " + schoolRepository.save(school9));
        log.info("Preloading " + schoolRepository.save(school10));

        Program program1 = new Program("Computer Science", school1);
        Program program2 = new Program("Computer Engineering", school3);
        Program program3 = new Program("Software Engineering", school2);
        Program program4 = new Program("Computer Science", school6);
        Program program5 = new Program("Statistical Science", school1);
        Program program6 = new Program("Electrical and Computer Engineering", school1);
        Program program7 = new Program("Software Engineering", school7);
        Program program8 = new Program("Software Engineering", school8);
        Program program9 = new Program("Software Engineering", school3);
        Program program10 = new Program("Quantitative Management", school1);
        Program program11 = new Program("Financial Technology", school1);




        log.info("Preloading " + programRepository.save(program1));
        log.info("Preloading " + programRepository.save(program2));
        log.info("Preloading " + programRepository.save(program3));
        log.info("Preloading " + programRepository.save(program4));
        log.info("Preloading " + programRepository.save(program5));
        log.info("Preloading " + programRepository.save(program6));
        log.info("Preloading " + programRepository.save(program7));
        log.info("Preloading " + programRepository.save(program8));
        log.info("Preloading " + programRepository.save(program9));
        log.info("Preloading " + programRepository.save(program10));
        log.info("Preloading " + programRepository.save(program11));

        Set<Role> test1Roles = new HashSet<>();
        test1Roles.add(role1);
        Set<Role> test2Roles = new HashSet<>();
        test2Roles.add(role2);
        Set<Role> test3Roles = new HashSet<>();
        test3Roles.add(role3);

        User user1 = new User("test1", "me1@echo.cool", encoder.encode("111"), test1Roles);
        User user2 = new User("test2", "me2@echo.cool", encoder.encode("111"), test2Roles);
        User user3 = new User("test3", "me3@echo.cool", encoder.encode("111"), test3Roles);
        User user4 = new User("test4", "me4@echo.cool", encoder.encode("111"), test3Roles);
        User user5 = new User("test5", "me5@echo.cool", encoder.encode("111"), test3Roles);
        User user6 = new User("test6", "me6@echo.cool", encoder.encode("111"), test3Roles);
        User user7 = new User("test7", "me7@echo.cool", encoder.encode("111"), test3Roles);
        User user8 = new User("test8", "me8@echo.cool", encoder.encode("111"), test3Roles);
        User user9 = new User("test9", "me9@echo.cool", encoder.encode("111"), test3Roles);
        User user10 = new User("test10", "me10@echo.cool", encoder.encode("111"), test3Roles);
        User user11 = new User("test11", "me11@echo.cool", encoder.encode("111"), test3Roles);
        User user12 = new User("test12", "me12@echo.cool", encoder.encode("111"), test3Roles);
        User user13 = new User("test13", "me13@echo.cool", encoder.encode("111"), test3Roles);

        log.info("Preloading " + userRepository.save(user1));
        log.info("Preloading " + userRepository.save(user2));
        log.info("Preloading " + userRepository.save(user3));
        log.info("Preloading " + userRepository.save(user4));
        log.info("Preloading " + userRepository.save(user5));
        log.info("Preloading " + userRepository.save(user6));
        log.info("Preloading " + userRepository.save(user7));
        log.info("Preloading " + userRepository.save(user8));
        log.info("Preloading " + userRepository.save(user9));
        log.info("Preloading " + userRepository.save(user10));
        log.info("Preloading " + userRepository.save(user11));
        log.info("Preloading " + userRepository.save(user12));

        Application application1 = new Application(user1, program1, EStatus.REJECTED, "Phd");
        Application application2 = new Application(user1, program2, EStatus.ADMITTED, "MEng");
        Application application3 = new Application(user1, program3, EStatus.AWAITING_DECISION, "MS");
        Application application4 = new Application(user1, program4, EStatus.AWAITING_REVIEW, "MS");

        applicationRepository.save(application1);
        applicationRepository.save(application2);
        applicationRepository.save(application3);
        applicationRepository.save(application4);


        return args -> {
            log.warn("Preloaded database, completed.");
        };
    }
}