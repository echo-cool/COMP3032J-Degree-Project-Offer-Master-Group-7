# COMP3032J-Degree-Project-Offer-Master-Group-7

![Docker-compose build](https://github.com/echo-cool/COMP3032J-Degree-Project-Offer-Master-Group-7/actions/workflows/docker-compose-image.yml/badge.svg)

## Project Description
We aim to build web application with excellent user experience, high performance, and stability. Our potential users are who aim to apply to overseas universities. Our platform will help the users with school applications by providing them with one-stop application tools, such as program selection and admission community. Especially the program recommendation based on applicants' backgrounds is the key feature of our platform.

![logo.png](images/logo.jpg)

## Main Features
The **offer master** website provides the following main features:

* **Program and university recommendation**: Our website mainly focuses on helping applicants decide on schools and programs that best fit their backgrounds. Users can select their desired programs manually or access the programs recommended by our system. For a specific program selected by a user, the success rate of their admission will be analyzed.
* **Database of universities**: As our website aims at recommending schools and programs for our applicants, we also provide a database of universities. This database has several responsibilities. Firstly, the data will be used to train our recommendation models. Moreover, users can search and browse the data of schools and programs. Furthermore, users may leave comments for each program and select them into their own ``program list". The relevant data will be mainly collected in two ways. First, some open-source admission data and program information will be found on GitHub and Kaggle. Apart from that, our users can upload their own admission status and application backgrounds to expand our database.
* **Applicant background system**: We will provide a background system for our users (applicants) to support our recommendation system. Users can update their application backgrounds in this system, including their GPA, undergraduate school, language proficiency, and GRE score. Therefore, according to their uploaded background, our recommendation system is able to recommend appropriate schools and programs.
* **Applicants community**: To help our users to apply, an application community is also provided where our users can have a discussion with other applicants on topics of universities, programs, offers, etc. Moreover, they can post their admission information and check the offer timelines of recent years in this platform.

## Build this project

### Using docker-compose
```shell
docker-compose build --parallel
```
or
```shell
docker-compose up -d --build
```

```shell
docker-compose up
```

### Backend (Springboot)
```bash
mvn package -DskipTests --file pom.xml
docker build -t fyp_offer_master_springboot .
docker build . --file Dockerfile --tag ghcr.io/echo-cool/fyp/fyp_offer_master_springboot:latest
```

### Frontend-User (Vue)
```bash
cd vue-user/
npm install
npm run build
docker build -t fyp_offer_master_vue_user .
```

### Frontend-Admin (Vue)
```bash
cd vue-admin/
npm install
npm run build:prod
docker build -t fyp_offer_master_vue_admin .
```
## Starting this project

### Backend (Springboot)
```bash
docker pull ghcr.io/echo-cool/fyp/fyp_offer_master_springboot:latest
docker run -p 8080:8080 ghcr.io/echo-cool/fyp/fyp_offer_master_springboot:latest
```

### Frontend-User (Vue)
```bash
docker pull ghcr.io/echo-cool/fyp/fyp_offer_master_vue_user:latest
docker run -p 8081:8080 ghcr.io/echo-cool/fyp/fyp_offer_master_vue_user:latest
```

### Frontend-Admin (Vue)
```bash
docker pull ghcr.io/echo-cool/fyp/fyp_offer_master_vue_admin:latest
docker run -p 8082:8080 ghcr.io/echo-cool/fyp/fyp_offer_master_vue_admin:latest
```