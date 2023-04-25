FROM openjdk:17 as build
WORKDIR /tmp
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src
RUN chmod 777 mvnw
RUN sed -i 's/\r$//' mvnw
RUN ./mvnw package -DskipTests

FROM openjdk:17
LABEL org.opencontainers.image.source="https://github.com/echo-cool/COMP3032J-Degree-Project-Offer-Master-Group-7"
ARG JAR_FILE=target/*.jar
COPY --from=build /tmp/${JAR_FILE} app.jar
COPY src/main/resources /src/main/resources
EXPOSE 8080
ENTRYPOINT ["java","-Xmx256m","-jar","/app.jar"]

#
#FROM openjdk:17
#LABEL org.opencontainers.image.source="https://github.com/echo-cool/COMP3032J-Degree-Project-Offer-Master-Group-7"
#ARG JAR_FILE=target/*.jar
#COPY ${JAR_FILE} app.jar
#COPY src/main/resources /src/main/resources
#EXPOSE 8080
#ENTRYPOINT ["java","-jar","/app.jar"]