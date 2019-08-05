FROM openjdk:8-jdk-alpine
RUN mkdir -p /opt

ARG JAR_FILE
COPY ${JAR_FILE} /opt/app.jar
WORKDIR /opt
EXPOSE 8080

ENTRYPOINT java -XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap \
           -jar /opt/app.jar

