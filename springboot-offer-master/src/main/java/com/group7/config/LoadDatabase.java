package com.group7.config;

import com.group7.db.jpa.*;
import com.group7.db.jpa.utils.*;
import com.group7.utils.common.DateUtil;
import com.group7.utils.common.MyRandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.parameters.P;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import static com.group7.config.LoadExternalData.loadExternalSchoolData;


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
    private ChatRepository chatRepository;
    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private PostCategoryRepository postCategoryRepository;

    @Bean
    CommandLineRunner initDatabase() throws ParseException {
        log.warn("Preloading database...");

        Role role1 = new Role(ERole.ROLE_USER);
        Role role2 = new Role(ERole.ROLE_MODERATOR);
        Role role3 = new Role(ERole.ROLE_ADMIN);
        log.info("Preloading " + roleRepository.save(role1));
        log.info("Preloading " + roleRepository.save(role2));
        log.info("Preloading " + roleRepository.save(role3));

        School school1 = new School("Duke University", 1, 10, "Duke University logo.png", "Duke University.webp",
                "36.001465", "-78.939133",
                new String[]{
                        "default/default.jpg",
                });
        School school2 = new School("University of Toronto", 2, 9, "University of Toronto logo.png", "University of Toronto.webp",
                "43.664486", "-79.399689",
                new String[]{
                        "default/default.jpg",
                });
        School school3 = new School("University of Waterloo", 3, 8, "University of Waterloo logo.png", "University of Waterloo.png",
                "43.4723", "-80.5449",
                new String[]{
                        "default/default.jpg",
                });
        School school4 = new School("University of British Columbia", 4, 7, "University of British Columbia logo.png", "University of British Columbia.jpg",
                "49.2667", "-123.2500",
                new String[]{
                        "default/default.jpg",
                });
        School school5 = new School("Stanford University", 5, 6, "Stanford University logo.webp", "Stanford University.webp",
                "37.428230", "-122.168861",
                new String[]{
                        "default/default.jpg",
                });
        School school6 = new School("University of California, Berkeley", 6, 5, "University of British Columbia logo.png", "University of British Columbia.jpg",
                "37.871960", "-122.259094",
                new String[]{
                        "default/default.jpg",
                });
        School school7 = new School("Princeton University", 7, 4, "Princeton University logo.svg", "Princeton University.jpg",
                "40.343899", "-74.660049",
                new String[]{
                        "default/default.jpg",
                });
        School school8 = new School("Harvard University", 8, 3, "Harvard University logo.png", "Harvard University.webp",
                "42.374443", "-71.116943",
                new String[]{
                        "default/default.jpg",
                });
        School school9 = new School("Yale University", 9, 2, "Yale University logo.png", "Yale University.png",
                "41.316307", "-72.922585",
                new String[]{
                        "default/default.jpg",
                });
        School school10 = new School("Dartmouth College", 10, 1, "Dartmouth College logo.png", "Dartmouth College.jpg",
                "43.704540", "-72.288986",
                new String[]{
                        "default/default.jpg",
                });

        List<School> schools = new ArrayList<>();
        schools.add(school1);
        schools.add(school2);
        schools.add(school3);
        schools.add(school4);
        schools.add(school5);
        schools.add(school6);
        schools.add(school7);
        schools.add(school8);
        schools.add(school9);
        schools.add(school10);
        for (School school : schools) {
            log.info("Preloading " + schoolRepository.save(school));
        }

        Program program1 = new Program("Computer Science", school1, "MS", EMajor.CS, "MS Computer Science.jpg");
        Program program1_2 = new Program("Computer Science", school1, "MEng", EMajor.CS, "MEng Computer Science.jpg");
        Program program1_3 = new Program("Computer Science", school1, "PhD", EMajor.MIS, "PhD Computer Science.jpg");
        Program program2 = new Program("Computer Engineering", school3, "MS", EMajor.CS, "MS Computer Engineering.jpg");
        Program program3 = new Program("Software Engineering", school2, "MS", EMajor.EE, "MS Software Engineering.jpg");
        Program program4 = new Program("Computer Science", school6, "MS", EMajor.CS, "MS Computer Science.jpg");
        Program program5 = new Program("Statistical Science", school1, "PhD", EMajor.MIS, "MS Statistical Science.jpg");
        Program program6 = new Program("Electrical and Computer Engineering", school1, "MS", EMajor.EE, "MS Electrical and Computer Engineering.jpg");
        Program program7 = new Program("Software Engineering", school7, "MS", EMajor.CS, "MS Software Engineering.jpg");
        Program program8 = new Program("Software Engineering", school8, "PhD", EMajor.CS, "PhD Software Engineering.jpg");
        Program program9 = new Program("Software Engineering", school3, "MS", EMajor.MIS, "MS Software Engineering.jpg");
        Program program10 = new Program("Quantitative Management", school1, "PhD", EMajor.CS, "Quantitative Management.jpg");
        Program program11 = new Program("Financial Technology", school1, "MS", EMajor.EE, "Financial Technology.webp");


        List<Program> programs = new ArrayList<>();
        programs.add(program1);
        programs.add(program1_2);
        programs.add(program1_3);
        programs.add(program2);
        programs.add(program3);
        programs.add(program4);
        programs.add(program5);
        programs.add(program6);
        programs.add(program7);
        programs.add(program8);
        programs.add(program9);
        programs.add(program10);
        programs.add(program11);
        for (Program program : programs) {
            log.info("Preloading " + programRepository.save(program));
        }

        Set<Role> test1Roles = new HashSet<>();
        test1Roles.add(role1);
        Set<Role> test2Roles = new HashSet<>();
        test2Roles.add(role2);
        Set<Role> test3Roles = new HashSet<>();
        test3Roles.add(role3);

        User user1 = new User("Yuyang Wang", "me1@echo.cool", encoder.encode("111"), test1Roles);
        User user2 = new User("Jinfeng Xu", "me2@echo.cool", encoder.encode("111"), test1Roles);
        User user3 = new User("Zhe Liu", "me3@echo.cool", encoder.encode("111"), test3Roles);
        User user4 = new User("Zixiao Ma", "me4@echo.cool", encoder.encode("111"), test3Roles);
        User user5 = new User("Liuxin Yang", "me5@echo.cool", encoder.encode("111"), test3Roles);
        User user6 = new User("Zheyu Chen", "me6@echo.cool", encoder.encode("111"), test3Roles);
        User user7 = new User("Zhuoyi Zhang", "me7@echo.cool", encoder.encode("111"), test3Roles);
        User user8 = new User("Mingjia Zhang", "me8@echo.cool", encoder.encode("111"), test3Roles);
        User user9 = new User("San Zhang", "me9@echo.cool", encoder.encode("111"), test3Roles);
        User user10 = new User("Wu Wang", "me10@echo.cool", encoder.encode("111"), test3Roles);
        User user11 = new User("Zhuo Song", "me11@echo.cool", encoder.encode("111"), test3Roles);
        User user12 = new User("Ba Xue", "me12@echo.cool", encoder.encode("111"), test3Roles);
        User user13 = new User("Ge Shan", "me13@echo.cool", encoder.encode("111"), test3Roles);
        User user14 = new User("Jiaxin Wei", "me14@echo.cool", encoder.encode("111"), test3Roles);

        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);
        users.add(user6);
        users.add(user7);
        users.add(user8);
        users.add(user9);
        users.add(user10);
        users.add(user11);
        users.add(user12);
        users.add(user13);
        for (User user : users) {
            log.info("Preloading " + userRepository.save(user));
        }

        Profile profile = new Profile("2023 - Fall", "PhD", "CS", "AD - With Fellowship", 4.0, 1,
                "Oversea Undergraduate", "BJUT", "CS", "IELTS", 9, 9, 9, 9, 9, 0, 0, 0, 0, 0, 340, 6, 170, 170);
        user1.setProfile(profile);
        userRepository.save(user1);

        // for default deadline
        String str = "2024-02-15";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date ddl = sdf.parse(str);

