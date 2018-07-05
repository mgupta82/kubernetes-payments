FROM openjdk:8-jdk-alpine
EXPOSE 8192
VOLUME /tmp
COPY target/persistance-api.jar persistance-api.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/persistance-api.jar"]