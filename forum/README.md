# spring-boot-api-rest-security
Spring Boot API Rest - Segurança da API, Cache e Monitoramento

## How to run:
### Export variables:
export FORUM_DATABASE_URL=<br>
export FORUM_DATABASE_USERNAME=<br>
export FORUM_DATABASE_PASSWORD=<br>
export FORUM_JWT_SECRET=<br><br>
$ java -jar -Dspring.profiles.active=prod -DFORUM_DATABASE_URL -DFORUM_DATABASE_USERNAME -DFORUM_DATABASE_PASSWORD -DFORUM_JWT_SECRET forum.jar

## Building app
mvn clean package

## Dockerfile:
$ docker build -t alura/forum .
#### don't forget the dot (.)

## Runing application
$ docker run -p 8080:8080 -e SPRING_PROFILES_ACTIVE='prod' -e FORUM_DATABASE_URL='jdbc:h2:mem:alura-forum' -e FORUM_DATABASE_USERNAME='sa' -e FORUM_DATABASE_PASSWORD='' -e FORUM_JWT_SECRET='123456' alura/forum