//        Application application1 = new Application(user1, program1, EStatus.REJECTED, ddl, ERound.SUMMER_2023, DateUtil.getRandomPastDate());
//        Application application2 = new Application(user1, program2, EStatus.ADMITTED, ddl, ERound.SUMMER_2023, DateUtil.getRandomPastDate());
//        Application application3 = new Application(user1, program3, EStatus.AWAITING_DECISION, ddl, ERound.SUMMER_2023, DateUtil.getRandomPastDate());
//        Application application4 = new Application(user1, program4, EStatus.AWAITING_REVIEW, ddl, ERound.SUMMER_2023, DateUtil.getRandomPastDate());
//        Application application5 = new Application(user1, program1_2, EStatus.ADMITTED, ddl, ERound.SPRING_2024, DateUtil.getRandomPastDate());
//        Application application6 = new Application(user1, program1_3, EStatus.AWAITING_REVIEW, ddl, ERound.SUMMER_2023, DateUtil.getRandomPastDate());
//        Application application7 = new Application(user2, program3, EStatus.ADMITTED, ddl, ERound.SUMMER_2023, DateUtil.getRandomPastDate());
//
//
//        applicationRepository.save(application1);
//        applicationRepository.save(application2);
//        applicationRepository.save(application3);
//        applicationRepository.save(application4);
//        applicationRepository.save(application5);
//        applicationRepository.save(application6);
//        applicationRepository.save(application7);

