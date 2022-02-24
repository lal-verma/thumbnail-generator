########## using slim - size 438 mb
# FROM openjdk:11-slim as builder

########## using adoptopenjdk - size 250 mb
FROM adoptopenjdk:11-jre-hotspot as builder

ARG JAR_FILE=target/thumbnail_generator_basic-0.1.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]