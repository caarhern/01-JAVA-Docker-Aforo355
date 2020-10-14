FROM adoptopenjdk/openjdk8
EXPOSE 8888
ADD ./target/04-SpringConfigServer-0.0.1-SNAPSHOT.jar config-server.jar
ENTRYPOINT [ "java","-jar","/config-server.jar" ]