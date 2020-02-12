FROM openjdk:8-slim
EXPOSE 8888
WORKDIR /app
COPY target/config-server-0.0.1-SNAPSHOT.jar .
CMD ["java", "-jar", "config-server-0.0.1-SNAPSHOT.jar"]