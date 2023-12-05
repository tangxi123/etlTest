FROM openjdk:8-jdk-alpine
ADD target/etlTest-1.0-SNAPSHOT.jar /etlTest-1.0-SNAPSHOT.jar
ADD src/main/resources/testng.xml /testng.xml
ENTRYPOINT ["java","-jar","/etlTest-1.0-SNAPSHOT.jar","/testng.xml"]