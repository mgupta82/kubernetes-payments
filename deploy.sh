eval $(minishift oc-env)

eval $(minishift docker-env)

oc login

oc new-project payment --display-name="payment"

oc project payment

oc new-app -e MYSQL_USER=test MYSQL_PASSWORD=test MYSQL_DATABASE=projectdb registry.access.redhat.com/rhscl/mysql-56-rhel7 --name=persistencedb

cd mysql

source run.sh

sleep 5

oc rollout latest persistencedb

cd ..

cd persistance-api

mvn clean install fabric8:deploy -Popenshift -DskipTests

