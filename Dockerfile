FROM tomcat:9.0

ADD . /code
WORKDIR /code
COPY target/*.jar $CATALINA_HOME/webapps/
EXPOSE 8888:8080