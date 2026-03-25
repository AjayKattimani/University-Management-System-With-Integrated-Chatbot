FROM openjdk:11

WORKDIR /app

COPY target/university.war app.war

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.war"]