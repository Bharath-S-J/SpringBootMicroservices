# **Spring Boot Microservices**  
 
This repository contains the latest source code for a **Spring Boot Microservices** project.  

## **Project Overview**  

This project implements a microservices architecture with the following services:  

- **Product Service** (`8080`)  
- **Order Service** (`8081`)  
- **Inventory Service** (`8082`)  
- **Notification Service** (`8083`)  
- **API Gateway** (`9000`)  
- **Shop Frontend (Angular 18)** (`4200`)  

## **Tech Stack**  

The technologies used in this project:  

- **Spring Boot**  
- **Angular**  
- **MongoDB**  
- **MySQL**  
- **Kafka**  
- **Keycloak**  
- **Grafana Stack** (Prometheus, Grafana, Loki, and Tempo)  
- **API Gateway** (Spring Cloud Gateway MVC)  


## **How to Run the Frontend Application**  

### **Prerequisites**  

Ensure you have the following installed on your machine:  

- [Node.js](https://nodejs.org/)  
- [NPM](https://www.npmjs.com/)  
- [Angular CLI](https://angular.io/cli)  

### **Run the Frontend**  

```sh
cd frontend
npm install
npm run start
```  

📌 **Frontend URL:** `http://localhost:4200/`  

---

## **How to Run the Backend Services**  

### **Prerequisites**  

Ensure you have the following installed on your machine:  

- [Java 21](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html)  
- [Docker](https://www.docker.com/)  
- [IntelliJ IDEA](https://www.jetbrains.com/idea/)  

### **Build and Run Services**  

#### **Step 1: Build the Backend Services**  

Run the following command to build and package the backend services:  

```sh
mvn clean package
```  

#### **Step 2: Start the Backend Services**  

You can start each service **individually** using IntelliJ IDEA:  

1. Open the project in IntelliJ IDEA.  
2. Locate each microservice inside the `services/` folder.  
3. Run each service **one by one** using the IntelliJ **Run** button.  

---

## **Accessing the Services**  

### **API Gateway**  
📌 **URL:** `http://localhost:9000/`  

### **Microservices**  
| Service           | Port  | URL                         |  
|------------------|-------|----------------------------|  
| **Product**      | 8080  | `http://localhost:8080/`   |  
| **Order**        | 8081  | `http://localhost:8081/`   |  
| **Inventory**    | 8082  | `http://localhost:8082/`   |  
| **Notification** | 8083  | `http://localhost:8083/`   |  

### **Keycloak Admin Console**  
📌 **URL:** `http://localhost:8181/`  
- **Username:** admin  
- **Password:** admin  

### **Grafana Dashboards**  
📌 **URL:** `http://localhost:3000/`  
- **Username:** admin  
- **Password:** admin  

---

## **Project Insights**  

This project helped me understand:  
✅ **Microservices Architecture**  
✅ **Spring Boot Service Communication**  
✅ **Event-Driven Architecture (Kafka)**  
✅ **Authentication & Authorization (Keycloak)**  
✅ **Monitoring & Logging (Grafana, Prometheus, Loki)**  

---

