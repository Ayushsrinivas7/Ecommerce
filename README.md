# 📱 E-Commerce Backend – Mobile Store

A Spring Boot-based backend application for an e-commerce platform focused on selling mobile phones. It includes user authentication, product browsing, cart operations, order management, and a mock payment system.

---

## THanks :
Thanks to KK from appsforbharth for guiding in the project . 
----

## 🚀 Tech Stack

- *Java 17*
- *Spring Boot*
- *Spring Data JPA*
- *MySQL*
- *Lombok*
- *JWT Authentication* (mock-based)
Fully authenticated login via BYcript 

---

## ✨ Highlights

- ✅ *SOLID Principles* applied:
  - *S*ingle Responsibility – Cleanly separated service responsibilities.
  - *O*pen/Closed – Interfaces allow easy logic extension.
  - *I*nterface Segregation – Fine-grained service interfaces.
  - *D*ependency Inversion – Code depends on abstractions.



- 🔐 *Security and Clean Architecture*:
  - JWT-based (mock) login & token handling.
  - DTOs to protect database schema and validate inputs.
  - Layered architecture: Controller → Service → Repository.



---

## 🧰 Features Implemented

| Feature                 | Description                                                               |
|------------------------|---------------------------------------------------------------------------|
| ✅ User Registration    | Users can register with email & password                                  |
| ✅ User Login          | JWT-based authentication (mocked for simplicity)                          |
| ✅ Product Listing     | Browse available mobile phones (with pagination)                          |
| ✅ Product Detail      | View individual mobile phone details                                      |
| ✅ Cart Management     | Add, update, remove products from user cart                               |
| ✅ Order Creation      | Place order with mock payment option                                      |
| ✅ Order History       | View past orders (pagination supported)                                   |

---

## 📦 API Endpoints
## there still more apis end points used but these are the main ones .... 

### 🔐 Auth APIs

| Method | Endpoint         | Description              | Body / Params                         |
|--------|------------------|--------------------------|----------------------------------------|
| POST   | /api/auth/register | Register a new user     | { "email": "", "password": "" }     |
| POST   | /api/auth/login    | Login & receive token   | { "email": "", "password": "" }     |

---

### 📱 Product APIs

| Method | Endpoint              | Description                    | Params / Body                        |
|--------|-----------------------|--------------------------------|--------------------------------------|
| GET    | /api/products       | Get all products               | ?page=0&size=10 (optional)         |
| GET    | /api/products/{id}  | Get product details by ID      | —                                    |

---

### 🛒 Cart APIs

| Method | Endpoint               | Description                       | Body                                  |
|--------|------------------------|-----------------------------------|---------------------------------------|
| GET    | /api/cart            | Get current user cart             | —                                     |
| POST   | /api/cart/add        | Add item to cart                  | { "productId": 1, "quantity": 2 }   |
| PUT    | /api/cart/update     | Update quantity of cart item      | { "productId": 1, "quantity": 5 }   |
| DELETE | /api/cart/remove/{id}| Remove item from cart by ID       | —                                     |



---

### 📦 Order APIs

| Method | Endpoint              | Description                       | Body                                 |
|--------|-----------------------|-----------------------------------|--------------------------------------|
| POST   | /api/orders         | Place an order (mock payment)     | { "paymentType": "UPI" }           |
| GET    | /api/orders         | Get order history for user        | ?page=0&size=5 (optional)          |



---

## 🏗 Project Structure

```bash
src/
└── main/
    ├── java/com/example/ecommerce/
    │   ├── controller/         # REST API Controllers
    │   ├── dto/                # DTO classes for requests/responses
    │   ├── entity/             # JPA Entity definitions
    │   ├── repository/         # Spring Data JPA Repositories
    │   ├── service/            # Interfaces and service implementations
    │   ├── util/               # Utilities (e.g., PasswordHasher  utils)
    │   └── EcommerceApplication.java
    └── resources/
        ├── application.properties
        └── data.sql            # Seed data (optional)

