FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} job_hunt_tracker-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/job_hunt_tracker-0.0.1-SNAPSHOT.jar"]