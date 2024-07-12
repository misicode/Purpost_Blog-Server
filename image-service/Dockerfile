FROM openjdk:17-jdk-alpine
LABEL authors="misicode"
ARG JAR_FILE=target/image-service-0.0.1.jar
COPY ${JAR_FILE} purpost-image.jar
EXPOSE 9090

ENTRYPOINT ["java", "-jar", "purpost-image.jar"]