import xlrd
import pandas as pd
from numpy import NaN

schoolName = set()

programsData = {

}
programsData_reverse = {

}

schoolsData = {

}

schoolsData_reverse = {

}
schoolPrograms = {

}

schoolLatLongMapping = {
    'school_duke_kunshan': [],
    'school_gatech_shenzhen': [],
    'school_purdue': [],
    'school_ut_austin': [],
    'school_epfl': [],
    'school_caltech': [],
    'school_columbia': [],
    'school_upenn': [],
    'school_berkeley': [],
    'school_ucla': [],
    'school_ncsu': [],
    'school_uva': [],
    'school_mcmaster': [],
    'school_ualberta': [],
    'school_uchicago': [],
    'school_bu': [],
    'school_mcgill': [],
    'school_hkust': [],
    'school_ucl': [],
    'school_uoft': [],
    'school_gwu': [],
    'school_iowa_state_university': [],
    'school_pitt': [],
    'school_scu': [],
    'school_tufts': [],
    'school_ucd': [],
    'school_ufl': [],
    'school_umass': [],
    'school_psu': [],
    'school_jhu': [],
    'school_princeton': [],
    'school_brandeis': [],
    'school_neu': [],
    'school_cornell_tech': [],
    'school_brown': [],
    'school_notre_dame': [],
    'school_nyu_courant': [],
    'school_rice': [29.717000, -95.402504],
    'school_stanford': [37.427168, -122.170599],
    'school_uci': [33.641916, -117.840720],
    'school_ucsd': [32.771475, -117.190579],
    'school_unc': [35.904760, -79.046827],
    'school_uw': [38.648471, -90.310957],
    'school_wisc': [43.076490, -89.412541],
    'school_gatech': [33.775376, -84.396437],
    'school_mit': [42.359973, -71.093413],
    'school_nyu_tandon': [40.694737, -73.986201],
    'school_umich': [42.277861, -83.738235],
    'school_ubc': [49.260269, -123.245600],
    'school_uottawa': [45.423076, -75.683380],
    'school_cmu': [40.443410, -79.942954],
    'school_duke': [36.001254, -78.938310]
}

schoolNameMapping = {
    'school_duke_kunshan': "Duke Kunshan University (DKU)",
    'school_gatech_shenzhen': "Georgia Institute of Technology (Georgia Tech) Shenzhen",
    'school_purdue': "Purdue University",
    'school_ut_austin': "University of Texas at Austin",
    'school_epfl': "École Polytechnique Fédérale de Lausanne (EPFL)",
    'school_caltech': "California Institute of Technology",
    'school_columbia': "Columbia University",
    'school_upenn': "University of Pennsylvania",
    'school_berkeley': "University of California, Berkeley",
    'school_ucla': "University of California Los Angeles",
    'school_ncsu': "North Carolina State University",
    'school_uva': "University of Virginia (UVA)",
    'school_mcmaster': "McMaster University",
    'school_ualberta': "University of Alberta",
    'school_uchicago': "The University of Chicago",
    'school_bu': "Boston University",
    'school_mcgill': "McGill University",
    'school_hkust': "Hong Kong University of Science and Technology",
    'school_ucl': "University College London",
    'school_uoft': "University of Toronto",
    'school_gwu': "George Washington University",
    'school_iowa_state_university': "Iowa State University of Science and Technology",
    'school_pitt': "University of Pittsburgh",
    'school_scu': "Santa Clara University",
    'school_tufts': "Tufts University",
    'school_ucd': "University of California, Davis",
    'school_ufl': "University of Florida",
    'school_umass': "University of Massachusetts",
    'school_psu': "Pennsylvania State University",
    'school_jhu': "Johns Hopkins University",
    'school_princeton': "Princeton University", 'school_yale': 'Yale University',
    'school_brandeis': 'Brandeis University', 'school_ic': 'Imperial College London',
    'school_neu': 'Northeastern University', 'school_usc': 'University of Southern California',
    'school_cornell_tech': 'Cornell Tech - Cornell University', 'school_vt': 'Virginia Tech',
    'school_brown': 'Brown University', 'school_cornell': 'Cornell University', 'school_dartmouth': 'Dartmouth College',
    'school_notre_dame': 'The University of Notre Dame du Lac', 'school_nwu': 'North-West University',
    'school_nyu_courant': 'New York University\'s Courant Institute of Mathematical Sciences',
    'school_rice': 'Rice University', 'school_rochester': 'The University of Rochester',
    'school_stanford': 'Stanford University', 'school_tamu': 'Texas A&M University',
    'school_uci': 'University of California Irvine', 'school_ucsb': 'University of California, Santa Barbara',
    'school_ucsd': 'University of California San Diego',
    'school_unc': 'The University of North Carolina at Chapel Hill',
    'school_uw': 'The University of Washington', 'school_waterloo': 'The University of Waterloo',
    'school_wisc': 'University of Wisconsin–Madison', 'school_wustl': 'Washington University in St. Louis',
    'school_gatech': 'The Georgia Institute of Technology', 'school_harvard': 'Harvard College',
    'school_mit': 'Massachusetts Institute of Technology',
    'school_nyu_tandon': 'New York University Tandon School of Engineering', 'school_sfu': 'Simon Fraser University',
    'school_umich': 'The University of Michigan', 'school_nus': 'National University of Singapore',
    'school_ubc': 'The University of British Columbia', 'school_uiuc': 'University of Illinois Urbana-Champaign',
    'school_uottawa': 'The University of Ottawa',
    'school_cmu': 'Carnegie Mellon University', 'school_duke': 'Duke University'}

