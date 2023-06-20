FROM openjdk:8-jre-slim
WORKDIR /app
COPY /target/col-app*.war col-app.war
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "col-app.war"]