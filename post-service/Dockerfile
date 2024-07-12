FROM openjdk:17-jdk-alpine
LABEL authors="misicode"
ARG JAR_FILE=target/post-service-0.0.1.jar
COPY ${JAR_FILE} purpost-post.jar
EXPOSE 10090

ENTRYPOINT ["java", "-jar", "purpost-post.jar"]