cd mysql

docker build -t payment/persistencedb .

cd ..

cd persistance-api

mvn clean install dockerfile:build -DskipTests

cd router-service

mvn clean install dockerfile:build -DskipTests

cd ..
