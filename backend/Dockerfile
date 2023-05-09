FROM eclipse-temurin:17-jdk-alpine
ADD target/*.jar api.jar
ENTRYPOINT ["java", "-jar", "/api.jar"]