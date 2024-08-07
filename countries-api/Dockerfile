FROM openjdk:21-slim
ARG VERSION=0.0.1-SNAPSHOT
WORKDIR /app/
COPY target/countries-api-${VERSION}.jar /app/countries-api.jar
CMD ["java", "-jar", "/app/countries-api.jar"]
EXPOSE 8080