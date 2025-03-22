# Stage 1: Build the application using Maven
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app

# Copy Maven files first to leverage caching
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy the rest of the application source
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Run the application with a lightweight JDK
FROM openjdk:17-jdk-slim
WORKDIR /app

# Copy the built JAR file from the build stage
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
