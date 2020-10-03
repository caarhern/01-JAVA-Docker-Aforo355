FROM adoptopenjdk/openjdk8
EXPOSE 8010
ADD ./target/01-SpringBootMicroservice-0.0.1-SNAPSHOT.jar micro-security.jar
ENTRYPOINT [ "java","-jar","/micro-security.jar" ]