//        for (User user : users) {
//            for (Program program: programs){
//                if(MyRandomUtils.getRandomInt(0,10) > 7){
//                    if (MyRandomUtils.getRandomInt(0,10) % 2 == 0){
//                        applicationRepository.save(new Application(user, program, EStatus.REJECTED, ddl, ERound.SUMMER_2023, DateUtil.getRandomPastDate()));
//                    }else{
//                        applicationRepository.save(new Application(user, program, EStatus.ADMITTED, ddl, ERound.SUMMER_2023, DateUtil.getRandomPastDate()));
//                    }
//                }
//            }
//        }
        PostCategory postCategory1 = new PostCategory("Study");
        PostCategory postCategory2 = new PostCategory("Application");

        postCategoryRepository.save(postCategory1);
        postCategoryRepository.save(postCategory2);

        Post post1 = new Post("123", "123", postCategory1, user1);
        Post post2 = new Post("qwq", "qwq", postCategory2, user2);

        postRepository.save(post1);
        postRepository.save(post2);


        Article article1 = new Article("1", "123", user1);
        Article article2 = new Article("2", "qwq", user2);

        articleRepository.save(article1);
        articleRepository.save(article2);

        Chat chat1 = new Chat("Yuyang Wang", "Jinfeng Xu", "6661");
        Chat chat2 = new Chat("Jinfeng Xu", "Yuyang Wang", "6662");

        chatRepository.save(chat1);
        chatRepository.save(chat2);


        loadExternalSchoolData(schoolRepository, programRepository);
        generateRandomApplication(users, programRepository.findAll());
        return args -> log.warn("Preloaded database, completed.");
    }

    public static <E> List<E> pickNRandomElements(List<E> list, int n, Random r) {
        int length = list.size();

        if (length < n) return null;

        //We don't need to shuffle the whole list
        for (int i = length - 1; i >= length - n; --i) {
            Collections.swap(list, i, r.nextInt(i + 1));
        }
        return list.subList(length - n, length);
    }

    public static <E> List<E> pickNRandomElements(List<E> list, int n) {
        return pickNRandomElements(list, n, ThreadLocalRandom.current());
    }

    private void generateRandomApplication(List<User> users, List<Program> programs) {
        String str = "2024-02-15";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date ddl = null;
        EStatus[] statuses = new EStatus[]{EStatus.ADMITTED, EStatus.REJECTED, EStatus.AWAITING_DECISION};
        try {
            ddl = sdf.parse(str);
            for (User user : users) {
                List<Program> programsUser = pickNRandomElements(programs, MyRandomUtils.getRandomInt(3, 25));
                System.out.println(user + ": " + programsUser);
                for (Program p : programsUser) {
                    Application application = new Application(user, p, statuses[MyRandomUtils.getRandomInt(0, statuses.length)], ddl, ERound.SUMMER_2023, DateUtil.getRandomPastDate());
                    System.out.println("\t" + application);
                    applicationRepository.save(application);
                }
            }
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }


    }

}
