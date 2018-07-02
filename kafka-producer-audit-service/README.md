# Spring Boot with Kafka for Audit Service - Producer

This code creates an app in Spring Boot with Spring Kafka to Publish JSON/String message to a Kafka topic. The JSON sent is an Audit Service message to be consumed by a consumer
## Start Zookeeper
- `bin/zookeeper-server-start.sh config/zookeeper.properties`

## Start Kafka Server
- `bin/kafka-server-start.sh config/server.properties`

## Create Kafka Topic
- `bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic audit_Topic`

## Consume from the Kafka Topic via Console
- `bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic audit_Topic --from-beginning`

## Publish message via WebService
- `http://localhost:8081/audit/producer/ValidationService'
- `http://localhost:8081/audit/producer/TransformationService'
