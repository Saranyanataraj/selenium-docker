FROM openjdk:8u191-jre-alpine3.8

RUN apk add curl jq
#workspace inside docker
WORKDIR /usr/share/udemy

#add .jar files under target from host to docker image
ADD target/selenium-docker.jar          selenium-docker.jar
ADD target/selenium-docker-tests.jar    selenium-docker-tests.jar
ADD target/libs                         libs

#Incase there are any other dependencies add those as well

#Add suite files from host to docker image
ADD book-flight.xml                     book-flight.xml
ADD search-module.xml                   search-module.xml

ADD healthcheck.sh                      healthcheck.sh

#System variables
#BROWSER
#HUB_HOST
#MODULE 

#ENTRYPOINT java -cp selenium-docker.jar:selenium-docker-tests.jar:libs/* -DBROWSER=$BROWSER -DHUB_HOST=$HUB_HOST org.testng.TestNG $MODULE

ENTRYPOINT sh healthcheck.sh

#Make sure when ever any changes in done to the code the docker image has to be rebuilt and then run else changes wont show up