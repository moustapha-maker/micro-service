# Utilisez une image de base avec Java
FROM openjdk:17-jdk

# Créez un répertoire pour l'application
WORKDIR /app

# Copiez le JAR de votre application dans le conteneur
ADD target/*.jar app.jar

# Exposez le port sur lequel votre application s'exécute
EXPOSE 8080

# Commande pour démarrer l'application lorsque le conteneur démarre
CMD ["java", "-jar", "/app/app.jar"]
