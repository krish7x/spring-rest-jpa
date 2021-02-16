FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} krish.jar
ENTRYPOINT ["java","-jar","/krish.jar"]