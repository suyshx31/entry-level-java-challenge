# Employee Management API

This project is a Spring Boot REST API built for the ReliaQuest Entry-Level Java Challenge.

## Tech Stack
- Java
- Spring Boot
- Gradle
- Spring Security (Basic Auth)

## Features
- Retrieve all employees
- Retrieve employee by UUID
- Create new employee
- Input validation using annotations
- Basic authentication enabled

## How to Run
```bash
./gradlew bootRun
```

## Authentication

- Basic Auth is enabled.
- Username: user
- Password: Generated in console at runtime


## API Endpoints

- GET /api/v1/employee
  Returns all employees

- GET /api/v1/employee/{uuid}
  Returns a specific employee

- POST /api/v1/employee
  Creates a new employee

## Sample Request:

```json
{
  "firstName": "John",
  "lastName": "Doe",
  "salary": 50000,
  "age": 25,
  "jobTitle": "Developer",
  "email": "john.doe@company.com"
}
```

## Notes
- Uses in-memory storage for simplicity
- Can be extended with a database layer