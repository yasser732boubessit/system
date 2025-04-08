FROM openjdk:17
WORKDIR /app
COPY target/replyservice-*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
