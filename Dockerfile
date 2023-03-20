FROM openjdk:17
LABEL org.opencontainers.image.source="https://github.com/echo-cool/COMP3032J-Degree-Project-Offer-Master-Group-7"
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]