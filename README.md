# 🌟 Employee Management API 🌟

## 📋 Table of Contents
- [📖 Overview](#-overview)
- [🚀 Features](#-features)
- [🛠️ Tech Stack](#️-tech-stack)
- [⚙️ Setup & Installation](#️-setup--installation)
- [📚 API Endpoints](#-api-endpoints)
- [🔍 Screenshots](#-screenshots)
- [🙌 Contribution](#-contribution)
- [📞 Contact](#-contact)

## 📖 Overview
Welcome to the Employee Management API! This application allows users to manage employee data, including creating, retrieving, updating, and deleting employee records. It provides a straightforward and efficient way to handle employee information.

## 🚀 Features
- 🌟 Create and manage employee records
- 📜 Retrieve a list of all employees
- 🔍 Retrieve an employee by ID
- ✏️ Update employee information
- 🗑️ Delete an employee record

## 🛠️ Tech Stack
- **Backend:** Spring Boot, Java
- **Dependencies:** Spring Web ,DevTools,Jpa,Mysql
- **Build Tool:** Maven

## ⚙️ Setup & Installation
### ⚔️ Prerequisites
- Java 17 or 21
- Maven

### Steps
1. **Clone the repository:**
    ```bash
    git clone https://github.com/boyene/EmployeeManagementAPI.git
    cd EmployeeManagementAPI
    ```

2. **Build the project:**
    ```bash
    mvn clean install
    ```

3. **Run the application:**
    ```bash
    mvn spring-boot:run
    ```

## 📚 API Endpoints

### 📜 Retrieve All Employees
- **URL:** `GET /api/v1/employees`
- **Example:**
    ```bash
     GET "http://localhost:9090/api/v1/employees"
    ```

### 🔍 Retrieve an Employee by ID
- **URL:** `GET /api/v1/employee/{id}`
- **Path Variables:**
  - `id`: Integer
- **Example:**
    ```bash
    GET "http://localhost:9090/api/v1/employee/1"
    ```

### ✏️ Update an Employee
- **URL:** `PUT /api/v1/employee/{id}`
- **Path Variables:**
  - `id`: Integer
- **Request Body:** EmployeeModel JSON
- **Example:**
    ```bash
     PUT "http://localhost:9090/api/v1/employee/1" -H "Content-Type: application/json" -d '{"id":1,"name":"John Smith","salary":55000}'
    ```

### 🛠️ Update Employee by One Column
- **URL:** `PATCH /api/v1/update/{id}`
- **Path Variables:**
  - `id`: Integer
- **Request Body:** EmployeeModel JSON (only fields to update)
- **Example:**
    ```bash
     PATCH "http://localhost:9090/api/v1/update/1" -H "Content-Type: application/json" -d '{"name":"John Smith"}'
    ```

### 🗑️ Delete an Employee
- **URL:** `DELETE /api/v1/employee/{id}`
- **Path Variables:**
  - `id`: Integer
- **Example:**
    ```bash
     DELETE "http://localhost:9090/api/v1/employee/1"
    ```

## 🔍 Screenshots
### Example : Using API GetAll Employees
![API Usage Example](https://res.cloudinary.com/dzmws75jp/image/upload/v1722797609/Screenshot_2024-08-05_002150_x9oprf.png)

## 🙌 Contribution
Contributions are welcome! Feel free to open issues or submit pull requests. Make sure to follow the contribution guidelines.

## 📞 Contact
For any inquiries or support, please reach out:
- 📧 Email: boyeneyellakrishna@gmail.com
