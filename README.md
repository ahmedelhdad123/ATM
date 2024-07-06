# ATM System

This repository contains the implementation of a simple ATM system using Spring Boot. The system allows for creating accounts, depositing and withdrawing money, and querying account balances.

## Project Structure

### 1. Common
- **`AccountModel`**: A data model representing an account, used for transferring account data within the application. It includes fields like `userId`, `balance`, `name`, and `status`.

### 2. Exceptions
- **`AccountNotFountException`**: Custom exception thrown when an account is not found.
- **`AmountNotAllowException`**: Custom exception thrown when an invalid amount is provided for deposit or withdrawal.
- **`ApiException`**: A model for API exceptions, containing the error message and HTTP status.
- **`MyGlobalExceptionHandler`**: A global exception handler that catches custom exceptions and returns appropriate HTTP responses.

### 3. Repository
- **`Account`**: An entity representing an account in the database. It includes fields like `userId`, `name`, `balance`, and `status`.
- **`Status`**: An enum representing the status of an account (e.g., VIP, NOT_VIP).
- **`AtmRepo`**: A repository interface for performing CRUD operations on `Account` entities.

### 4. Service
- **`AtmService`**: An interface defining the service methods for ATM operations, such as creating accounts, retrieving accounts, depositing, and withdrawing money.
- **`AtmServiceImpl`**: An implementation of the `AtmService` interface, providing the business logic for ATM operations.

### 5. REST
- **`AtmResource`**: A REST controller exposing endpoints for ATM operations, such as creating accounts, retrieving all accounts, finding accounts by ID, depositing, withdrawing, and getting account balances.

## Endpoints

- **GET /atm/getAll**: Retrieve all accounts.
- **GET /atm/findByID/{userId}**: Retrieve an account by ID.
- **POST /atm/create**: Create a new account.
- **GET /atm/balance/{userId}**: Retrieve the balance of an account.
- **POST /atm/deposit**: Deposit money into an account.
- **POST /atm/withdraw**: Withdraw money from an account.

