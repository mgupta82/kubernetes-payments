FROM openjdk:8-jdk-alpine
EXPOSE 8080
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} auditservice-consumer-kafka.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/auditservice-consumer-kafka.jar"]