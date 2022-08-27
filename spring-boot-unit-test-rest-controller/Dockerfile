FROM maven:3.8.6-openjdk-18-slim as MAVEN_BUILD
WORKDIR /build
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn package -Dmaven.test.skip=true
FROM openjdk:18-alpine
WORKDIR /app
ARG JAR_FILE=*.jar
COPY --from=MAVEN_BUILD /build/target/${JAR_FILE} ./app.jar
EXPOSE 8090
CMD ["java", "-jar", "app.jar"]

