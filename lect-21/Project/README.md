# Proxy Design Pattern – Java Implementation

This project demonstrates the Proxy Design Pattern in Java through a realistic document access scenario. The DocumentProxy class acts as a gatekeeper to the heavy RealDocument, implementing lazy loading, role-based access control, and logging.

Only users with roles like admin or editor can access the full document or print it, while viewers can only access metadata, and guests are denied access. The proxy ensures that the real document is loaded only once (using thread-safe double-checked locking) and reused via a caching mechanism (DocumentFactory). RealDocument is designed to be immutable, making it safe for concurrent reads.

This design showcases key proxy types: Virtual Proxy (lazy loading), Protection Proxy (access control), and Smart Proxy (logging). It also handles concurrency and object reuse efficiently.

To run the project, compile all Java files and execute Main.java to simulate access from different user roles.
