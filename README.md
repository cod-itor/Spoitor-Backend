# Spoitor Backend

A modern, high-performance RESTful API backend service for user management built with **Spring Boot**, **MyBatis**, and **PostgreSQL**.

---

## 📋 Table of Contents

- [Overview](#-overview)
- [Key Features](#-key-features)
- [Tech Stack](#-tech-stack)
- [Project Architecture](#-project-architecture)
- [Database Schema](#-database-schema)
- [API Endpoints Reference](#-api-endpoints-reference)
- [Getting Started](#-getting-started)
  - [Prerequisites](#prerequisites)
  - [Database Setup](#database-setup)
  - [Configuration](#configuration)
  - [Build and Run](#build-and-run)
- [API Documentation (Swagger)](#-api-documentation-swagger)
- [Project Scripts](#-project-scripts)

---

## 🌟 Overview

**Spoitor Backend** serves as the core API service for managing user accounts and profiles. It leverages Spring Boot alongside MyBatis for SQL persistence, providing full CRUD functionality, offset pagination, standardized response encapsulation, and OpenAPI / Swagger UI integration.

---

## ✨ Key Features

- **Full User CRUD Operations**: Create, read, update, and delete user profiles.
- **Pagination Support**: Configurable offset-based pagination (`page`, `size`) for user listings.
- **Standardized API Response**: Uniform response wrapper (`ApiResponse<T>`) including status code, timestamp, success flags, and payload.
- **Custom SQL Mapping with MyBatis**: Explicit column-to-property result mappings with custom SQL queries.
- **Interactive API Documentation**: Embedded Swagger UI via SpringDoc OpenAPI.
- **Database Seeding**: Automatic schema generation (`schema.sql`) and sample data seeding (`data.sql`).

---

## 🛠 Tech Stack

| Technology | Version / Description |
| :--- | :--- |
| **Java** | 21 |
| **Spring Boot** | 4.0.3 (Spring Web MVC) |
| **Persistence / ORM** | MyBatis 4.0.1 (`mybatis-spring-boot-starter`) |
| **Database** | PostgreSQL |
| **API Documentation** | SpringDoc OpenAPI Starter WebMVC UI (v2.8.14) |
| **Utilities** | Project Lombok |
| **Build Tool** | Apache Maven |

---

## 📂 Project Architecture

```
Spoitor-Backend/
├── pom.xml
├── push.sh
├── src/
│   ├── main/
│   │   ├── java/com/example/spoitorreplacement/
│   │   │   ├── Config/
│   │   │   │   └── UserConfig.java
│   │   │   ├── Controller/
│   │   │   │   └── UserController.java
│   │   │   ├── Model/
│   │   │   │   ├── Entities/
│   │   │   │   │   └── User.java
│   │   │   │   ├── Request/
│   │   │   │   │   └── UserRequestDto.java
│   │   │   │   └── Response/
│   │   │   │       ├── ApiResponse.java
│   │   │   │       └── UserResponseDto.java
│   │   │   ├── Repository/
│   │   │   │   └── UserRepository.java
│   │   │   ├── Service/
│   │   │   │   ├── Impl/
│   │   │   │   │   └── UserServiceImpl.java
│   │   │   │   └── UserService.java
│   │   │   └── SpoitorReplacementApplication.java
│   │   └── resources/
│   │       ├── application.properties
│   │       ├── schema.sql
│   │       └── data.sql
│   └── test/
│       └── java/com/example/spoitorreplacement/
│           └── SpoitorReplacementApplicationTests.java
```

---

## 🗄 Database Schema

The application utilizes a `users` table defined as follows:

```sql
CREATE TABLE users (
    id BIGSERIAL PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    phone_number VARCHAR(20),
    country VARCHAR(100),
    city VARCHAR(100),
    address TEXT
);
```

---

## 📡 API Endpoints Reference

Base URL: `/api/v1/User`

| Method | Endpoint | Description | Request Body | Response |
| :--- | :--- | :--- | :--- | :--- |
| `GET` | `/api/v1/User` | Get paginated list of users | None (Query: `page`, `size`) | `ApiResponse<List<User>>` |
| `GET` | `/api/v1/User/{user-name}` | Retrieve user by username | None | `User` |
| `POST` | `/api/v1/User` | Create a new user | `UserRequestDto` (JSON) | `User` |
| `PUT` | `/api/v1/User/{user-name}` | Update an existing user | `UserRequestDto` (JSON) | `ApiResponse<User>` |
| `DELETE` | `/api/v1/User/{user-name}` | Delete user by username | None | `ApiResponse<String>` |

### Example Request Payloads

#### Create / Update User (`POST` / `PUT`)
```json
{
  "userName": "john_doe",
  "email": "john.doe@example.com",
  "password": "securePassword123",
  "firstName": "John",
  "lastName": "Doe",
  "phoneNumber": "012345678",
  "country": "USA",
  "city": "New York",
  "address": "123 Main Street"
}
```

#### Standard API Response Example (`GET /api/v1/User?page=1&size=2`)
```json
{
  "messages": "Fetched the Data",
  "payload": [
    {
      "userName": "john_doe",
      "email": "john.doe@example.com",
      "password": "password123",
      "firstName": "John",
      "lastName": "Doe",
      "phoneNumber": "012345678",
      "country": "USA",
      "city": "New York",
      "address": "123 Main Street"
    }
  ],
  "status": "OK",
  "success": true,
  "timestamp": "2026-08-29T08:00:00Z"
}
```

---

## 🚀 Getting Started

### Prerequisites
- **JDK 21** or later
- **Maven 3.8+**
- **PostgreSQL 14+**

### Database Setup
1. Ensure PostgreSQL is running on `localhost:5432`.
2. Create the target database (default: `postgres`).
3. Schema and initial seed data will automatically load from `schema.sql` and `data.sql` upon application startup (or can be executed manually).

### Configuration
Edit `src/main/resources/application.properties` to match your environment credentials:
```properties
spring.application.name=spoitorReplacement
spring.datasource.url=jdbc:postgresql://localhost:5432/postgres
spring.datasource.username=postgres
spring.datasource.password=your_password
```

### Build and Run

```bash
# Clone the repository
git clone <repo-url>
cd Spoitor-Backend

# Build the project
mvn clean package

# Run the application
mvn spring-boot:run
```

The application will start on port `8080` by default.

---

## 📖 API Documentation (Swagger)

Once the application is running, you can explore and test the endpoints interactively via Swagger UI:

- **Swagger UI**: [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)
- **OpenAPI JSON Docs**: [http://localhost:8080/v3/api-docs](http://localhost:8080/v3/api-docs)

---

## 📜 Project Scripts

- **`push.sh`**: Helper shell script for automated Git staging, committing, and pushing changes to GitHub.
