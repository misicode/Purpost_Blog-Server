FROM openjdk:17-jdk-alpine
LABEL authors="misicode"
ARG JAR_FILE=target/auth-service-0.0.1.jar
COPY ${JAR_FILE} purpost-auth.jar
EXPOSE 8090

ENTRYPOINT ["java", "-jar", "purpost-auth.jar"]