FROM eclipse-temurin:8-jdk-alpine

RUN apk add --no-cache iputils
WORKDIR /app
COPY /target/col-app*.war col-app.war
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "col-app.war"]