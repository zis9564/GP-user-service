FROM openjdk:11-jdk
VOLUME /tmp

COPY user-service/build/libs/*SNAPSHOT.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar",""]