
FROM openjdk:11-jdk-slim

# Définir le répertoire de travail
WORKDIR /app

# Copier le fichier jar Spring Boot dans le conteneur
COPY target/*.jar app.jar 

# Exposer le port 8080 pour accéder à l'application
EXPOSE 8090

# Définir les options de démarrage de l'application
ENTRYPOINT ["java","-jar","app.jar"]

