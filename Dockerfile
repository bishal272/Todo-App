#
# Build stage
#
FROM maven:3.9.0-eclipse-temurin-17-alpine AS build
COPY . .
RUN mvn clean package -DskipTests

#
# Package stage
#
FROM openjdk:19
COPY --from=build /target/todo_app.jar todo.jar
# ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java","-jar","todo.jar"]