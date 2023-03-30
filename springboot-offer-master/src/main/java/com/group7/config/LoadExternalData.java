package com.group7.config;

import com.group7.db.jpa.Program;
import com.group7.db.jpa.ProgramRepository;
import com.group7.db.jpa.School;
import com.group7.db.jpa.SchoolRepository;
import com.group7.db.jpa.utils.ESource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LoadExternalData {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    private static void saveSchoolData(School school, SchoolRepository schoolRepository){
        log.info("Imported: " + schoolRepository.save(school));
    }
    public static void loadExternalSchoolData(SchoolRepository schoolRepository, ProgramRepository programRepository){

        School school_yale = new School("Yale University", ESource.OPENCS);
        saveSchoolData(school_yale, schoolRepository);
        Program school_yale_program_2_year_mscs = new Program("Master of Science In Computer Science (2 Year)",  ESource.OPENCS, "MS", school_yale);
        programRepository.save(school_yale_program_2_year_mscs);
        Program school_yale_program_cs_phd = new Program("PhD In Computer Science",  ESource.OPENCS, "PhD", school_yale);
        programRepository.save(school_yale_program_cs_phd);
        Program school_yale_program_1_year_mscs = new Program("Master of Science In Computer Science (1 Year)",  ESource.OPENCS, "MS", school_yale);
        programRepository.save(school_yale_program_1_year_mscs);



        School school_brandeis = new School("Brandeis University", ESource.OPENCS);
        saveSchoolData(school_brandeis, schoolRepository);
        Program school_brandeis_program_12_course_mscs = new Program("Master of Science In Computer Science (12 Course)",  ESource.OPENCS, "MS", school_brandeis);
        programRepository.save(school_brandeis_program_12_course_mscs);
        Program school_brandeis_program_9_course_mscs = new Program("Master of Science In Computer Science (9 Course)",  ESource.OPENCS, "MS", school_brandeis);
        programRepository.save(school_brandeis_program_9_course_mscs);



        School school_ic = new School("Imperial College London", ESource.OPENCS);
        saveSchoolData(school_ic, schoolRepository);
        Program school_ic_program_ac = new Program("Advanced Computing",  ESource.OPENCS, "MS", school_ic);
        programRepository.save(school_ic_program_ac);



        School school_neu = new School("Northeastern University", ESource.OPENCS);
        saveSchoolData(school_neu, schoolRepository);
        Program school_neu_program_cs_general = new Program("Computer Science (General)",  ESource.OPENCS, "MS", school_neu);
        programRepository.save(school_neu_program_cs_general);
        Program school_neu_program_is = new Program("Information System",  ESource.OPENCS, "MS", school_neu);
        programRepository.save(school_neu_program_is);
        Program school_neu_program_ce_phd = new Program("PhD in Computer Engineering",  ESource.OPENCS, "PhD", school_neu);
        programRepository.save(school_neu_program_ce_phd);



        School school_usc = new School("University of Southern California", ESource.OPENCS);
        saveSchoolData(school_usc, schoolRepository);
        Program school_usc_program_cs37 = new Program("Computer Science Track-37",  ESource.OPENCS, "MS", school_usc);
        programRepository.save(school_usc_program_cs37);
        Program school_usc_program_ce = new Program("Computer Engineering",  ESource.OPENCS, "MS", school_usc);
        programRepository.save(school_usc_program_ce);
        Program school_usc_program_cs28 = new Program("Computer Science Track-28",  ESource.OPENCS, "MS", school_usc);
        programRepository.save(school_usc_program_cs28);



        School school_upenn = new School("University of Pennsylvania", ESource.OPENCS);
        saveSchoolData(school_upenn, schoolRepository);
        Program school_upenn_program_ee = new Program("Master of Science in Electrical Engineering",  ESource.OPENCS, "MS", school_upenn);
        programRepository.save(school_upenn_program_ee);
        Program school_upenn_program_mcis = new Program("Computer Information Systems",  ESource.OPENCS, "MS", school_upenn);
        programRepository.save(school_upenn_program_mcis);
        Program school_upenn_program_ese_phd = new Program("PhD in Electrical and Systems Engineering",  ESource.OPENCS, "PhD", school_upenn);
        programRepository.save(school_upenn_program_ese_phd);
        Program school_upenn_program_cggt = new Program("Computer Graphics and Game Technology",  ESource.OPENCS, "MS", school_upenn);
        programRepository.save(school_upenn_program_cggt);
        Program school_upenn_program_mcit = new Program("Master of Computer and Information Technology",  ESource.OPENCS, "MS", school_upenn);
        programRepository.save(school_upenn_program_mcit);



        School school_cornell_tech = new School("Cornell Tech - Cornell University", ESource.OPENCS);
        saveSchoolData(school_cornell_tech, schoolRepository);
        Program school_cornell_tech_program_cm = new Program("Connective Media",  ESource.OPENCS, "MS", school_cornell_tech);
        programRepository.save(school_cornell_tech_program_cm);
        Program school_cornell_tech_program_cs_meng = new Program("Master of Engineering In Computer Science",  ESource.OPENCS, "MS", school_cornell_tech);
        programRepository.save(school_cornell_tech_program_cs_meng);



        School school_vt = new School("Virginia Tech", ESource.OPENCS);
        saveSchoolData(school_vt, schoolRepository);
        Program school_vt_program_cs_meng = new Program("Master of Engineering In Computer Science",  ESource.OPENCS, "MS", school_vt);
        programRepository.save(school_vt_program_cs_meng);



        School school_brown = new School("Brown University", ESource.OPENCS);
        saveSchoolData(school_brown, schoolRepository);
        Program school_brown_program_cs_phd = new Program("PhD In Computer Science",  ESource.OPENCS, "PhD", school_brown);
        programRepository.save(school_brown_program_cs_phd);
        Program school_brown_program_scm_cs = new Program("Brown's Master of Science in Computer Science",  ESource.OPENCS, "MS", school_brown);
        programRepository.save(school_brown_program_scm_cs);



        School school_cornell = new School("Cornell University", ESource.OPENCS);
        saveSchoolData(school_cornell, schoolRepository);
        Program school_cornell_program_cs_phd = new Program("PhD In Computer Science",  ESource.OPENCS, "PhD", school_cornell);
        programRepository.save(school_cornell_program_cs_phd);
        Program school_cornell_program_ece_meng = new Program("Master of Engineering In Electrical and Computer Engineering",  ESource.OPENCS, "MS", school_cornell);
        programRepository.save(school_cornell_program_ece_meng);



        School school_dartmouth = new School("Dartmouth College", ESource.OPENCS);
        saveSchoolData(school_dartmouth, schoolRepository);
        Program school_dartmouth_program_cs_phd = new Program("PhD In Computer Science",  ESource.OPENCS, "PhD", school_dartmouth);
        programRepository.save(school_dartmouth_program_cs_phd);
        Program school_dartmouth_program_mscs = new Program("Master of Science in Computer Science",  ESource.OPENCS, "MS", school_dartmouth);
        programRepository.save(school_dartmouth_program_mscs);



        School school_notre_dame = new School("The University of Notre Dame du Lac", ESource.OPENCS);
        saveSchoolData(school_notre_dame, schoolRepository);
        Program school_notre_dame_program_cs_phd = new Program("PhD In Computer Science",  ESource.OPENCS, "PhD", school_notre_dame);
        programRepository.save(school_notre_dame_program_cs_phd);



        School school_nwu = new School("North-West University", ESource.OPENCS);
        saveSchoolData(school_nwu, schoolRepository);
        Program school_nwu_program_cs_phd = new Program("PhD In Computer Science",  ESource.OPENCS, "PhD", school_nwu);
        programRepository.save(school_nwu_program_cs_phd);
        Program school_nwu_program_msit = new Program("Master of Science in Information Technology",  ESource.OPENCS, "MS", school_nwu);
        programRepository.save(school_nwu_program_msit);
        Program school_nwu_program_mscs = new Program("Master of Science in Computer Science",  ESource.OPENCS, "MS", school_nwu);
        programRepository.save(school_nwu_program_mscs);



        School school_nyu_courant = new School("New York University's Courant Institute of Mathematical Sciences", ESource.OPENCS);
        saveSchoolData(school_nyu_courant, schoolRepository);
        Program school_nyu_courant_program_cs_phd = new Program("PhD In Computer Science",  ESource.OPENCS, "PhD", school_nyu_courant);
        programRepository.save(school_nyu_courant_program_cs_phd);
        Program school_nyu_courant_program_mscs = new Program("Master of Science in Computer Science",  ESource.OPENCS, "MS", school_nyu_courant);
        programRepository.save(school_nyu_courant_program_mscs);



        School school_rice = new School("Rice University", ESource.OPENCS);
        saveSchoolData(school_rice, schoolRepository);
        Program school_rice_program_cs_phd = new Program("PhD In Computer Science",  ESource.OPENCS, "PhD", school_rice);
        programRepository.save(school_rice_program_cs_phd);
        Program school_rice_program_mcs = new Program("Master of Computer Science",  ESource.OPENCS, "MS", school_rice);
        programRepository.save(school_rice_program_mcs);



        School school_rochester = new School("The University of Rochester", ESource.OPENCS);
        saveSchoolData(school_rochester, schoolRepository);
        Program school_rochester_program_cs_phd = new Program("PhD In Computer Science",  ESource.OPENCS, "PhD", school_rochester);
        programRepository.save(school_rochester_program_cs_phd);



        School school_stanford = new School("Stanford University", ESource.OPENCS);
        saveSchoolData(school_stanford, schoolRepository);
        Program school_stanford_program_cs_phd = new Program("PhD In Computer Science",  ESource.OPENCS, "PhD", school_stanford);
        programRepository.save(school_stanford_program_cs_phd);
        Program school_stanford_program_ee = new Program("Master of Science in Electrical Engineering",  ESource.OPENCS, "MS", school_stanford);
        programRepository.save(school_stanford_program_ee);
        Program school_stanford_program_mscs = new Program("Master of Science in Computer Science",  ESource.OPENCS, "MS", school_stanford);
        programRepository.save(school_stanford_program_mscs);



        School school_tamu = new School("Texas A&M University", ESource.OPENCS);
        saveSchoolData(school_tamu, schoolRepository);
        Program school_tamu_program_meng_ce = new Program("Master of Engineering In Computer Engineering",  ESource.OPENCS, "MS", school_tamu);
        programRepository.save(school_tamu_program_meng_ce);
        Program school_tamu_program_cs_phd = new Program("PhD In Computer Science",  ESource.OPENCS, "PhD", school_tamu);
        programRepository.save(school_tamu_program_cs_phd);
        Program school_tamu_program_mcs = new Program("Master of Computer Science",  ESource.OPENCS, "MS", school_tamu);
        programRepository.save(school_tamu_program_mcs);
        Program school_tamu_program_mscs = new Program("Master of Science in Computer Science",  ESource.OPENCS, "MS", school_tamu);
        programRepository.save(school_tamu_program_mscs);



        School school_uci = new School("University of California Irvine", ESource.OPENCS);
        saveSchoolData(school_uci, schoolRepository);
        Program school_uci_program_mswe = new Program("Master of Software Engineering",  ESource.OPENCS, "MS", school_uci);
        programRepository.save(school_uci_program_mswe);
        Program school_uci_program_cs_phd = new Program("PhD In Computer Science",  ESource.OPENCS, "PhD", school_uci);
        programRepository.save(school_uci_program_cs_phd);
        Program school_uci_program_mscs = new Program("Master of Science in Computer Science",  ESource.OPENCS, "MS", school_uci);
        programRepository.save(school_uci_program_mscs);
        Program school_uci_program_mds = new Program("Master of Data Science",  ESource.OPENCS, "MS", school_uci);
        programRepository.save(school_uci_program_mds);
        Program school_uci_program_mcs = new Program("Master of Computer Science",  ESource.OPENCS, "MS", school_uci);
        programRepository.save(school_uci_program_mcs);
        Program school_uci_program_netsys = new Program("Networked Systems",  ESource.OPENCS, "MS", school_uci);
        programRepository.save(school_uci_program_netsys);



        School school_ucsb = new School("University of California, Santa Barbara", ESource.OPENCS);
        saveSchoolData(school_ucsb, schoolRepository);
        Program school_ucsb_program_cs_phd = new Program("PhD In Computer Science",  ESource.OPENCS, "PhD", school_ucsb);
        programRepository.save(school_ucsb_program_cs_phd);
        Program school_ucsb_program_mscs = new Program("Master of Science in Computer Science",  ESource.OPENCS, "MS", school_ucsb);
        programRepository.save(school_ucsb_program_mscs);



        School school_ucsd = new School("University of California San Diego", ESource.OPENCS);
        saveSchoolData(school_ucsd, schoolRepository);
        Program school_ucsd_program_ds75 = new Program("Data Science Track-75",  ESource.OPENCS, "MS", school_ucsd);
        programRepository.save(school_ucsd_program_ds75);
        Program school_ucsd_program_cs_phd = new Program("PhD In Computer Science",  ESource.OPENCS, "PhD", school_ucsd);
        programRepository.save(school_ucsd_program_cs_phd);
        Program school_ucsd_program_ec79 = new Program("Electrical and Computer Engineering Track-79",  ESource.OPENCS, "MS", school_ucsd);
        programRepository.save(school_ucsd_program_ec79);
        Program school_ucsd_program_cs75 = new Program("Computer Science Track-75",  ESource.OPENCS, "MS", school_ucsd);
        programRepository.save(school_ucsd_program_cs75);



        School school_unc = new School("The University of North Carolina at Chapel Hill", ESource.OPENCS);
        saveSchoolData(school_unc, schoolRepository);
        Program school_unc_program_cs_phd = new Program("PhD In Computer Science",  ESource.OPENCS, "PhD", school_unc);
        programRepository.save(school_unc_program_cs_phd);
        Program school_unc_program_msis = new Program("Master of Science in Information Systems",  ESource.OPENCS, "MS", school_unc);
        programRepository.save(school_unc_program_msis);



        School school_uva = new School("University of Virginia (UVA)", ESource.OPENCS);
        saveSchoolData(school_uva, schoolRepository);
        Program school_uva_program_cs_phd = new Program("PhD In Computer Science",  ESource.OPENCS, "PhD", school_uva);
        programRepository.save(school_uva_program_cs_phd);
        Program school_uva_program_mcs = new Program("Master of Computer Science",  ESource.OPENCS, "MS", school_uva);
        programRepository.save(school_uva_program_mcs);



        School school_uw = new School("The University of Washington", ESource.OPENCS);
        saveSchoolData(school_uw, schoolRepository);
        Program school_uw_program_cs_phd = new Program("PhD In Computer Science",  ESource.OPENCS, "PhD", school_uw);
        programRepository.save(school_uw_program_cs_phd);
        Program school_uw_program_msim = new Program("Master of Science in Information Management",  ESource.OPENCS, "MS", school_uw);
        programRepository.save(school_uw_program_msim);
        Program school_uw_program_ee_pmp = new Program("Electrical Engineering (Project Management Professional)",  ESource.OPENCS, "MS", school_uw);
        programRepository.save(school_uw_program_ee_pmp);



        School school_waterloo = new School("The University of Waterloo", ESource.OPENCS);
        saveSchoolData(school_waterloo, schoolRepository);
        Program school_waterloo_program_ece_meng = new Program("Master of Engineering In Electrical and Computer Engineering",  ESource.OPENCS, "MS", school_waterloo);
        programRepository.save(school_waterloo_program_ece_meng);
        Program school_waterloo_program_mdsai = new Program("Master of Data Science and AI",  ESource.OPENCS, "MS", school_waterloo);
        programRepository.save(school_waterloo_program_mdsai);
        Program school_waterloo_program_cs_phd = new Program("PhD In Computer Science",  ESource.OPENCS, "PhD", school_waterloo);
        programRepository.save(school_waterloo_program_cs_phd);
        Program school_waterloo_program_mmath = new Program("Master of Mathematics",  ESource.OPENCS, "MS", school_waterloo);
        programRepository.save(school_waterloo_program_mmath);
        Program school_waterloo_program_ece_meng_co_op = new Program("Master of Engineering In Electrical and Computer Engineering (Co-op)",  ESource.OPENCS, "MS", school_waterloo);
        programRepository.save(school_waterloo_program_ece_meng_co_op);
        Program school_waterloo_program_syde = new Program("Systems Design Engineering",  ESource.OPENCS, "MS", school_waterloo);
        programRepository.save(school_waterloo_program_syde);



        School school_wisc = new School("University of Wisconsin–Madison", ESource.OPENCS);
        saveSchoolData(school_wisc, schoolRepository);
        Program school_wisc_program_cs_phd = new Program("PhD In Computer Science",  ESource.OPENCS, "PhD", school_wisc);
        programRepository.save(school_wisc_program_cs_phd);
        Program school_wisc_program_cs_pmp = new Program("Computer Science (Project Management Professional)",  ESource.OPENCS, "MS", school_wisc);
        programRepository.save(school_wisc_program_cs_pmp);
        Program school_wisc_program_mscs = new Program("Master of Science in Computer Science",  ESource.OPENCS, "MS", school_wisc);
        programRepository.save(school_wisc_program_mscs);



        School school_wustl = new School("Washington University in St. Louis", ESource.OPENCS);
        saveSchoolData(school_wustl, schoolRepository);
        Program school_wustl_program_cs_phd = new Program("PhD In Computer Science",  ESource.OPENCS, "PhD", school_wustl);
        programRepository.save(school_wustl_program_cs_phd);
        Program school_wustl_program_mscs = new Program("Master of Science in Computer Science",  ESource.OPENCS, "MS", school_wustl);
        programRepository.save(school_wustl_program_mscs);



        School school_gatech = new School("The Georgia Institute of Technology", ESource.OPENCS);
        saveSchoolData(school_gatech, schoolRepository);
        Program school_gatech_program_ece = new Program("Electrical and Computer Engineering",  ESource.OPENCS, "MS", school_gatech);
        programRepository.save(school_gatech_program_ece);
        Program school_gatech_program_cse = new Program("Computer Science Engineering",  ESource.OPENCS, "MS", school_gatech);
        programRepository.save(school_gatech_program_cse);
        Program school_gatech_program_mscs = new Program("Master of Science in Computer Science",  ESource.OPENCS, "MS", school_gatech);
        programRepository.save(school_gatech_program_mscs);



        School school_harvard = new School("Harvard College", ESource.OPENCS);
        saveSchoolData(school_harvard, schoolRepository);
        Program school_harvard_program_cse = new Program("Computer Science Engineering",  ESource.OPENCS, "MS", school_harvard);
        programRepository.save(school_harvard_program_cse);
        Program school_harvard_program_ds = new Program("Data Science",  ESource.OPENCS, "MS", school_harvard);
        programRepository.save(school_harvard_program_ds);



        School school_mit = new School("Massachusetts Institute of Technology", ESource.OPENCS);
        saveSchoolData(school_mit, schoolRepository);
        Program school_mit_program_cse = new Program("Computer Science Engineering",  ESource.OPENCS, "MS", school_mit);
        programRepository.save(school_mit_program_cse);



        School school_nyu_tandon = new School("New York University Tandon School of Engineering", ESource.OPENCS);
        saveSchoolData(school_nyu_tandon, schoolRepository);
        Program school_nyu_tandon_program_cybersecurity = new Program("Cybersecurity",  ESource.OPENCS, "MS", school_nyu_tandon);
        programRepository.save(school_nyu_tandon_program_cybersecurity);
        Program school_nyu_tandon_program_msce = new Program("Master of Science in Computer Engineering",  ESource.OPENCS, "MS", school_nyu_tandon);
        programRepository.save(school_nyu_tandon_program_msce);
        Program school_nyu_tandon_program_mscs = new Program("Master of Science in Computer Science",  ESource.OPENCS, "MS", school_nyu_tandon);
        programRepository.save(school_nyu_tandon_program_mscs);



        School school_sfu = new School("Simon Fraser University", ESource.OPENCS);
        saveSchoolData(school_sfu, schoolRepository);
        Program school_sfu_program_cybersecurity = new Program("Cybersecurity",  ESource.OPENCS, "MS", school_sfu);
        programRepository.save(school_sfu_program_cybersecurity);
        Program school_sfu_program_mpcs_big_data = new Program("Masters Program in Computer Science (Big Data)",  ESource.OPENCS, "MS", school_sfu);
        programRepository.save(school_sfu_program_mpcs_big_data);



        School school_umich = new School("The University of Michigan", ESource.OPENCS);
        saveSchoolData(school_umich, schoolRepository);
        Program school_umich_program_mscse = new Program("Master of Science in Computer Science and Engineering",  ESource.OPENCS, "MS", school_umich);
        programRepository.save(school_umich_program_mscse);
        Program school_umich_program_msece = new Program("The Master of Science in Electrical and Computer Engineering",  ESource.OPENCS, "MS", school_umich);
        programRepository.save(school_umich_program_msece);
        Program school_umich_program_ds = new Program("Data Science",  ESource.OPENCS, "MS", school_umich);
        programRepository.save(school_umich_program_ds);
        Program school_umich_program_msi = new Program("Master of Science in Information",  ESource.OPENCS, "MS", school_umich);
        programRepository.save(school_umich_program_msi);



        School school_nus = new School("National University of Singapore", ESource.OPENCS);
        saveSchoolData(school_nus, schoolRepository);
        Program school_nus_program_dsml = new Program("Data Science and Machine Learning",  ESource.OPENCS, "MS", school_nus);
        programRepository.save(school_nus_program_dsml);
        Program school_nus_program_mcs = new Program("Master of Computer Science",  ESource.OPENCS, "MS", school_nus);
        programRepository.save(school_nus_program_mcs);



        School school_ubc = new School("The University of British Columbia", ESource.OPENCS);
        saveSchoolData(school_ubc, schoolRepository);
        Program school_ubc_program_ece_meng = new Program("Master of Engineering In Electrical and Computer Engineering",  ESource.OPENCS, "MS", school_ubc);
        programRepository.save(school_ubc_program_ece_meng);



        School school_uiuc = new School("University of Illinois Urbana-Champaign", ESource.OPENCS);
        saveSchoolData(school_uiuc, schoolRepository);
        Program school_uiuc_program_msim = new Program("Master of Science in Information Management",  ESource.OPENCS, "MS", school_uiuc);
        programRepository.save(school_uiuc_program_msim);
        Program school_uiuc_program_ece_meng = new Program("Master of Engineering In Electrical and Computer Engineering",  ESource.OPENCS, "MS", school_uiuc);
        programRepository.save(school_uiuc_program_ece_meng);
        Program school_uiuc_program_mcs = new Program("Master of Computer Science",  ESource.OPENCS, "MS", school_uiuc);
        programRepository.save(school_uiuc_program_mcs);
        Program school_uiuc_program_mscs = new Program("Master of Science in Computer Science",  ESource.OPENCS, "MS", school_uiuc);
        programRepository.save(school_uiuc_program_mscs);



        School school_uottawa = new School("The University of Ottawa", ESource.OPENCS);
        saveSchoolData(school_uottawa, schoolRepository);
        Program school_uottawa_program_ece_meng = new Program("Master of Engineering In Electrical and Computer Engineering",  ESource.OPENCS, "MS", school_uottawa);
        programRepository.save(school_uottawa_program_ece_meng);
        Program school_uottawa_program_mcs = new Program("Master of Computer Science",  ESource.OPENCS, "MS", school_uottawa);
        programRepository.save(school_uottawa_program_mcs);



        School school_ut_austin = new School("University of Texas at Austin", ESource.OPENCS);
        saveSchoolData(school_ut_austin, schoolRepository);
        Program school_ut_austin_program_ece_phd = new Program("PhD In Electrical and Computer Engineering",  ESource.OPENCS, "PhD", school_ut_austin);
        programRepository.save(school_ut_austin_program_ece_phd);
        Program school_ut_austin_program_msis = new Program("Master of Science in Information Systems",  ESource.OPENCS, "MS", school_ut_austin);
        programRepository.save(school_ut_austin_program_msis);
        Program school_ut_austin_program_ece = new Program("Electrical and Computer Engineering",  ESource.OPENCS, "MS", school_ut_austin);
        programRepository.save(school_ut_austin_program_ece);
        Program school_ut_austin_program_mscs = new Program("Master of Science in Computer Science",  ESource.OPENCS, "MS", school_ut_austin);
        programRepository.save(school_ut_austin_program_mscs);



        School school_cmu = new School("Carnegie Mellon University", ESource.OPENCS);
        saveSchoolData(school_cmu, schoolRepository);
        Program school_cmu_program_miis = new Program("Master of Science In Intelligent Information Systems",  ESource.OPENCS, "MS", school_cmu);
        programRepository.save(school_cmu_program_miis);
        Program school_cmu_program_msin = new Program("Master of Science in Information Networking",  ESource.OPENCS, "MS", school_cmu);
        programRepository.save(school_cmu_program_msin);
        Program school_cmu_program_msmite = new Program("Master of Science in Mobile and IoT Engineering",  ESource.OPENCS, "MS", school_cmu);
        programRepository.save(school_cmu_program_msmite);
        Program school_cmu_program_ece = new Program("Electrical and Computer Engineering",  ESource.OPENCS, "MS", school_cmu);
        programRepository.save(school_cmu_program_ece);
        Program school_cmu_program_msr = new Program("Master of Science in Robotics",  ESource.OPENCS, "MS", school_cmu);
        programRepository.save(school_cmu_program_msr);
        Program school_cmu_program_mse_ss = new Program("Master of Software Engineering in Scalable Systems",  ESource.OPENCS, "MS", school_cmu);
        programRepository.save(school_cmu_program_mse_ss);
        Program school_cmu_program_msit_is = new Program("Master of Science in Information Technology-Information Security",  ESource.OPENCS, "MS", school_cmu);
        programRepository.save(school_cmu_program_msit_is);
        Program school_cmu_program_msml = new Program("Master of Science in Machine Learning",  ESource.OPENCS, "MS", school_cmu);
        programRepository.save(school_cmu_program_msml);
        Program school_cmu_program_msai_ee = new Program("Master of Science in Artificial Intelligence - Electrical Engineering",  ESource.OPENCS, "MS", school_cmu);
        programRepository.save(school_cmu_program_msai_ee);
        Program school_cmu_program_mscs = new Program("Master of Science in Computer Science",  ESource.OPENCS, "MS", school_cmu);
        programRepository.save(school_cmu_program_mscs);
        Program school_cmu_program_mscv = new Program("Master of Science in Computer Vision",  ESource.OPENCS, "MS", school_cmu);
        programRepository.save(school_cmu_program_mscv);
        Program school_cmu_program_sesv = new Program("Master of Science in Software Engineering - Silicon Valley",  ESource.OPENCS, "MS", school_cmu);
        programRepository.save(school_cmu_program_sesv);
        Program school_cmu_program_mcds = new Program("Master of Computational Data Science",  ESource.OPENCS, "MS", school_cmu);
        programRepository.save(school_cmu_program_mcds);
        Program school_cmu_program_msaii = new Program("Master of Science in Artificial Intelligence and Innovation",  ESource.OPENCS, "MS", school_cmu);
        programRepository.save(school_cmu_program_msaii);
        Program school_cmu_program_met = new Program("Multimedia & Entertainment Technology",  ESource.OPENCS, "MS", school_cmu);
        programRepository.save(school_cmu_program_met);
        Program school_cmu_program_msis = new Program("Master of Science in Information Systems",  ESource.OPENCS, "MS", school_cmu);
        programRepository.save(school_cmu_program_msis);
        Program school_cmu_program_mlt = new Program("Master of Law and Taxation",  ESource.OPENCS, "MS", school_cmu);
        programRepository.save(school_cmu_program_mlt);
        Program school_cmu_program_msit_pe = new Program("Master of Science in Information Technology in Privacy Engineering",  ESource.OPENCS, "MS", school_cmu);
        programRepository.save(school_cmu_program_msit_pe);



        School school_duke = new School("Duke University", ESource.OPENCS);
        saveSchoolData(school_duke, schoolRepository);
        Program school_duke_program_ece = new Program("Electrical and Computer Engineering",  ESource.OPENCS, "MS", school_duke);
        programRepository.save(school_duke_program_ece);
        Program school_duke_program_mscs = new Program("Master of Science in Computer Science",  ESource.OPENCS, "MS", school_duke);
        programRepository.save(school_duke_program_mscs);



        School school_duke_kunshan = new School("Duke Kunshan University (DKU)", ESource.OPENCS);
        saveSchoolData(school_duke_kunshan, schoolRepository);
        Program school_duke_kunshan_program_ece = new Program("Electrical and Computer Engineering",  ESource.OPENCS, "MS", school_duke_kunshan);
        programRepository.save(school_duke_kunshan_program_ece);



        School school_gatech_shenzhen = new School("Georgia Institute of Technology (Georgia Tech) Shenzhen", ESource.OPENCS);
        saveSchoolData(school_gatech_shenzhen, schoolRepository);
        Program school_gatech_shenzhen_program_ece = new Program("Electrical and Computer Engineering",  ESource.OPENCS, "MS", school_gatech_shenzhen);
        programRepository.save(school_gatech_shenzhen_program_ece);



        School school_purdue = new School("Purdue University", ESource.OPENCS);
        saveSchoolData(school_purdue, schoolRepository);
        Program school_purdue_program_ece = new Program("Electrical and Computer Engineering",  ESource.OPENCS, "MS", school_purdue);
        programRepository.save(school_purdue_program_ece);



        School school_epfl = new School("École Polytechnique Fédérale de Lausanne (EPFL)", ESource.OPENCS);
        saveSchoolData(school_epfl, schoolRepository);
        Program school_epfl_program_edic_phd = new Program("PhD In Educational Innovation and Communication",  ESource.OPENCS, "PhD", school_epfl);
        programRepository.save(school_epfl_program_edic_phd);
        Program school_epfl_program_mscs = new Program("Master of Science in Computer Science",  ESource.OPENCS, "MS", school_epfl);
        programRepository.save(school_epfl_program_mscs);



        School school_caltech = new School("California Institute of Technology", ESource.OPENCS);
        saveSchoolData(school_caltech, schoolRepository);
        Program school_caltech_program_ee = new Program("Master of Science in Electrical Engineering",  ESource.OPENCS, "MS", school_caltech);
        programRepository.save(school_caltech_program_ee);



        School school_columbia = new School("Columbia University", ESource.OPENCS);
        saveSchoolData(school_columbia, schoolRepository);
        Program school_columbia_program_ee = new Program("Master of Science in Electrical Engineering",  ESource.OPENCS, "MS", school_columbia);
        programRepository.save(school_columbia_program_ee);
        Program school_columbia_program_msce = new Program("Master of Science in Computer Engineering",  ESource.OPENCS, "MS", school_columbia);
        programRepository.save(school_columbia_program_msce);
        Program school_columbia_program_mscs = new Program("Master of Science in Computer Science",  ESource.OPENCS, "MS", school_columbia);
        programRepository.save(school_columbia_program_mscs);



        School school_berkeley = new School("University of California, Berkeley", ESource.OPENCS);
        saveSchoolData(school_berkeley, schoolRepository);
        Program school_berkeley_program_eecs_meng = new Program("Master of Engineering in Electrical Engineering and Computer Science",  ESource.OPENCS, "MS", school_berkeley);
        programRepository.save(school_berkeley_program_eecs_meng);



        School school_ucla = new School("University of California Los Angeles", ESource.OPENCS);
        saveSchoolData(school_ucla, schoolRepository);
        Program school_ucla_program_math_phd = new Program("PhD in Mathematics",  ESource.OPENCS, "PhD", school_ucla);
        programRepository.save(school_ucla_program_math_phd);
        Program school_ucla_program_meng = new Program("Master of Engineering",  ESource.OPENCS, "MS", school_ucla);
        programRepository.save(school_ucla_program_meng);
        Program school_ucla_program_mscs = new Program("Master of Science in Computer Science",  ESource.OPENCS, "MS", school_ucla);
        programRepository.save(school_ucla_program_mscs);



        School school_ncsu = new School("North Carolina State University", ESource.OPENCS);
        saveSchoolData(school_ncsu, schoolRepository);
        Program school_ncsu_program_mcs = new Program("Master of Computer Science",  ESource.OPENCS, "MS", school_ncsu);
        programRepository.save(school_ncsu_program_mcs);



        School school_mcmaster = new School("McMaster University", ESource.OPENCS);
        saveSchoolData(school_mcmaster, schoolRepository);
        Program school_mcmaster_program_msc_cs = new Program("MSc Computer Science",  ESource.OPENCS, "MS", school_mcmaster);
        programRepository.save(school_mcmaster_program_msc_cs);
        Program school_mcmaster_program_meng_s_t = new Program("Master of Engineering In Science And Technology",  ESource.OPENCS, "MS", school_mcmaster);
        programRepository.save(school_mcmaster_program_meng_s_t);



        School school_ualberta = new School("University of Alberta", ESource.OPENCS);
        saveSchoolData(school_ualberta, schoolRepository);
        Program school_ualberta_program_mint = new Program("Mathematik, Informatik, Naturwissenschaften und Technik",  ESource.OPENCS, "MS", school_ualberta);
        programRepository.save(school_ualberta_program_mint);



        School school_uchicago = new School("The University of Chicago", ESource.OPENCS);
        saveSchoolData(school_uchicago, schoolRepository);
        Program school_uchicago_program_mpcs = new Program("Masters Program in Computer Science",  ESource.OPENCS, "MS", school_uchicago);
        programRepository.save(school_uchicago_program_mpcs);
        Program school_uchicago_program_pre_doctoral_mscs = new Program("Pre-Doctoral Master of Science in Computer Science",  ESource.OPENCS, "MS", school_uchicago);
        programRepository.save(school_uchicago_program_pre_doctoral_mscs);



        School school_bu = new School("Boston University", ESource.OPENCS);
        saveSchoolData(school_bu, schoolRepository);
        Program school_bu_program_msai = new Program("Master of Science in Artificial Intelligence",  ESource.OPENCS, "MS", school_bu);
        programRepository.save(school_bu_program_msai);



        School school_mcgill = new School("McGill University", ESource.OPENCS);
        saveSchoolData(school_mcgill, schoolRepository);
        Program school_mcgill_program_msc_cs = new Program("MSc Computer Science",  ESource.OPENCS, "MS", school_mcgill);
        programRepository.save(school_mcgill_program_msc_cs);



        School school_hkust = new School("Hong Kong University of Science and Technology", ESource.OPENCS);
        saveSchoolData(school_hkust, schoolRepository);
        Program school_hkust_program_msc_it = new Program("MSc in Information Technology",  ESource.OPENCS, "MS", school_hkust);
        programRepository.save(school_hkust_program_msc_it);



        School school_ucl = new School("University College London", ESource.OPENCS);
        saveSchoolData(school_ucl, schoolRepository);
        Program school_ucl_program_msc_sse = new Program("Master of Science in Software and Systems Engineering",  ESource.OPENCS, "MS", school_ucl);
        programRepository.save(school_ucl_program_msc_sse);



        School school_uoft = new School("University of Toronto", ESource.OPENCS);
        saveSchoolData(school_uoft, schoolRepository);
        Program school_uoft_program_mscac = new Program("Master of Science in Applied Computing (MScAC)",  ESource.OPENCS, "MS", school_uoft);
        programRepository.save(school_uoft_program_mscac);



        School school_gwu = new School("George Washington University", ESource.OPENCS);
        saveSchoolData(school_gwu, schoolRepository);
        Program school_gwu_program_mscs = new Program("Master of Science in Computer Science",  ESource.OPENCS, "MS", school_gwu);
        programRepository.save(school_gwu_program_mscs);



        School school_iowa_state_university = new School("Iowa State University of Science and Technology", ESource.OPENCS);
        saveSchoolData(school_iowa_state_university, schoolRepository);
        Program school_iowa_state_university_program_mscs = new Program("Master of Science in Computer Science",  ESource.OPENCS, "MS", school_iowa_state_university);
        programRepository.save(school_iowa_state_university_program_mscs);



        School school_pitt = new School("University of Pittsburgh", ESource.OPENCS);
        saveSchoolData(school_pitt, schoolRepository);
        Program school_pitt_program_mscs = new Program("Master of Science in Computer Science",  ESource.OPENCS, "MS", school_pitt);
        programRepository.save(school_pitt_program_mscs);



        School school_scu = new School("Santa Clara University", ESource.OPENCS);
        saveSchoolData(school_scu, schoolRepository);
        Program school_scu_program_mscs = new Program("Master of Science in Computer Science",  ESource.OPENCS, "MS", school_scu);
        programRepository.save(school_scu_program_mscs);



        School school_tufts = new School("Tufts University", ESource.OPENCS);
        saveSchoolData(school_tufts, schoolRepository);
        Program school_tufts_program_mscs = new Program("Master of Science in Computer Science",  ESource.OPENCS, "MS", school_tufts);
        programRepository.save(school_tufts_program_mscs);



        School school_ucd = new School("University of California, Davis", ESource.OPENCS);
        saveSchoolData(school_ucd, schoolRepository);
        Program school_ucd_program_mscs = new Program("Master of Science in Computer Science",  ESource.OPENCS, "MS", school_ucd);
        programRepository.save(school_ucd_program_mscs);



        School school_ufl = new School("University of Florida", ESource.OPENCS);
        saveSchoolData(school_ufl, schoolRepository);
        Program school_ufl_program_mscs = new Program("Master of Science in Computer Science",  ESource.OPENCS, "MS", school_ufl);
        programRepository.save(school_ufl_program_mscs);



        School school_umass = new School("University of Massachusetts", ESource.OPENCS);
        saveSchoolData(school_umass, schoolRepository);
        Program school_umass_program_mscs = new Program("Master of Science in Computer Science",  ESource.OPENCS, "MS", school_umass);
        programRepository.save(school_umass_program_mscs);



        School school_psu = new School("Pennsylvania State University", ESource.OPENCS);
        saveSchoolData(school_psu, schoolRepository);
        Program school_psu_program_mscse = new Program("Master of Science in Computer Science and Engineering",  ESource.OPENCS, "MS", school_psu);
        programRepository.save(school_psu_program_mscse);



        School school_jhu = new School("Johns Hopkins University", ESource.OPENCS);
        saveSchoolData(school_jhu, schoolRepository);
        Program school_jhu_program_mssi = new Program("Master of Science in Security Informatics",  ESource.OPENCS, "MS", school_jhu);
        programRepository.save(school_jhu_program_mssi);
        Program school_jhu_program_msecs = new Program("The Master of Science in Engineering and Computer Science",  ESource.OPENCS, "MS", school_jhu);
        programRepository.save(school_jhu_program_msecs);



        School school_princeton = new School("Princeton University", ESource.OPENCS);
        saveSchoolData(school_princeton, schoolRepository);
        Program school_princeton_program_msecs = new Program("The Master of Science in Engineering and Computer Science",  ESource.OPENCS, "MS", school_princeton);
        programRepository.save(school_princeton_program_msecs);



    }
}
