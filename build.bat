cd mysql

docker build -t payment/persistencedb .

cd ..

cd TransformationService

call mvn clean install dockerfile:build -DskipTests

cd ..

cd persistance-api

call mvn clean install dockerfile:build -DskipTests

cd ..

cd ValidationService

call mvn clean install dockerfile:build -DskipTests

cd router-service

call mvn clean install dockerfile:build -DskipTests

cd ..

cd kafka-consumer-audit-service

call mvn clean install dockerfile:build

cd ..