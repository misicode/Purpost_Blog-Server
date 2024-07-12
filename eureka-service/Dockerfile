FROM openjdk:17-jdk-alpine
LABEL authors="misicode"
ARG JAR_FILE=target/eureka-service-0.0.1.jar
COPY ${JAR_FILE} purpost-eureka.jar
EXPOSE 8761

ENTRYPOINT ["java", "-jar", "purpost-eureka.jar"]