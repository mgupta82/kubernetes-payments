eval $(minishift oc-env)

eval $(minishift docker-env)

oc login

oc new-project payment --display-name="payment"

oc project payment

#############My Sql Persistence DB#########################################
oc new-app --name=persistencedb https://github.com/mgupta82/payment.git --context-dir=mysql strategy=docker

#oc new-app -e MYSQL_USER=test MYSQL_PASSWORD=test MYSQL_DATABASE=projectdb registry.access.redhat.com/rhscl/mysql-56-rhel7 --name=persistencedb

#cd mysql

#source run.sh

#sleep 5

#oc rollout latest persistencedb

#cd ..
################Persistence Service#########################################
#oc new-app --name=persistanceservice openshift/redhat-openjdk18-openshift:1.2~https://github.com/mgupta82/payment.git --context-dir=persistance-api  strategy=source

cd persistance-api

mvn clean install fabric8:deploy -Popenshift -DskipTests

cd ..
##########################Router and Audit Mongo DB#################################

oc new-app --name="routerdb" mongo

#############################Jboss A-MQ Basic#######################################
oc create sa amq-service-account

oc policy add-role-to-user view system:serviceaccount:payment:amq-service-account

oc create -f https://raw.githubusercontent.com/jboss-openshift/application-templates/master/amq/amq63-basic.json

oc new-app --name=activemq \
--param=APPLICATION_NAME=activemq \
openshift/amq63-basic \
-e AMQ_USER=admin \
-e AMQ_PASSWORD=admin \
-e AMQ_TRANSPORTS=openwire,amqp,stomp,mqtt \
-e AMQ_QUEUES=pacs.002.001.09.response.queue,pacs.008.001.07.request.queue \
-e AMQ_MESH_DISCOVERY_TYPE=dns \
-e AMQ_STORAGE_USAGE_LIMIT="1 gb"

#############################Router Service#########################################
cd router-service

mvn clean install fabric8:deploy -Popenshift -DskipTests

cd ..

###############################Transformation Service###############################
cd TransformationService

mvn clean install fabric8:deploy -Popenshift -DskipTests

cd ..

###############################Validation Service###################################

cd ValidationService

mvn clean install fabric8:deploy -Popenshift -DskipTests

cd ..

#################################kafka and Zookeeper################################
#oc create -f https://raw.githubusercontent.com/mattf/openshift-kafka/master/resources.yaml

oc create -f kafka/resources.yaml

oc new-app apache-kafka --name=kafka --param=NAME=kafka

#oc run -it --rm kafka-debug --image=mgupta82/kafka --command -- bash

#sleep 10

#bin/kafka-topics.sh --create --zookeeper kafka:2181 --replication-factor 1 --partitions 1 --topic audit_test

#bin/kafka-topics.sh --list --zookeeper kafka:2181

#exit


#################################Audit Service######################################
