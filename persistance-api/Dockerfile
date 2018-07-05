FROM openjdk:8-jdk-alpine
EXPOSE 8192
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} persistance-api.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/persistance-api.jar"]