#
# Build stage
#
COPY . .


#
# Package stage
#
FROM openjdk:19 AS build
ARG JAR_FILE=todoapp/target/todo_app.jar
COPY ${JAR_FILE} /target/todo.jar
# ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java","-jar","/todo.jar"]