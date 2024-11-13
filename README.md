# Quiz App

This is a monolithic Quiz application built with Spring Boot. It provides a structured backend for creating, retrieving, and submitting quizzes and managing questions through a set of REST APIs.

## Overview of Monolithic Architecture

In a **monolithic architecture**, all components of the application are tightly coupled and built as a single, unified unit. This structure includes:

- **Single Codebase**: All features, such as quiz creation, question management, and submission handling, are implemented in a single codebase.
- **Shared Resources**: The entire application shares resources, including a common database and server environment.
- **Single Deployment Unit**: The application is packaged and deployed as a single artifact (e.g., JAR or WAR file). This simplifies deployment but limits the flexibility to update specific modules independently.

### Benefits of a Monolithic Approach

- **Simplified Development and Testing**: A single codebase makes it straightforward to develop, test, and deploy.
- **Faster Initial Development**: Easier to start small projects with all functionality in one place.

### Drawbacks

- **Scalability Limitations**: Scaling the app requires replicating the entire codebase, which might not efficiently address specific bottlenecks.
- **Maintenance Challenges**: As the codebase grows, it becomes harder to maintain and update without impacting other features.

## How This Quiz App Follows a Monolithic Approach

This quiz app is designed as a monolithic application, with components such as **quiz management**, **question handling**, and **submission processing** all tightly coupled within a single Spring Boot application. Here's how it aligns with a monolithic structure:

- **Unified Codebase**: The entire functionality, from question creation to quiz submission, resides in a single Spring Boot project. All services, repositories, and controllers are in one codebase.

- **Single Database**: The app uses a single database to manage both questions and quizzes, making data consistency straightforward but limiting flexibility.

- **Single Deployment Artifact**: The app is packaged and deployed as a single JAR, meaning any update (e.g., to quiz functionality) requires redeploying the entire application.

## Features

- **Quiz Creation**: Generate quizzes with a specified category, number of questions, and title.
- **Question Management**: Add, retrieve, and filter questions by category.
- **Quiz Submissions**: Submit answers for a quiz and calculate results.

## Technologies

- **Java**
- **Spring Boot**
- **Spring Data JPA**
- **MYSQL Database** 
