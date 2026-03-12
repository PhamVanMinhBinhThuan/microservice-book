# Stage 1: Use Maven for building
FROM maven:3.8.5-openjdk-17-slim AS build
WORKDIR /app
COPY ./apigateway ./apigateway
WORKDIR /app/apigateway
RUN mvn clean package -DskipTests

# Stage 2: Use OpenJDK for running the application
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app
COPY --from=build /app/apigateway/target/*.jar apigateway.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "apigateway.jar"]