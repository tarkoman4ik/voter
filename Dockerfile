FROM openjdk:21-jdk-slim
EXPOSE 8080
COPY build/libs/voter-0.0.1-SNAPSHOT.jar voter.jar
ENTRYPOINT ["java","-jar","/voter.jar"]