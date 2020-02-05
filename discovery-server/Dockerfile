FROM openjdk:8-slim
EXPOSE 8761
WORKDIR /app
COPY target/discovery-server-0.0.1-SNAPSHOT.jar .
CMD ["java", "-jar", "discovery-server-0.0.1-SNAPSHOT.jar"]