oc login

oc project payment

oc delete all --selector app=persistencedb

oc delete all --selector app=persistance-api

oc delete all --selector app=routerdb

oc delete all --selector app=router-service

oc delete project payment

