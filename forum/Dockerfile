# uses a jdk
FROM amazoncorretto:11
# creates a new user called spring
RUN addgroup -S spring && adduser -S spring -G spring
# changes to user spring to avoid problems with root
USER spring:spring
# locate .jar file and put the path into JAR_FILE
ARG JAR_FILE=target/*.jar
# copy .jar file with name app.jar
COPY ${JAR_FILE} app.jar
# runs app.jar using: java -jar /app.jar
ENTRYPOINT ["java","-jar","/app.jar"]

# if using heroku
#ENTRYPOINT ["java","-jar","-Xmx512m", "-Dserver.port=${PORT}", "/app.jar"]