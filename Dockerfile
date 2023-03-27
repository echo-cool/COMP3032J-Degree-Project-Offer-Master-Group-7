FROM openjdk:17
LABEL org.opencontainers.image.source="https://github.com/echo-cool/COMP3032J-Degree-Project-Offer-Master-Group-7"
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
COPY src/main/resources /src/main/resources
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]