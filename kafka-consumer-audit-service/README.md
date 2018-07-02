# Spring Boot with Kafka for Audit Service - Consumer

This code creates an app in Spring Boot with Spring Kafka to consume JSON/String message from Kafka topics. The JSON consumed is an Audit Service message to be persisted to a DB

## Start Zookeeper
- `bin/zookeeper-server-start.sh config/zookeeper.properties`

## Start Kafka Server
- `bin/kafka-server-start.sh config/server.properties`

## Create Kafka Topic
- `bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic audit_Topic`

