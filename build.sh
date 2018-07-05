cd mysql

docker build -t payment/persistencedb .

cd ..

cd persistance-api

mvn clean install dockerfile:build -DskipTests

cd ..


cd router-service


mvn clean install dockerfile:build -DskipTests

cd ..
