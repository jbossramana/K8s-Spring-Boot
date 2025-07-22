FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8080
ADD target/lab1-Simple-Service-0.0.1-SNAPSHOT.jar  simple.jar
ENTRYPOINT [ "sh", "-c", "java -jar /simple.jar" ]