# Stage 1: Build the JAR
FROM maven:3.8.5-openjdk-17 as builder
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Stage 2: Create the final image
FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY --from=builder /app/target/grocerystore-0.0.1-SNAPSHOT.jar /app/myapp.jar
EXPOSE 8585
ENTRYPOINT ["java", "-jar", "/app/myapp.jar"]
