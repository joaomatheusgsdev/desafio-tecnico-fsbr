# Use uma imagem base oficial do Tomcat 9 com Java 8
FROM tomcat:9.0-jdk8-openjdk

# Adiciona as configura��es do Tomcat (se necess�rio)
# COPY ./conf/server.xml /usr/local/tomcat/conf/server.xml

# Adiciona a aplica��o WAR ao diret�rio webapps do Tomcat
COPY ./target/*.jar /usr/local/tomcat/webapps/desafiofsbr.jar

# Exponha a porta 8080 (porta padr�o do Tomcat)
EXPOSE 8080

# Comando para iniciar o Tomcat (n�o � necess�rio modificar, pois a imagem base j� inicia o Tomcat automaticamente)
CMD ["catalina.sh", "run"]