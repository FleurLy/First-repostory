# 🔐 Secure Email Analyzer

## 📌 Overview
**Secure Email Analyzer** is a full‑stack Spring Boot web application designed to detect **suspicious / phishing emails**.  
The project focuses on **security, clean architecture, and real‑world backend practices**, making it suitable for academic evaluation and junior backend job applications.

The application allows authenticated users to:
- Analyze email content
- Detect suspicious patterns using a scoring system
- View a personal history of analyses

---

## 🎯 Why this project matters
Email phishing is one of the **most common cybersecurity threats**. This project demonstrates:
- Secure authentication with Spring Security
- Backend business logic separation
- Persistent storage of security‑related data
- A scalable base for future AI / ML integration

---

## 🧠 Features

### 🔑 Authentication & Security
- User registration & login
- Password hashing with **BCrypt**
- Password strength validation
- Role‑based access control

### 📧 Email Analysis
- Keyword‑based detection engine
- Risk scoring system
- Explanation of detected risks (keywords)

### 🕓 History Tracking
- Each analysis is saved per user
- Private access to analysis history
- Sorted by most recent first

### 🧩 Clean Architecture
- MVC pattern
- DTOs for data transfer
- Service layer for business logic
- Repository layer with Spring Data JPA

---

## 🛠️ Tech Stack

**Backend**
- Java 21
- Spring Boot
- Spring MVC
- Spring Security
- Spring Data JPA
- Hibernate

**Frontend**
- Thymeleaf
- HTML5 / CSS

**Database**
- H2 (development)
- Easily replaceable with MySQL / PostgreSQL

---

## 📂 Project Structure

```
com.secureemailanalyzer
├── controller      # Web controllers (MVC)
├── service         # Business logic
├── repository      # Data access layer
├── entity / model  # JPA entities
├── dto             # Data transfer objects
├── security        # Spring Security configuration
└── SecureEmailAnalyzerApplication.java
```

---

## 🚀 How it works
1. User registers and logs in
2. Submits email content for analysis
3. Application computes a risk score
4. Result is displayed and saved
5. User can consult past analyses

---

## 📈 Possible Improvements
This project was intentionally built with extensibility in mind:
- Replace keyword logic with **ML / LLM‑based classification**
- Email header analysis
- URL reputation checks
- REST API version
- Dockerization

---

## 👨‍💻 What this project demonstrates to employers
- Solid understanding of **Spring Boot & Spring Security**
- Clean code and layered architecture
- Secure handling of user data
- Ability to design scalable backend systems
- Good software engineering practices

---

## 📝 Author
**Fatima**  
Backend / Java Developer (Junior)

---

## 📜 License
This project is for educational and demonstration purposes.


## 🧪 Lancer le projet en local

### Prérequis
- Java 21
- Maven 3.8+
- Git

### Étapes
```bash
# 1. Cloner le dépôt
git clone https://github.com/TON_USERNAME/secure-email-analyzer.git
cd secure-email-analyzer

# 2. Compiler le projet
mvn clean package

# 3. Lancer l’application
mvn spring-boot:run
```

L’application sera disponible à l’adresse :
👉 http://localhost:8080

---
