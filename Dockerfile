FROM amazoncorretto:17-alpine
ARG JAR_FILE=target/TGF_Akka_tester-1.0-SNAPSHOT-allinone.jar
COPY ${JAR_FILE} /app.jar
ENTRYPOINT ["java","-jar","/app.jar"]

