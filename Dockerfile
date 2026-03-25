FROM eclipse-temurin:11-jdk

WORKDIR /app

COPY target/university.war app.war

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.war"]