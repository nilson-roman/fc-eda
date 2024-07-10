FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY target/fcbalance.jar /app/fcbalance.jar

COPY src/main/resources/application.properties /app/application.properties

EXPOSE 3003

ENTRYPOINT ["java", "-jar", "/app/fcbalance.jar"]

