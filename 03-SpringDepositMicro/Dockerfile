FROM adoptopenjdk/openjdk8
EXPOSE 8006
ADD ./target/03-SpringDepositMicro-0.0.1-SNAPSHOT.jar micro-deposit.jar
ENTRYPOINT [ "java","-jar","/micro-deposit.jar" ]