programNameMapping =  {
    'program_1_year_mscs': 'Master of Science In Computer Science (1 Year)',
    'program_2_year_mscs': 'Master of Science In Computer Science (2 Year)',
    'program_9_course_mscs': 'Master of Science In Computer Science (9 Course)',
    'program_12_course_mscs': 'Master of Science In Computer Science (12 Course)',
    'program_ac': 'Advanced Computing',
    'program_ce_phd': 'PhD in Computer Engineering',
    'program_ce': 'Computer Engineering',
    'program_cggt': 'Computer Graphics and Game Technology',
    'program_cm': 'Connective Media',
    'program_cs_general': 'Computer Science (General)',
    'program_cs_meng': 'Master of Engineering In Computer Science',
    'program_cs_phd': 'PhD In Computer Science',
    'program_cs_pmp': 'Computer Science (Project Management Professional)',
    'program_cs28': 'Computer Science Track-28',
    'program_cs37': 'Computer Science Track-37',
    'program_cs75': 'Computer Science Track-75',
    'program_cse': 'Computer Science Engineering',
    'program_cybersecurity': 'Cybersecurity',
    'program_ds': 'Data Science',
    'program_ds75': 'Data Science Track-75',
    'program_dsml': 'Data Science and Machine Learning',
    'program_ec79': 'Electrical and Computer Engineering Track-79',
    'program_ece_meng_(co_op)': 'Master of Engineering In Electrical and Computer Engineering (Co-op)',
    'program_ece_meng': 'Master of Engineering In Electrical and Computer Engineering',
    'program_ece_phd': 'PhD In Electrical and Computer Engineering',
    'program_ece': 'Electrical and Computer Engineering',
    'program_edic_phd': 'PhD In Educational Innovation and Communication',
    'program_ee_pmp': 'Electrical Engineering (Project Management Professional)',
    'program_mscv': 'Master of Science in Computer Vision',
    'program_mse_ss': 'Master of Software Engineering in Scalable Systems',
    'program_msece': 'The Master of Science in Electrical and Computer Engineering',
    'program_msecs': 'The Master of Science in Engineering and Computer Science',
    'program_msi': 'Master of Science in Information',
    'program_msim': 'Master of Science in Information Management',
    'program_msin': 'Master of Science in Information Networking',
    'program_msis': 'Master of Science in Information Systems',
    'program_msit_is': 'Master of Science in Information Technology-Information Security',
    'program_msit_pe': 'Master of Science in Information Technology in Privacy Engineering',
    'program_msit': 'Master of Science in Information Technology',
    'program_msmite': 'Master of Science in Mobile and IoT Engineering',
    'program_msml': 'Master of Science in Machine Learning',
    'program_msr': 'Master of Science in Robotics',
    'program_mssi': 'Master of Science in Security Informatics',
    'program_mswe': 'Master of Software Engineering',
    'program_netsys': 'Networked Systems',
    'program_pre_doctoral_mscs': 'Pre-Doctoral Master of Science in Computer Science',
    'program_scm_cs': 'Brown\'s Master of Science in Computer Science',
    'program_sesv': 'Master of Science in Software Engineering - Silicon Valley',
    'program_syde': 'Systems Design Engineering',
    'program_ee': 'Master of Science in Electrical Engineering',
    'program_eecs_meng': 'Master of Engineering in Electrical Engineering and Computer Science',
    'program_ese_phd': 'PhD in Electrical and Systems Engineering',
    'program_is': 'Information System',
    'program_math_phd': 'PhD in Mathematics',
    'program_mcds': 'Master of Computational Data Science',
    'program_mcis': 'Computer Information Systems',
    'program_mcit': 'Master of Computer and Information Technology',
    'program_mcs': 'Master of Computer Science',
    'program_mds': 'Master of Data Science',
    'program_mdsai': 'Master of Data Science and AI',
    'program_meng_ce': 'Master of Engineering In Computer Engineering',
    'program_meng_s&t': 'Master of Engineering In Science And Technology',
    'program_meng': 'Master of Engineering',
    'program_met': 'Multimedia & Entertainment Technology',
    'program_miis': 'Master of Science In Intelligent Information Systems',
    'program_mint': 'Mathematik, Informatik, Naturwissenschaften und Technik',
    'program_mlt': 'Master of Law and Taxation',
    'program_mmath': 'Master of Mathematics',
    'program_mpcs_(big_data)': 'Masters Program in Computer Science (Big Data)',
    'program_mpcs': 'Masters Program in Computer Science',
    'program_msai_ee': 'Master of Science in Artificial Intelligence - Electrical Engineering',
    'program_msai': 'Master of Science in Artificial Intelligence',
    'program_msaii': 'Master of Science in Artificial Intelligence and Innovation',
    'program_msc_cs': 'MSc Computer Science',
    'program_msc_it': 'MSc in Information Technology',
    'program_msc_sse': 'Master of Science in Software and Systems Engineering',
    'program_mscac': 'Master of Science in Applied Computing (MScAC)',
    'program_msce': 'Master of Science in Computer Engineering',
    'program_mscs': 'Master of Science in Computer Science',
    'program_mscse': 'Master of Science in Computer Science and Engineering',
}
def readExcel(path):
    # using pandas
    df = pd.read_excel(path)
    return df


