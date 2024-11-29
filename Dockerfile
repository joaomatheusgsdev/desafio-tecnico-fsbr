# Use uma imagem base oficial do Tomcat 9 com Java 8
FROM tomcat:9.0-jdk8-openjdk

# Adiciona as configurações do Tomcat (se necessário)
# COPY ./conf/server.xml /usr/local/tomcat/conf/server.xml

# Adiciona a aplicação WAR ao diretório webapps do Tomcat
COPY ./target/*.jar /usr/local/tomcat/webapps/desafiofsbr.jar

# Exponha a porta 8080 (porta padrão do Tomcat)
EXPOSE 8080

# Comando para iniciar o Tomcat (não é necessário modificar, pois a imagem base já inicia o Tomcat automaticamente)
CMD ["catalina.sh", "run"]