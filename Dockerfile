FROM openjdk:11
COPY target/quarkus-app /app
ENTRYPOINT ["java","-jar","/app/quarkus-run.jar"]