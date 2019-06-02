
FROM openjdk:8u171-jdk-alpine3.8
ADD target/financeiro-api-*.jar financeiro-api.jar
EXPOSE 8080
ENTRYPOINT exec java -Djava.security.egd=file:/dev/./urandom -jar financeiro-api.jar $APP_OPTS
