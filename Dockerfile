#
# Build stage
#



#
# Package stage
#
FROM openjdk:19 AS build
ARG JAR_FILE=target/todo_app.jar todo.jar
COPY ${JAR_FILE} todo.jar
# ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java","-jar","/todo.jar"]