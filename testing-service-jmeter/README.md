# docker-jmeter

Docker image for [Apache JMeter](http://jmeter.apache.org).
This Docker image can be run as the ``jmeter`` command. 

## Pre-requisites

   Windows + Docker quickstart:
   
      - cd payment/testing-service-jmeter/
	  - dos2unix * 
	     This will convert to unix format so that entry.sh and test.sh work in docker container.

## Building

Inspired and created by referencing https://hub.docker.com/r/justb4/jmeter

To build the image, run command : ./build_testing_fw.sh  in docker terminal from parent location "payment".

## Running test suite

  Note : If running the first time, wait until the Router service is up. You can check by typing address <docker-ip>:8161/admin and see successful response.

  In you docker terminal:
  
     - cd payment/testing-service-jmeter/
	 - ./test.sh
	 
  For each test case, a docker container is launched and jmeter test is run.
  
## View results.

  Go to payment/testing-service-jmeter/tests/suite/report and view .jtl and .log files.
  
## Adding more tests.

  - Copy your .jmx files under payment/testing-service-jmeter/tests/suite folder.
  - Add an entry for test run in ./test.sh (follow the already running entries or comment)