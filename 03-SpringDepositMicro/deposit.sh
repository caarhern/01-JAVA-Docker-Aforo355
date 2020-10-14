echo ==================================================================
echo Generando JAR
echo ==================================================================
mvnw clean package -DskipTests 
echo ==================================================================
echo BUILD and PUSH Docker 
echo ==================================================================
docker build -t micro-deposit:v1.1 .
#docker push castillohernandez01/micro-deposit:v1.1
echo run image 
docker run -p 8006:8006 --name micro-deposit --network aforo255 -d micro-deposit:v1.1
echo ==================================================================
echo End Process
echo =================================================================