def generateSchoolJava(javaSchoolName):
    # saveSchoolData(new School("shortName", ESource.OPENCS), schoolRepository);
    longName = schoolNameMapping[javaSchoolName]
    lat = str(schoolLatLongMapping[javaSchoolName][0])
    lng = str(schoolLatLongMapping[javaSchoolName][1])

    res = f"School {javaSchoolName} = new School(\"{longName}\", ESource.OPENCS,\"{lat}\",\"{lng}\");\nsaveSchoolData({javaSchoolName}, schoolRepository);"
    return res


def generateProgramJava(javaProgramname, javaSchoolName):
    #         Program test = new Program("short", ESource.OPENCS, "MS", school1);
    #         programRepository.save(test);
    longName = programNameMapping[javaProgramname]
    if "phd" in str(longName).lower():
        degree = "PhD"
    else:
        degree = "MS"
    res = f"Program {javaSchoolName + '_' + javaProgramname} = new Program(\"{longName}\",  ESource.OPENCS, \"{degree}\", {javaSchoolName});\nprogramRepository.save({javaSchoolName + '_' + javaProgramname});"
    return res


def main():
    path = "data/Datapoints.xlsx"
    sheet = readExcel(path)
    for index, row in sheet.iterrows():
        if str(row['项目']) != 'nan' and row['项目'] != "":
            if "@" in str(row['项目']):
                program_short = str(row['项目']).split("@")[0]
                school_short = str(row['项目']).split("@")[1]
                javaSchoolName = f"school_{school_short.lower().replace(' ', '_').replace('-', '_').replace('&', '_')}"
                javaProgramName = f"program_{program_short.lower().replace(' ', '_').replace('-', '_'.replace('&', '_'))}"
                if javaSchoolName not in schoolPrograms:
                    schoolPrograms[javaSchoolName] = {javaProgramName}
                else:
                    schoolPrograms[javaSchoolName].add(javaProgramName)
    print(schoolPrograms)
    for schoolJavaName in schoolPrograms:
        programs = schoolPrograms[schoolJavaName]
        # print(f"School: {schoolName}, JavaName: {schoolJavaName}, Programs: {programs}")
        print(generateSchoolJava(schoolJavaName))
        for i in programs:
            print(generateProgramJava(i, schoolJavaName))
        print("\n\n")


if __name__ == '__main__':
    main()

    # {'program_1_year_mscs': "Master of Science in Computer Science (One Year)",
    # 'program_2_year_mscs': "Master of Science in Computer Science (Two Year)",
    # 'program_9_course_mscs': "",
    # 'program_12_course_mscs', 'program_ac', 'program_ce_phd', 'program_ce', 'program_cggt', 'program_cm', 'program_cs_general', 'program_cs_meng', 'program_cs_phd', 'program_cs_pmp', 'program_cs28', 'program_cs37', 'program_cs75', 'program_cse', 'program_cybersecurity', 'program_ds', 'program_ds75', 'program_dsml', 'program_ec79', 'program_ece_meng_(co_op)', 'program_ece_meng', 'program_ece_meng', 'program_ece_phd', 'program_ece', 'program_edic_phd', 'program_ee_pmp', 'program_ee', 'program_eecs_meng', 'program_ese_phd', 'program_is', 'program_math_phd', 'program_mcds', 'program_mcis', 'program_mcit', 'program_mcs', 'program_mds', 'program_mdsai', 'program_meng_ce', 'program_meng_s&t', 'program_meng', 'program_met', 'program_miis', 'program_mint', 'program_mlt', 'program_mmath', 'program_mpcs_(big_data)', 'program_mpcs', 'program_msai_ee', 'program_msai', 'program_msaii', 'program_msc_cs', 'program_msc_it', 'program_msc_sse', 'program_mscac', 'program_msce', 'program_mscs', 'program_mscse', 'program_mscv', 'program_mse_ss', 'program_msece', 'program_msecs', 'program_msi', 'program_msim', 'program_msin', 'program_msis', 'program_msit_is', 'program_msit_pe', 'program_msit', 'program_msmite', 'program_msml', 'program_msr', 'program_mssi', 'program_mswe', 'program_netsys', 'program_pre_doctoral_mscs', 'program_scm_cs', 'program_sesv', 'program_syde'}
