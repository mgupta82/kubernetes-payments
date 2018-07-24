FROM rhel
RUN mkdir -p /opt/kafka \
  && cd /opt/kafka \
  && yum repolist \
  && yum -y install java-1.8.0-openjdk-headless tar \
  && curl -s https://www.mirrorservice.org/sites/ftp.apache.org/kafka/1.1.0/kafka_2.11-1.1.0.tgz | tar -xz --strip-components=1 \
  && yum clean all
#COPY zookeeper-server-start-multiple.sh /opt/kafka/bin/

RUN chmod -R a=u /opt/kafka
WORKDIR /opt/kafka
VOLUME /tmp/kafka-logs /tmp/zookeeper
EXPOSE 2181 2888 3888 9092
