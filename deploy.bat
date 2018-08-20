oc login -u developer -p developer

oc new-project payment --display-name="payment"

oc project payment

oc login -u system:admin

oc project payment

oc adm policy add-scc-to-user anyuid -z default

oc login -u developer -p developer

call cd persistance-api

mvn clean install fabric8:deploy -Popenshift -DskipTests

cd ..

oc new-app --name="routerdb" mongo

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

cd router-service

call mvn clean install fabric8:deploy -Popenshift -DskipTests

cd ..

cd TransformationService

call mvn clean install fabric8:deploy -Popenshift -DskipTests

cd ..

cd ValidationService

call mvn clean install fabric8:deploy -Popenshift -DskipTests

cd ..

oc create -f kafka/zookeeper.yaml

oc new-app apache-zookeeper --name=zookeeper --param=NAME=zookeeper

oc create -f kafka/kafka.yaml

oc new-app apache-kafka --name=kafka --param=NAME=kafka

