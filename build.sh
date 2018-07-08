cd mysql

docker build -t payment/persistencedb .

cd ..

cd persistance-api

mvn clean install dockerfile:build -DskipTests

cd ..

cd ValidationService

mvn clean install dockerfile:build -DskipTests

cd ..

cd router-service

mvn clean install dockerfile:build -DskipTests

cd ..

cd kafka-consumer-audit-service

mvn clean install dockerfile:build -DskipTests

cd ..

