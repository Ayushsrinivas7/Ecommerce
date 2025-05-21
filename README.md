# 📱 E-Commerce Backend – Mobile Store - for apps for bharth 

A Spring Boot-based backend application for an e-commerce website that sells mobile phones online. This backend supports user account management, product listing, cart management, order processing, and mock payment functionality.



---

## 🚀 Tech Stack

- *Java 17*
- *Spring Boot*
- *Spring Data JPA*
- *MySQL*
- *Lombok*
- *JWT Authentication*  (Mock for login)


---

## 🧰 Features Implemented

| Feature                 | Description                                                                 |
|------------------------|-----------------------------------------------------------------------------|
| User Registration      | New users can register with a user ID, password, and email                  |
| User Login             | JWT-based login system (mock implementation)   Hash                             |
| Product Listing        | List all available mobile phones with pagination support                    |
| Product Detail         | View detailed information of a specific product                             |
| Cart Management        | Add, remove, update products in the cart                                    |
| Order Creation         | Place orders                                    |
| Order History          | Authenticated users can view their order history (with pagination)          |

## Highlights 

All the codes are written following the solid priciples and maintined the security to prevent attacs like sql injection  
---

## 🏗 Project Structure

```bash
src/
└── main/
    ├── java/com/example/ecommerce/
    │   ├── controller/         # REST Controllers
    │   ├── dto/                # Data Transfer Objects
    │   ├── entity/             # JPA Entities
    │   ├── repository/         # Spring Data Repositories
    │   ├── service/            # Service Interfaces & Business Logic
    │   ├── util/               # Utility classes 
    │   └── EcommerceApplication.java  # Main Spring Boot app
    └── resources/
        ├── application.properties
      
