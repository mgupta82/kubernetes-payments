cd mysql
docker build -t payment/persistencedb .

cd ..

cd router-service

mvn clean install dockerfile:build

cd ..
