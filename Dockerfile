FROM eclipse-temurin:17-jdk-alpine
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} ./
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "./pinch-penny-0.0.1-SNAPSHOT.jar"]

