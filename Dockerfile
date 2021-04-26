FROM adoptopenjdk/openjdk11:latest
COPY ./target/airmonitor-ws-0.0.1-SNAPSHOT.jar /usr/app/
WORKDIR /usr/app
RUN sh -c 'touch airmonitor-ws-0.0.1-SNAPSHOT.jar'
ENTRYPOINT ["java","-jar","airmonitor-ws-0.0.1-SNAPSHOT.jar"]