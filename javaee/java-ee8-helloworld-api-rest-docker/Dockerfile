FROM maven:3.6.0-jdk-11-slim AS builder
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package -Dmaven.test.skip

FROM payara/micro:5-SNAPSHOT
COPY --from=builder /home/app/target/rest.war  /opt/payara/deployments/rest.war