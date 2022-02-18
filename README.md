# Requirements

- Java 11
- Maven 3
- Docker (optional)

# Run in Local

## Build
Execute command

```bash
mvn clean package
```

## Run
Execute command
```bash
FIXER_TOKEN=YOUR_TOKEN
BANXICO_TOKEN=YOUR_TOKEN
java -Dexchangerate.fixer.accessKey=$FIXER_TOKEN \
	-Dexchangerate.banxico.token=$BANXICO_TOKEN\
```

# Run in docker
To build project in docker execute commands

## Build and Run
Build image

```bash
mvn clean package
docker build -t halonsov/exchange-api:latest .
```

Run container
```bash
FIXER_TOKEN=YOUR_TOKEN
BANXICO_TOKEN=YOUR_TOKEN
docker run --rm -d --name exchange-api -e FIXER_TOKEN=$FIXER_TOKEN -e BANXICO_TOKEN=$BANXICO_TOKEN -p 8080:8080 -it halonsov/exchange-api:latest
```

# Swagger

Open in browser [this link](http://127.0.0.1:8080/swagger-ui/index.html)

```bash
curl --location --request GET 'http://127.0.0.1:8080/v1/exchange' \
--header 'Accept: application/json' \
--header 'Authorization: Basic dXNlcmFwaTp1c2VycHN3MTIzLg==' \
--header 'Cookie: JSESSIONID=19C55F0B4654A2A9ADE59BE74527F629'
```


# Generate Tokens

- [Fixer](https://fixer.io/signup/free)
- [Banxico](https://www.banxico.org.mx/SieAPIRest/service/v1/token)

