FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8081
ADD target/lab2-Other-Service-0.0.1-SNAPSHOT.jar  other.jar
ENTRYPOINT [ "sh", "-c", "java -jar /other.jar" ]