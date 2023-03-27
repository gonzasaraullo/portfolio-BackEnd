FROM amazoncorretto:11-alpine-jdk
MAINTAINER GonzaloSaraullo
COPY target/backend-0.0.1-SNAPSHOT.jar port-app.jar
ENTRYPOINT ["java","-jar","/port-app.jar"]
