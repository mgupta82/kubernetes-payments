oc login

oc new-project payment --display-name="payment"

oc project payment

oc new-app --name=persistencedb https://github.com/mgupta82/payment.git --context-dir=mysql strategy=docker

oc new-app --name=persistanceservice openshift/redhat-openjdk18-openshift:1.2~https://github.com/mgupta82/payment.git --context-dir=persistance-api  strategy=source

oc expose svc/persistanceservice

oc new-app --name=transformationservice openshift/redhat-openjdk18-openshift:1.2~https://github.com/mgupta82/payment.git --context-dir=ANZPOC  strategy=source

oc expose svc/transformationservice

