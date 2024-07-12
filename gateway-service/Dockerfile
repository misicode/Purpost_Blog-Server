FROM openjdk:17-jdk-alpine
LABEL authors="misicode"
ARG JAR_FILE=target/gateway-service-0.0.1.jar
COPY ${JAR_FILE} purpost-gateway.jar
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "purpost-gateway.jar"]