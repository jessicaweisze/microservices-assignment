FROM openjdk:8-slim
EXPOSE 8080
WORKDIR /app
copy target/todo-board-service-0.0.1-SNAPSHOT.jar .
CMD ["java", "-jar", "todo-board-service-0.0.1-SNAPSHOT.jar", "--spring.datasource.url=jdbc:mysql://${MYSQL_HOST:docker.for.mac.localhost}:3306/db_resolution_ms", "--eureka.client.serviceUrl.defaultZone=docker.for.mac.localhost:8761/eureka"]