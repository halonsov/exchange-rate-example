FROM openjdk:11-jdk-oracle

RUN adduser user
COPY --chown=user target/*.jar /usr/src/myapp/app.jar
WORKDIR /usr/src/myapp
EXPOSE 8080
USER user
ENTRYPOINT ["java", "-Dexchangerate.fixer.accessKey=${FIXER_TOKEN}", "-Dexchangerate.banxico.token=${BANXICO_TOKEN}", "-jar", "/usr/src/myapp/app.jar"]
