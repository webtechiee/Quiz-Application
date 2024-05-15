# stage 1 BUILDING THE APPLICATION
FROM maven:3.8.3-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests


# stage 2 RUNNING THE APPLICATION
FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/demo-0.0.1-SNAPSHOT.jar question.jar
EXPOSE 8989
ENTRYPOINT ["java", "-jar", "question.jar"]