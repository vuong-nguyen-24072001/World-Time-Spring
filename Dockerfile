From tomcat:9.0
WORKDIR /usr/local/bin/worldtime
COPY ./target/worldtime-1.0.war /usr/local/tomcat/webapps/
CMD ["catalina.sh","run"]