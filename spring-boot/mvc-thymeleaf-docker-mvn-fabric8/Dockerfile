FROM openjdk:8-jre-alpine
ARG JAR_FILE=/target/*.war
COPY ${JAR_FILE} app.war
ENTRYPOINT ["java","-jar","/app.war"]