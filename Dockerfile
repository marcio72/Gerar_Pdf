# Usa uma imagem oficial com Java 17
FROM eclipse-temurin:17-jdk

# Cria e define o diretório de trabalho
WORKDIR /app

# Copia o jar para dentro do container
COPY target/pdfgenerator.jar app.jar

# Expõe a porta que o Spring Boot usa
EXPOSE 8080

# Comando para rodar o app
ENTRYPOINT ["java", "-jar", "app.jar"]
