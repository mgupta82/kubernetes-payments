# docker-jmeter

Docker image for [Apache JMeter](http://jmeter.apache.org).
This Docker image can be run as the ``jmeter`` command. 
Find Images of this repo on [Docker Hub](https://hub.docker.com/r/justb4/jmeter).

## Building

Inspired and created by referencing https://hub.docker.com/r/justb4/jmeter

To build the image, run command : ./build_testing_fw.sh  in docker terminal from parent location "payment".

## Running test suite

  In you docker terminal:
  
     - cd payment/testing-service-jmeter/
	 - ./test.sh
	 
  For each test case, a docker container is launched and jmeter test is run.
  
## View results.

  Go to payment/testing-service-jmeter/tests/suite/report and view .jtl and .log files.