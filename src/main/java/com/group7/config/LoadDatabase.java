package com.group7.config;

import com.group7.db.jpa.*;
import com.group7.db.jpa.utils.EMajor;
import com.group7.db.jpa.utils.ERole;
import com.group7.db.jpa.utils.EStatus;
import jakarta.servlet.http.HttpServletRequest;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    CommandLineRunner initDatabase() throws ParseException {
        log.warn("Preloading database...");

        Role role1 = new Role(ERole.ROLE_USER);
        Role role2 = new Role(ERole.ROLE_MODERATOR);
        Role role3 = new Role(ERole.ROLE_ADMIN);
        log.info("Preloading " + roleRepository.save(role1));
        log.info("Preloading " + roleRepository.save(role2));
        log.info("Preloading " + roleRepository.save(role3));

        School school1 = new School("Duke University", 1, 10);
        School school2 = new School("University of Toronto", 2, 9);
        School school3 = new School("University of Waterloo", 3, 8);
        School school4 = new School("University of British Columbia", 4, 7);
        School school5 = new School("Stanford University", 5, 6);
        School school6 = new School("University of California, Berkeley", 6, 5);
        School school7 = new School("Princeton University", 7, 4);
        School school8 = new School("Harvard University", 8, 3);
        School school9 = new School("Yale University", 9, 2);
        School school10 = new School("Dartmouth College", 10, 1);

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

        Program program1 = new Program("Computer Science", school1, "MS", EMajor.CS);
        Program program1_2 = new Program("Computer Science", school1, "MEng", EMajor.CS);
        Program program1_3 = new Program("Computer Science", school1, "PhD", EMajor.MIS);
        Program program2 = new Program("Computer Engineering", school3, "MS", EMajor.CS);
        Program program3 = new Program("Software Engineering", school2, "MS", EMajor.EE);
        Program program4 = new Program("Computer Science", school6, "MS", EMajor.CS);
        Program program5 = new Program("Statistical Science", school1, "PhD", EMajor.MIS);
        Program program6 = new Program("Electrical and Computer Engineering", school1, "MS", EMajor.EE);
        Program program7 = new Program("Software Engineering", school7, "MS", EMajor.CS);
        Program program8 = new Program("Software Engineering", school8, "PhD", EMajor.CS);
        Program program9 = new Program("Software Engineering", school3, "MS", EMajor.MIS);
        Program program10 = new Program("Quantitative Management", school1, "PhD", EMajor.CS);
        Program program11 = new Program("Financial Technology", school1, "MS", EMajor.EE);




        log.info("Preloading " + programRepository.save(program1));
        log.info("Preloading " + programRepository.save(program1_2));
        log.info("Preloading " + programRepository.save(program1_3));
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


        // for default deadline
        String str = "2024-02-15";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date ddl = sdf.parse(str);

        Application application1 = new Application(user1, program1, EStatus.REJECTED, ddl);
        Application application2 = new Application(user1, program2, EStatus.ADMITTED, ddl);
        Application application3 = new Application(user1, program3, EStatus.AWAITING_DECISION, ddl);
        Application application4 = new Application(user1, program4, EStatus.AWAITING_REVIEW, ddl);
        Application application5 = new Application(user1, program1_2, EStatus.AWAITING_REVIEW, ddl);
        Application application6 = new Application(user1, program1_3, EStatus.AWAITING_REVIEW, ddl);
        Application application7 = new Application(user2, program3, EStatus.ADMITTED, ddl);

        applicationRepository.save(application1);
        applicationRepository.save(application2);
        applicationRepository.save(application3);
        applicationRepository.save(application4);
        applicationRepository.save(application5);
        applicationRepository.save(application6);
        applicationRepository.save(application7);


        return args -> log.warn("Preloaded database, completed.");
    }
}