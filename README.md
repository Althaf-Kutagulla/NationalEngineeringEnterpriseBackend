# National Engineering Enterprise Service

This repository contains the backend service for the **National Engineering Enterprise** project. Follow the instructions below to set up and run the application.

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

---

## Contribution Guidelines

This repository is public, and contributions are welcome. Follow these steps to contribute:

1. **Fork the Repository**: Create your own fork of this repository.
2. **Feature Branch**: Create a new feature branch based on the `dev` branch.
   ```bash
   git checkout -b feature/your-feature-name dev
   ```
3. **Pull Request**: Submit a pull request to the `dev` branch.  
   All pull requests require approval before being merged.

---

## Notes

- Ensure all environment variables are properly set before running the application.
- For any issues, feel free to open a discussion or submit an issue.
