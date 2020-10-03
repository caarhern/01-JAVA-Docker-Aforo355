echo ==================================================================
echo Generando JAR
echo ==================================================================
echo mvn clean package -DskipTests 
echo ==================================================================
echo BUILD and PUSH Docker 
echo ==================================================================
docker build -t micro-security:v1.1 .
docker push micro-security:v1.1
echo run image 
#docker run -p 8010:8010 --name micro-security --network aforo255 - antony0618/micro-security:v1.1
echo ==================================================================
echo End Process
echo =================================================================