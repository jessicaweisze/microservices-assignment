FROM openjdk:8-slim
EXPOSE 8090
WORKDIR /app
COPY target/todo-board-service-0.0.1-SNAPSHOT.jar .
CMD ["java", "-jar", "todo-board-service-0.0.1-SNAPSHOT.jar"]