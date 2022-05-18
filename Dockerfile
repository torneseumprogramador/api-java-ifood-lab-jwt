FROM openjdk:17-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]

# docker build -t didox/java_jwt .
# docker push didox/java_jwt

# export USER="pg"
# export PASSWORD="pgdesafio345"
# export DATABASE_URL="postgresql://seu-host-do-postgre.com:5432/pg_desafio?createDatabaseIfNotExist=true&sslmode=disable&useTimezone=true&serverTimezone=UTC"
# docker run -d -e USER -e PASSWORD -e DATABASE_URL -p 8080:8080 --name java_jwt didox/java_jwt