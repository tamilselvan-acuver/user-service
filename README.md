# User Service

User Service is a Spring Boot application that provides REST APIs to manage users.
It supports full CRUD operations with a clean layered architecture.

## Features
- Create, Read, Update, Delete (CRUD) users
- RESTful APIs
- PostgreSQL database integration
- Global exception handling
- Clean and maintainable code structure

## Tech Stack
- Java 21
- Spring Boot
- Spring Web
- Spring Data JPA
- PostgreSQL
- Maven

## Project Structure
- controller : REST API layer
- service : Business logic
- repository : Database access (JPA)
- entity : JPA entities
- exception : Custom exceptions and global handler

## API Endpoints
- POST /users
- GET /users
- GET /users/{id}
- PUT /users/{id}
- DELETE /users/{id}
