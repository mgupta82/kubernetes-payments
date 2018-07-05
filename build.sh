cd mysql

docker build -t payment/persistencedb .

cd ..

cd persistance-api

mvn dockerfile:build

cd ..

cd router-service

mvn clean install dockerfile:build

cd ..
