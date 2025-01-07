FROM openjdk:17-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ./target/webCrawler-0.0.1-SNAPSHOT.jar webCrawler.jar
ENTRYPOINT ["java", "-jar","/webCrawler.jar"]

