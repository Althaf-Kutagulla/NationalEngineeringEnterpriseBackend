# National Engineering Enterprise Service

This repository contains the backend service for the **National Engineering Enterprise** project, which helps businesses that provide repair services for motors used in bore wells to dig water. The system tracks customers, products, motors, different product categories, and the repair services provided to motors for specific customers.

---

## Project Overview

This monolithic project includes the following modules:

- **Customer Management**: APIs to manage customer details.
- **Worker Management**: APIs to manage worker details who provide the repair services.
- **Product Management**: APIs to manage products, including those used for motor repairs.
- **Motor Management**: APIs to manage motor details and track their condition.
- **Category Management**: APIs to manage product categories related to motors and repair services.

### Yet to Implement:
- **Motor Repair Ticket Management**: APIs to manage motor repair tickets for specific customer requests.
- **Security for APIs**: Security implementation to protect the APIs and restrict unauthorized access.

---

## Prerequisites

Before running the application, ensure you have the following:

- **Java 17** installed on your system.
- **MySQL RDBMS software** (MySQL Workbench recommended).

---

## Setup Instructions

1. **Use Java 17**  
   Ensure Java 17 is installed and set as the default Java version.  
   Check the version using:
   ```bash
   java -version
   ```

2. **Database Setup**  
   - Copy the MySQL script located at `resources/sql/intial_data.sql`.  
   - Run the script manually in your MySQL RDBMS software (e.g., MySQL Workbench) to initialize the database.

3. **Environment Variables**  
   Set the following environment variables for connecting to the SQL database:  
   - `JDBC_DATABASE_USERNAME`: Your database username.  
   - `JDBC_DATABASE_PASSWORD`: Your database password.  
   - `JDBC_DATABASE_URL`: The connection URL for your MySQL database (e.g., `jdbc:mysql://localhost:3306/your_database`).  

   ### Example:
   - **Linux/macOS**:  
     Add these lines to your terminal or `.bashrc`/`.zshrc` file:
     ```bash
     export JDBC_DATABASE_USERNAME=your_username
     export JDBC_DATABASE_PASSWORD=your_password
     export JDBC_DATABASE_URL=jdbc:mysql://localhost:3306/your_database
     ```
   - **Windows**:  
     Add these in the Command Prompt or system environment variables:
     ```cmd
     set JDBC_DATABASE_USERNAME=your_username
     set JDBC_DATABASE_PASSWORD=your_password
     set JDBC_DATABASE_URL=jdbc:mysql://localhost:3306/your_database
     ```

4. **Spring Boot Configuration**  
   Ensure the `application.yml` file is configured to use the environment variables:
   ```yaml
   spring:
     application:
       name: NationalEngineeringEnterpriseService
     datasource:
       username: ${JDBC_DATABASE_USERNAME}
       password: ${JDBC_DATABASE_PASSWORD}
       url: ${JDBC_DATABASE_URL}
   ```
5. **Postman Collection for APIs**
   find NationalEngineeringEnterprise.postman_collection file inside resources/postman-collection-APIs.
   Import it to postman to call APIs

---

## API Endpoints

Currently, the following API endpoints have been implemented:

### 1. **Customer APIs**
   - For managing customer details like name, contact, and address.

### 2. **Product APIs**
   - For managing products used in motor repairs.

### 3. **Category APIs**
   - For managing product categories related to motors and repairs.

### 4. **Motor APIs**
   - For managing motors, including motor details like type, model, and maintenance status.

### 5. **Worker APIs**
   - For managing workers who provide the repair services.

### Yet to Implement:
- **Motor Repair Ticket APIs**: APIs to manage motor repair tickets for customer requests.
- **Security APIs**: Implement security measures for API access control.

---

## Contribution Guidelines

This repository is public, and contributions are welcome. Follow these steps to contribute:

1. **Feature Branch**: Create a new feature branch based on the `dev` branch.
   ```bash
   git checkout -b feature/your-feature-name dev
   ```
2. **Pull Request**: Submit a pull request to the `dev` branch.  
   All pull requests require approval before being merged.

---

## Notes

- Ensure all environment variables are properly set before running the application.
- For any issues, feel free to open a discussion or submit an issue.

--- 
