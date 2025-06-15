
# 🔗 Chain of Responsibility - Low Level System Design in Java

This project demonstrates the **Chain of Responsibility Design Pattern** using a real-world inspired use-case of processing HTTP requests in a backend system.

> This is ideal for practicing **Low-Level Design (LLD)** concepts like handler chaining, separation of concerns, and system extensibility.

---

## 📌 Problem Statement

Simulate a backend system that processes incoming API requests with the following pipeline:

1. **Authentication**
2. **Rate Limiting**
3. **Logging**
4. **Business Logic Execution (Controller)**

Each stage is represented by a handler in a chain, implementing the **Chain of Responsibility Pattern**.

---

## 🛠️ Tech Stack

- Java (OOP + Polymorphism)
- No external dependencies
- Console-based simulation

---

## 🧱 Functional Requirements

- ✅ A request must go through authentication
- ✅ Authenticated users should be rate-limited to `N` requests
- ✅ All accepted requests should be logged
- ✅ Final processing should return a simulated `200 OK` or error if blocked

---

## 🚫 Non-Functional Requirements

- 📦 Modular and extendable
- 🔍 Easy to plug/unplug middleware (handlers)
- 📈 High cohesion, low coupling (SOLID principles)
- 🧪 Easy to unit test each component independently

---

## 🧠 Design Overview

### 📐 Pattern Used:
**Chain of Responsibility**

### 👇 Request Flow:
```

Request
↓
AuthHandler 🔐
↓
RateLimiterHandler 🚦
↓
LoggerHandler 📋
↓
ControllerHandler 🧠
↓
Response

```

---

## 🧪 Sample Output

```

Request #1
AuthHandler: Authenticated user User01
RateLimiterHandler: User User01 request #1
LoggerHandler: Received request for /user
ControllerHandler: Handling business logic for user User01 at /user
LoggerHandler: User: User01, Endpoint: /user, Method: get, Status: 200
Final Response: 200 : OK

...

Request #5
AuthHandler: Authenticated user User01
RateLimiterHandler: User User01 exceeded limit!
Final Response: 429 : Too Many Requests

```



## 💡 Extensibility Ideas

- 🧰 Add `CachingHandler` for GETs
- 🔄 Add `RetryHandler` for failed requests
- 📉 Add `MetricsHandler` to collect metrics
- 🧪 Add `ValidationHandler` for schema validation
---
> Made with ❤️ by Tushar Pal for mastering LLD and system interaction clarity.
> 
