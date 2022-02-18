#!/bin/bash

mvn clean package
docker build -t halonsov/exchange-api:latest .

#docker stop exchange-api
#docker run --rm -d --name exchange-api -e FIXER_TOKEN=$FIXER_TOKEN -e BANXICO_TOKEN=$BANXICO_TOKEN -p 8080:8080 -it halonsov/exchange-api:latest
#docker logs -f exchange-api
#docker ps --no-trunc
