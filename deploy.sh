eval $(minishift oc-env)

eval $(minishift docker-env)

oc login

oc new-project payment --display-name="payment"

oc project payment

oc new-app -e MYSQL_USER=test MYSQL_PASSWORD=test MYSQL_DATABASE=projectdb registry.access.redhat.com/rhscl/mysql-56-rhel7 --name=persistencedb

cd mysql

source run.sh

oc rollout latest persistencedb

cd ..

cd persistance-api

mvn clean install fabric8:deploy -Popenshift -DskipTests

cd ..

oc new-app --name="routerdb" mongo

oc create sa amq-service-account

oc policy add-role-to-user view system:serviceaccount:payment:amq-service-account

oc new-app --name=activemq \
-e AMQ_USER=admin \
-e AMQ_PASSWORD=admin \
-e AMQ_TRANSPORTS=openwire,amqp,stomp,mqtt \
-e AMQ_QUEUES=pacs.002.001.09.response.queue,pacs.008.001.07.request.queue \
-e AMQ_MESH_DISCOVERY_TYPE=dns \
-e AMQ_MESH_SERVICE_NAME=activemq \
-e AMQ_MESH_SERVICE_NAMESPACE=payment \
-e AMQ_STORAGE_USAGE_LIMIT="1 gb" \
registry.access.redhat.com/jboss-amq-6/amq63-openshift

cd router-service

mvn clean install fabric8:deploy -Popenshift -DskipTests

cd ..
