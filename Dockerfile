FROM maven:3.8.4-jdk-11-slim as builder

WORKDIR /app
COPY pom.xml ./
COPY src ./src/

RUN mvn package -DskipTests

FROM adoptopenjdk/openjdk11:jdk-11.0.11_9-alpine

COPY --from=builder /app/target/sampleapp-*.jar /sampleapp-gke.jar

CMD ["java","-Djava.security.egd=file:/dev/./urandom","-Dserver.port=${PORT}","-jar","/sampleapp-gke.jar"]