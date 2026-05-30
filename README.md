# To-Do Task Manager

To-Do Task Manager is a full-stack web application developed using Java, Spring Boot, Thymeleaf, and MySQL. The application enables users to manage their daily tasks efficiently by providing secure authentication and personalized task management features.

Each user can register, log in, and manage their own tasks. The application supports creating, updating, deleting, and tracking task completion status along with due date and time management.

---

## Live Demo
https://todo-task-manager-o3xk.onrender.com

---

# Features

# User Management

* User Registration
* User Login Authentication
* Session Management
* Secure Logout Functionality
* Email-based User Validation

### Task Management

* Create New Tasks
* View Personal Tasks
* Edit Existing Tasks
* Delete Tasks
* Mark Tasks as Pending or Completed
* Due Date and Time Tracking
* User-Specific Task Access

### User Interface

* Responsive Design using Bootstrap
* Clean Dashboard Layout
* Welcome Message with Username
* Confirmation Before Deleting Tasks
* Status-Based Task Visualization

---

## Technology Stack

### Backend

* Java 21
* Spring Boot
* Spring MVC
* Spring Data JPA
* Hibernate

### Frontend

* Thymeleaf
* HTML5
* CSS3

### Database

* MySQL

### Build Tool

* Maven

### Deployment

* Render Cloud Platform

### Version Control

* Git
* GitHub

---

## Project Architecture

The application follows the MVC (Model-View-Controller) architecture.

### Model Layer

Contains entity classes:

* User
* Todo

### Repository Layer

Handles database operations using Spring Data JPA:

* UserRepository
* TodoRepository

### Service Layer

Contains business logic:

* UserService
* TodoService

### Controller Layer

Handles HTTP requests and responses:

* AuthController
* TodoController

### View Layer

Built using Thymeleaf templates:

* login.html
* register.html
* todos.html
* add-todo.html
* edit-todo.html

---

## Application Workflow

### Registration Flow

1. User enters registration details.
2. Application validates email uniqueness.
3. User information is stored in the database.
4. User is redirected to Login Page.

### Login Flow

1. User enters email and password.
2. Credentials are validated.
3. User session is created.
4. User is redirected to Task Dashboard.

### Task Management Flow

1. User creates a task.
2. Task is associated with the logged-in user.
3. User can update or delete only their own tasks.
4. Task status can be updated to Completed or Pending.

---

## Author

Roumya Ranjan Biswal

Full Stack Java Developer

GitHub:
https://github.com/roumya-ranjan
