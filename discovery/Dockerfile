# Stage 1: Use Maven for building
FROM maven:3.8.5-openjdk-17-slim AS build
WORKDIR /app
COPY ./discovery ./discovery
WORKDIR /app/discovery
RUN mvn clean package -DskipTests

# Stage 2: Use OpenJDK for running the application
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app
COPY --from=build /app/discovery/target/*.jar discovery.jar
EXPOSE 8761
ENTRYPOINT ["java", "-jar", "discovery.jar"]