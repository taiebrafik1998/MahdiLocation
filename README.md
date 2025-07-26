# 🏠 Locataire Service

Microservice de gestion des locataires pour l'application **GestionDeLocataire**, développé en **Java Spring Boot** avec une architecture **microservices**.

---

## 🚀 Fonctionnalités prévues

- CRUD des locataires (ajout, modification, suppression, consultation)
- Lien futur avec les logements et les paiements
- Architecture extensible (RabbitMQ, sécurité, monitoring à venir)

---

## ⚙️ Stack technique

| Composant       | Technologie         |
|------------------|----------------------|
| Backend          | Java 17 + Spring Boot 3.5.3 |
| ORM / DB Access  | Spring Data JPA     |
| Base de données  | PostgreSQL (via Docker) |
| Config. env.     | `.env` + `application.properties` |
| Conteneurisation | Docker + Docker Compose |
| Profil actif     | `dev` (via Spring Profiles) |

---

## 📁 Arborescence simplifiée

```
locataire-service/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/gestiondelocataire/...
│       └── resources/
│           ├── application.properties
│           ├── application-dev.properties
├── .env
├── docker-compose.yml
├── pom.xml
└── README.md
```

---

## ✅ Pré-requis

- Java 17 installé
- Maven ou wrapper (`./mvnw`)
- Docker & Docker Compose
- IDE (VS Code ou IntelliJ recommandé)

---

## ▶️ Lancer le projet en local

### 1. Cloner le repo et se placer dans le dossier
```bash
git clone <lien_du_repo>
cd locataire-service
```

### 2. Lancer PostgreSQL avec Docker
```bash
docker-compose --env-file .env up -d
```

### 3. Démarrer l’application avec le profil `dev`
```bash
# Sous PowerShell (Windows)
$env:SPRING_PROFILES_ACTIVE="dev"; ./mvnw spring-boot:run

# OU avec variable dans .env
./mvnw spring-boot:run
```

---

## 🔐 Fichier `.env` (exemple)

```env
SPRING_PROFILES_ACTIVE=dev
SPRING_PORT=8081

DB_HOST=localhost
POSTGRES_PORT=5433
POSTGRES_DB=locataires
POSTGRES_USER=loc_user
POSTGRES_PASSWORD=loc_pass
```

---

## 📌 Notes

- Le service démarre sur [http://localhost:8081](http://localhost:8081)
- Aucun endpoint actif par défaut tant que les entités ne sont pas créées
- Les requêtes SQL sont visibles dans la console grâce à `show-sql=true`

---

## ✍️ Auteur

Rafik Taieb  
Développeur Full Stack / Java / DevOps  
📧 rafik.t.contact@gmail.com  
🌐 [LinkedIn](https://www.linkedin.com/in/rafik-taieb/) _(à personnaliser si besoin)_
