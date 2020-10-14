echo ==================================================================
echo Generando JAR
echo ==================================================================
mvnw clean package -DskipTests 
echo ==================================================================
echo BUILD and PUSH Docker 
echo ==================================================================
docker build -t config-server:v1.1 .
#docker push castillohernandez01/micro-deposit:v1.1
echo run image 
docker run -p 8888:8888 --name config-server --network aforo255 -d config-server:v1.1
echo ==================================================================
echo End Process
echo =================================================================