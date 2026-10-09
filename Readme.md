E-Commerce Microservices Project

Overview

A backend e-commerce application built using Java, Spring Boot, and Spring Cloud. The project follows a microservices architecture and incorporates service discovery, API Gateway routing, asynchronous messaging with Apache Kafka, and payment processing with Stripe.

Tech Stack

Language: Java

Framework: Spring Boot

Microservices: Spring Cloud

Service Discovery: Netflix Eureka

API Routing: Spring Cloud API Gateway

Inter-Service Communication: REST APIs and OpenFeign, where configured

Messaging: Apache Kafka

Payment Integration: Stripe API

Database: MySQL

ORM: Spring Data JPA / Hibernate, where used

Build Tool: Maven

Containerization: Docker

Microservices

Service

Responsibility

User Service

User registration and login

Product Service

Product management

Order Service

Order placement and order management

Inventory Service

Inventory tracking and stock management

Payment Service

Payment processing through Stripe

API Gateway

Entry point for routing client requests

Eureka Server

Service discovery and registration

Features

User registration and login

Product management

Order placement and management

Inventory tracking

Service discovery using Eureka

API Gateway routing

Inter-service communication

Asynchronous event messaging using Apache Kafka

Stripe payment integration

Centralized entry point for client requests

Architecture

flowchart TD
    Client[Client]
    Gateway[API Gateway]
    Eureka[Eureka Server]

    Gateway --> User[User Service]
    Gateway --> Product[Product Service]
    Gateway --> Order[Order Service]
    Gateway --> Payment[Payment Service]

    Order <--> Inventory[Inventory Service]
    Payment --> Stripe[Stripe API]

    User -. Registration .-> Eureka
    Product -. Registration .-> Eureka
    Order -. Registration .-> Eureka
    Inventory -. Registration .-> Eureka
    Payment -. Registration .-> Eureka

    Order <--> Kafka[Apache Kafka]
    Kafka <--> Inventory

Architecture note: Adjust the arrows and Kafka connections to match your actual implementation. The diagram is illustrative, not a claim that every connection is already configured.

Kafka Integration

Apache Kafka can be used for asynchronous communication between services.

Typical use cases include:

Publishing order events.

Consuming order events in inventory or other downstream services.

Reducing direct dependencies between services.

Document the actual topic names, producers, consumers, and event payloads from your implementation.

Stripe Payment Integration

Stripe is integrated with the Payment Service to support payment processing.

A typical PaymentIntent flow is:

The client initiates a payment request.

The Payment Service receives the request.

The backend creates a Stripe PaymentIntent.

Stripe returns the PaymentIntent details to the backend.

The client completes the payment using the appropriate Stripe client-side flow, if implemented.

Important: Creating a PaymentIntent alone does not confirm that a payment has succeeded. Document payment confirmation, webhooks, and order-status updates only if you have implemented them.

Getting Started

Prerequisites

JDK version compatible with the project

Maven

MySQL

Apache Kafka, if running the Kafka components

Docker, if using containerized services

Stripe test-mode API keys

Setup

Clone the repository.

Configure database connections in the relevant application configuration files.

Configure Eureka Server and API Gateway.

Configure Kafka broker details and topics if required.

Configure Stripe test-mode credentials using environment variables or a secure local configuration.

Build the services using Maven.

Start the infrastructure components and microservices according to their dependencies.

Test the APIs using Postman.

Never commit Stripe secret keys, database passwords, or other credentials to GitHub.

Testing

Add evidence from the actual application, such as:

Postman requests and responses

Successful and failed API scenarios

Kafka producer and consumer logs

Stripe test-mode payment results

Automated test results

Future Improvements

Potential improvements include:

Stripe webhook handling

Reliable order and payment status synchronization

Kafka retry and dead-letter handling

Automated integration tests

Docker Compose for local development

API documentation and centralized logging

List these as future improvements only when they are not yet implemented.
