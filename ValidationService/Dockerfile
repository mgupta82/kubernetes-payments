FROM openjdk:8-jdk-alpine
EXPOSE 8083
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} validation-service.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/validation-service.jar"]
RUN apk --update add \
    fontconfig \
    ttf-dejavu 
