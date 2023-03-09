package com.group7.config;

import com.group7.db.jpa.*;
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

//        HashSet<ProgramSelection> programSelections1 = new HashSet<>();
//        programSelections1.add(new ProgramSelection(user1, program1));
//        programSelections1.add(new ProgramSelection(user1, program2));
//        programSelections1.add(new ProgramSelection(user1, program3));
//        programSelections1.add(new ProgramSelection(user1, program4));
//        user1.setProgramSelections(programSelections1);

//        Set<Program> programs = new HashSet<>();
//        programs.add(program1);
//        programs.add(program2);
//        programs.add(program3);
//        user1.setSelectedPrograms(programs);

//        Set<User> users = new HashSet<>();
//        users.add(user1);
//        program1.setUsers(users);
//        program2.setUsers(users);
//        program3.setUsers(users);
//        program4.setUsers(users);
//        programRepository.save(program1);
//        programRepository.save(program2);
//        programRepository.save(program3);
//        programRepository.save(program4);

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

        // application key
//        ApplicationKey ak1 = new ApplicationKey(user1.getId(), program1.getId());
//        ApplicationKey ak2 = new ApplicationKey(user1.getId(), program2.getId());
//        ApplicationKey ak3 = new ApplicationKey(user1.getId(), program3.getId());
//        ApplicationKey ak4 = new ApplicationKey(user1.getId(), program4.getId());
//
//        Application application1 = new Application(ak1, user1, program1);
//        Application application2 = new Application(ak2, user1, program2);
//        Application application3 = new Application(ak3, user1, program3);
//        Application application4 = new Application(ak4, user1, program4);
//
//        applicationRepository.save(application1);
//        applicationRepository.save(application2);
//        applicationRepository.save(application3);
//        applicationRepository.save(application4);

        user1.getApplications().add(new Application(new ApplicationKey(user1.getId(), program1.getId()), user1, program1));
        userRepository.save(user1);

//        ApplicationKey applicationKey1 = new ApplicationKey();
//        applicationKey1.setUserId(user1.getId());
//        applicationKey1.setProgramId(program1.getId());
//        Application application1 = new Application();
//        application1.setId(applicationKey1);
//        application1.setUser(user1);
//        application1.setProgram(program1);
//        applicationRepository.save(application1);


        return args -> {
            log.warn("Preloaded database, completed.");
        };
    }
}