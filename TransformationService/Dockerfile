FROM openjdk:8-jdk-alpine
EXPOSE 8090
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} transformation-service.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/transformation-service.jar"]
RUN apk --update add \
    fontconfig \
    ttf-dejavu 
