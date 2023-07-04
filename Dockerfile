FROM openjdk:8-jre-slim
RUN apt-get update && apt-get install -y iputils-ping
WORKDIR /app
COPY /target/col-app*.war col-app.war
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "col-app.war"]