FROM openjdk:8-jdk-alpine
COPY . /etlTest
ENTRYPOINT ["java","-jar","/etlTest/target/etlTest-1.0-SNAPSHOT.jar","/etlTest/src/main/resources/testng.xml"]