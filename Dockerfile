FROM openjdk:8
WORKDIR /app
COPY target/web-service-cr7imports.jar /app/web-service-cr7imports.jar
EXPOSE 8089
CMD ["java", "-jar", "web-service-cr7imports.jar"]