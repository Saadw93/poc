FROM eclipse-temurin:8-jdk-alpine
COPY ./SmallestSpringApp/target/*.jar app.jar
EXPOSE 8080
WORKDIR /app
ENTRYPOINT ["java", "-jar", "/app.jar"]