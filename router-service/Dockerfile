FROM openjdk:8-jdk-alpine
EXPOSE 8080
RUN apk --update add \
    fontconfig \
    ttf-dejavu 
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} router-service.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/router-service.jar"]