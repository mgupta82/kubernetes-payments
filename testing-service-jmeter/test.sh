#!/bin/bash
export timestamp=$(date +%Y%m%d_%H%M%S) && \
export WORK_DIR="`pwd`" && \
export jmeter_path=${WORK_DIR}/tests/suite && \
export R_DIR=${jmeter_path}/dashboard

echo ${jmeter_path}

####### Test runs entries go below #############
docker run \
  -i \
  -v ${WORK_DIR}:${WORK_DIR} \
  -w ${WORK_DIR}  \
  payment/testing-service-jmeter \
  -n \
  -t ${jmeter_path}/Payment_JmeterScripts_Router.jmx \
  -l ${jmeter_path}/report/Payment_JmeterScripts_Router_Result.jtl \
  -j ${jmeter_path}/report/Payment_JmeterScripts_Router.log
  -e -o ${R_DIR}
  
docker run \
  -i \
  -v ${WORK_DIR}:${WORK_DIR} \
  -w ${WORK_DIR}  \
  payment/testing-service-jmeter \
  -n \
  -t ${jmeter_path}/Payment_JmeterScripts_Persistance.jmx \
  -l ${jmeter_path}/report/Payment_JmeterScripts_Persistance_Result.jtl \
  -j ${jmeter_path}/report/Payment_JmeterScripts_Persistance.log
  -e -o ${R_DIR}
  
docker run \
  -i \
  -v ${WORK_DIR}:${WORK_DIR} \
  -w ${WORK_DIR}  \
  payment/testing-service-jmeter \
  -n \
  -t ${jmeter_path}/Payment_JmeterScripts_Validation.jmx \
  -l ${jmeter_path}/report/Payment_JmeterScripts_Validation_Result.jtl \
  -j ${jmeter_path}/report/Payment_JmeterScripts_Validation.log
  -e -o ${R_DIR}
  
