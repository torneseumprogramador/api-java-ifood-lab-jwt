FROM ubuntu/postgres
RUN apt update
RUN apt upgrade -y
RUN apt install default-jdk -y
RUN apt install maven -y
RUN apt install vim -y

# docker run -d -e TZ=UTC -p 5432:5432 -e POSTGRES_USER=ilab -e POSTGRES_DB=apirest -e POSTGRES_PASSWORD=Mys3Cr3t --name java-maven-postgre didox/java-maven-postgre
# docker exec -it java-maven-postgre /bin/bash
# psql -U ilab -d apirest
# psql -U ilab -d apirest --password