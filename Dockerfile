FROM mysql:latest
MAINTAINER Alexandre Pinheiro alexclemente1985@gmail.com
LABEL portal=TreinaWeb
LABEL curso=JDBC
COPY ./db/ /docker-entrypoint-initdb.d/
