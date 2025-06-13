# Proxy Design Pattern – Java Implementation

This project demonstrates the Proxy Design Pattern in Java with real-world features like:

- ✅ Lazy loading
- ✅ Role-based access control (Protection Proxy)
- ✅ Logging (Smart Proxy)
- ✅ Thread-safe object creation
- ✅ Caching (Flyweight style)

---

## 📦 Project Structure

- `Document` – Interface
- `RealDocument` – Heavy object (real subject)
- `DocumentProxy` – Controls access to RealDocument
- `DocumentFactory` – Manages caching
- `Main` – Demo client

---

## ✅ Features

| Feature            | Description                                                  |
|--------------------|--------------------------------------------------------------|
| Lazy Initialization | RealDocument is loaded only when needed                     |
| Access Control      | Only certain roles can view/print documents                  |
| Thread-Safe         | Uses `volatile` + `synchronized` for safe lazy init          |
| Logging             | Tracks document access/denial                                |
| Caching             | Shared instances for repeated document requests              |

---

## 🧠 Roles & Permissions

| Role     | View Content | Print | View Metadata |
|----------|--------------|-------|----------------|
| admin    | ✅           | ✅    | ✅             |
| editor   | ✅           | ✅    | ✅             |
| viewer   | ❌           | ❌    | ✅             |
| guest    | ❌           | ❌    | ❌             |

---

## 🧪 Sample Usage

```java
Document doc1 = new DocumentProxy("Secrets.pdf", "Alice", "viewer");
Document doc2 = new DocumentProxy("Secrets.pdf", "Alice", "admin");

System.out.println(doc1.getMetadata());
doc1.displayContent(); // Access Denied

System.out.println(doc2.getMetadata());
doc2.displayContent(); // Loads and displays content
doc2.print();           // Prints document
```

---

## 🚀 How to Run

1. Compile:
   ```bash
   javac *.java
   ```
2. Run:
   ```bash
   java Main
   ```

---


