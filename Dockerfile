# Use the official OpenJDK image as a base image
FROM openjdk:17-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the built JAR file into the container
COPY build/libs/poc-0.0.1-SNAPSHOT.jar /app/poc-0.0.1-SNAPSHOT.jar

# Define the command to run the JAR file
ENTRYPOINT ["java", "-jar", "/app/poc-0.0.1-SNAPSHOT.jar"]

# Expose the application's port
EXPOSE 8088
