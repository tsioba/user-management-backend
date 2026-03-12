# Stage 1: Build
FROM eclipse-temurin:25-jdk AS build

# Εγκατάσταση Maven χειροκίνητα
RUN apt-get update && apt-get install -y maven

WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Stage 2: Run
FROM eclipse-temurin:25-jdk-alpine
WORKDIR /app
COPY --from=build /app/target/user-management-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]