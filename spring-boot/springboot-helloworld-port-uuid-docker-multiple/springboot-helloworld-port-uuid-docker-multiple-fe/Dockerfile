FROM eclipse-temurin:11-jdk-alpine as builder
WORKDIR /opt/app
COPY /springboot-helloworld-port-uuid-docker-multiple-fe/.mvn/ .mvn
COPY /springboot-helloworld-port-uuid-docker-multiple-fe/mvnw pom.xml ./
RUN ./mvnw dependency:go-offline
COPY /springboot-helloworld-port-uuid-docker-multiple-fe/src src
RUN ./mvnw clean package -Dmaven.test.skip
CMD ["java", "-jar", "/opt/app/*.jar"]

FROM eclipse-temurin:11-jre
WORKDIR /opt/app
COPY --from=builder /opt/app/target/*.jar  /opt/app/*.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/opt/app/*.jar"]