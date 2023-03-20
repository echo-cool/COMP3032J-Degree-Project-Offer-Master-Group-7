# COMP3032J-Degree-Project-Offer-Master-Group-7

## Project Description
We aim to build web application with excellent user experience, high performance, and stability. Our potential users are who aim to apply to overseas universities. Our platform will help the users with school applications by providing them with one-stop application tools, such as program selection and admission community. Especially the program recommendation based on applicants' backgrounds is the key feature of our platform.

![logo.png](images/logo.jpg)

## Build this project
### Backend (Springboot)
```bash
mvn package -DskipTests --file pom.xml
docker build -t fyp_offer_master_springboot .
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