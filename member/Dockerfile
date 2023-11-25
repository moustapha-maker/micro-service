openjdk 17.0.8.1
# Utilisez une image de base avec Java
FROM openjdk:17.0.8.1

# Créez un répertoire pour l'application
WORKDIR /app

# Copiez le JAR de votre application dans le conteneur
COPY target/your-backend-app.jar /app/app.jar

# Exposez le port sur lequel votre application s'exécute
EXPOSE 8080

# Commande pour démarrer l'application lorsque le conteneur démarre
CMD ["java", "-jar", "app.jar"]

