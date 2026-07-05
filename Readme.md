 #E-Commerce Microservices Project
## Overview
A scalable e-commerce backend built using Spring Boot microservices architecture.
## Tech Stack
- Java
- Spring Boot
- Spring Cloud
- Eureka Server
- API Gateway
- MySQL
- Docker
- Maven
- REST APIs

## Microservices
- User Service
- Product Service
- Order Service
- Inventory Service

## Features
- User Registration & Login
- Product Management
- Order Placement
- Inventory Tracking
- Service Discovery
- API Gateway Routing
- Inter-Service Communication

## Architecture
```text
Client
   |
API Gateway
   |
--------------------------------
| User | Product | Order | Inventory |
--------------------------------
          |
     Eureka Server
