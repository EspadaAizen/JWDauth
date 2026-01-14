# RB Auth – Spring Boot JWT Authentication & Authorization

A **production‑ready Spring Boot backend** implementing **JWT‑based authentication** with **role‑based access control (RBAC)**. This project is designed following **real‑world backend practices** and is suitable for deployment, extension, and client delivery.

---

## 🚀 Key Highlights

* Secure **JWT Authentication** (Stateless)
* **Role‑Based Authorization** (USER / MANAGER / ADMIN)
* Password encryption using **BCrypt**
* Clean layered architecture (Controller, Service, Repository)
* Environment‑based configuration (no secrets in code)
* MySQL + JPA (Hibernate)
* Spring Security 6 (Spring Boot 3)

---

## 🧱 Tech Stack

* **Java 17**
* **Spring Boot 3.x**
* **Spring Security**
* **JWT (JSON Web Tokens)**
* **MySQL**
* **Hibernate / JPA**
* **Maven**

---

## 📁 Project Structure

```
rbAuth
├── src/main/java/com/projects/rbAuth
│   ├── config        # Security & JWT configuration
│   ├── controller    # REST controllers
│   ├── dto           # Request / Response DTOs
│   ├── entity        # JPA entities
│   ├── repository    # Data access layer
│   └── RbAuthApplication.java
│
├── src/main/resources
│   └── application.properties
│
├── .gitignore
├── pom.xml
└── README.md
```

---

## 🔐 Authentication Flow

1. User registers with a role (USER / MANAGER / ADMIN)
2. Password is encrypted and stored securely
3. User logs in with credentials
4. Server issues a **JWT token**
5. Token is sent in `Authorization` header for protected routes

---

## 🔑 Roles & Access Control

| Role    | Access        |
| ------- | ------------- |
| USER    | `/user/**`    |
| MANAGER | `/manager/**` |
| ADMIN   | `/admin/**`   |

Access is enforced using **Spring Security + JWT filter**.

---

## 🌍 Environment Variables (Required)

This project uses **environment variables** to keep sensitive data secure.

| Variable       | Description                    |
| -------------- | ------------------------------ |
| DB_URL         | MySQL JDBC URL                 |
| DB_USERNAME    | Database username              |
| DB_PASSWORD    | Database password              |
| JWT_SECRET     | Secret key for JWT signing     |
| JWT_EXPIRATION | Token validity in milliseconds |

### Example

```text
DB_URL=jdbc:mysql://localhost:3306/rb_auth
DB_USERNAME=root
DB_PASSWORD=your_password
JWT_SECRET=super_secret_key_123456
JWT_EXPIRATION=86400000
```

---

## ▶️ Run Locally

### Prerequisites

* Java 17+
* MySQL
* Maven

### Run

```bash
mvn spring-boot:run
```

Application will start at:

```
http://localhost:8080
```

---

## 📡 API Endpoints

### Auth

* `POST /auth/register` – Register user with role
* `POST /auth/login` – Login & receive JWT

### Protected Routes

* `GET /user/hello`
* `GET /manager/hello`
* `GET /admin/hello`

JWT must be sent as:

```
Authorization: Bearer <token>
```

---

## 🧪 Example cURL Test

```bash
curl -X POST http://localhost:8080/auth/login \
  -H "Content-Type: application/json" \
  -d '{
    "username": "user1",
    "password": "password123"
  }'
```

---

## 🔒 Security Best Practices Followed

* No credentials committed to GitHub
* Stateless authentication (JWT)
* BCrypt password hashing
* Role‑based endpoint protection
* Clean separation of concerns

---

## 🧩 Use Cases

* Authentication microservice
* Backend for web/mobile apps
* SaaS user management
* Enterprise RBAC systems

---

## 📌 Future Enhancements

* Refresh tokens
* Swagger / OpenAPI documentation
* Docker & Docker Compose
* OAuth2 integration
* Global exception handling

---

## 👨‍💻 Author

**Mayuresh Jadhav**
Backend Developer | Java | Spring Boot

---

## 📄 License

This project is open‑source and available for learning, extension, and production use.
