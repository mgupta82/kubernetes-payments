# payment
https://www.iso20022.org/payments_messages.page

1) Clone the repository

2) Run **build.sh** (in unix and mac) or **build.bat** (in windows). This will build all the microservices and create docker image locally.

3) Run **docker-compose up -d**. This will start all the microservices in docker container with their dependent softwares like mysql , mongodb and kafka

4) Open **localhost:8161/admin** (admin/admin). 
Drop the request message (router-service/src/test/resources/FIToFICustomerCreditTransfer_1.xml) in request queue(**pacs.008.001.07.request.queue**).
You can expect the response in response queue (**pacs.002.001.09.response.queue**).

5) To stop the containers run **docker-compose down**.
