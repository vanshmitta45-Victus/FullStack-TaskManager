# 🚀 Full-Stack Task Management System (Quality-Driven)

A professional, end-to-end Task Management application designed to demonstrate a hybrid skill set of **Full-Stack Development** and **QA Automation Engineering**. This project focuses on scalability, maintainability, and high code quality.

## 🛠️ Tech Stack

### **Backend (The Brain)**
- **Language:** Java 17
- **Framework:** Spring Boot
- **Database:** PostgreSQL
- **API:** RESTful Architecture
- **ORM:** Spring Data JPA / Hibernate

### **Frontend (The Face)**
- **Library:** React.js
- **Build Tool:** Vite
- **Styling:** CSS3 (Custom Professional Styling)
- **HTTP Client:** Axios

### **QA Automation (The Guard)**
- **Framework:** Selenium WebDriver
- **Language:** Java
- **Test Runner:** TestNG
- **Design Pattern:** Page Object Model (POM)
- **Wait Strategy:** Explicit Waits (WebDriverWait) for asynchronous React rendering

---

## 📐 Architecture & Design Decisions

### **1. The Controller-Service-Repository Pattern**
The backend follows a strict layered architecture to ensure separation of concerns:
- **Controller Layer:** Handles HTTP requests and defines API endpoints.
- **Service Layer:** Contains the core business logic and validation.
- **Repository Layer:** Manages direct communication with the PostgreSQL database.

### **2. Page Object Model (POM) in Automation**
To avoid "flaky tests" and reduce maintenance, I implemented the **Page Object Model**. 
- **Locators** are separated from **Test Logic**. If the UI changes, I only update the Page class, not every single test script.
- **Explicit Waits** were used instead of hard sleeps to handle React's virtual DOM updates, ensuring 100% test stability.

### **3. Cross-Origin Resource Sharing (CORS)**
Implemented a security configuration in Spring Boot to allow secure communication between the React frontend (Port 5173) and the Java backend (Port 8080).

---

## 🚀 How to Run the Project

### **Backend**
1. Clone the repo.
2. Configure `src/main/resources/application.properties` with your PostgreSQL credentials.
3. Run `TaskManagerApplication.java` in IntelliJ IDEA.

### **Frontend**
1. Navigate to the frontend folder: `cd taskmanager-frontend`
2. Install dependencies: `npm install`
3. Start the development server: `npm run dev`

### **Automation**
1. Ensure both Backend and Frontend are running.
2. Open the `taskmanager-automation` project in IntelliJ.
3. Run `TaskAutomationTest.java` as a TestNG test.

---

## 📈 Key Learning Outcomes
- **End-to-End Integration:** Integrated a Java backend with a React frontend and a PostgreSQL database.
- **Automation Framework Design:** Built a maintainable automation suite from scratch using industry-standard design patterns (POM).
- **DevOps Workflow:** Implemented a CI/CD pipeline via GitHub Actions to automate the build and testing lifecycle.
- **Asynchronous Testing:** Solved complex synchronization issues between Selenium and Modern JS Frameworks using Explicit Waits.
