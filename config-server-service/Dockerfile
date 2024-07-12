FROM openjdk:17-jdk-alpine
LABEL authors="misicode"
ARG JAR_FILE=target/config-server-service-0.0.1.jar
COPY ${JAR_FILE} purpost-config-server.jar
EXPOSE 8888

ENTRYPOINT ["java", "-jar", "purpost-config-server.jar"]