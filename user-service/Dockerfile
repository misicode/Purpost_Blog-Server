FROM openjdk:17-jdk-alpine
LABEL authors="misicode"
ARG JAR_FILE=target/user-service-0.0.1.jar
COPY ${JAR_FILE} purpost-user.jar
EXPOSE 11090

ENTRYPOINT ["java", "-jar", "purpost-user.jar"]