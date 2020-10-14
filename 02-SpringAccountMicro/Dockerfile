FROM adoptopenjdk/openjdk8
EXPOSE 8081
ADD ./target/02-SpringAccountMicro-0.0.1-SNAPSHOT.jar micro-account.jar
ENTRYPOINT [ "java","-jar","/micro-account.jar" ]