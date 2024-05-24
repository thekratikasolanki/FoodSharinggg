# Use the official Maven image to build the application
FROM maven:3.8.4-openjdk-17 AS build

# Set the working directory in the container
WORKDIR /app

# Copy the project files into the container
COPY . .

# Package the application without running tests
RUN mvn clean package -DskipTests

# Use the official OpenJDK image to run the application
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the packaged jar file from the build stage
COPY --from=build /app/target/foodSharingg-0.0.1-SNAPSHOT.jar app.jar

# Expose port 8094
EXPOSE 8094

# Set the entrypoint command
ENTRYPOINT ["java", "-jar", "app.jar"]

