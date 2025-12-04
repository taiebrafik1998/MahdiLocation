# Étape 1 : Build (compiler le code Java)
FROM maven:3.9.6-eclipse-temurin-17 AS builder

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn -q -e -DskipTests package


# Étape 2 : Exécution (image légère)
FROM eclipse-temurin:17-jre

WORKDIR /app

# Copier le .jar généré
COPY --from=builder /app/target/*.jar app.jar

# Exposer le port du service
EXPOSE 8081

# Lancer Spring Boot (les variables viennent du docker-compose)
ENTRYPOINT ["java", "-jar", "app.jar"]
