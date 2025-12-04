# ----------- Étape 1 : Build Maven (construction du JAR) -----------
FROM maven:3.9.6-eclipse-temurin-17 AS builder

# Créer un dossier dans l'image
WORKDIR /app

# Copier pom.xml et télécharger les dépendances
COPY pom.xml .
RUN mvn dependency:go-offline -q

# Copier le code source
COPY src ./src

# Builder l'application
RUN mvn -q -e -DskipTests package


# ----------- Étape 2 : Image finale JRE légère -----------
FROM eclipse-temurin:17-jre

WORKDIR /app

# Copier uniquement le JAR depuis l'étape builder
COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8082

ENTRYPOINT ["java", "-jar", "app.jar"]
