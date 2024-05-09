# Event-driven Banking Data Producer

## Introduction
The Event-driven Banking Data Producer is a Java-based application built with Spring Boot and Apache Kafka. It acts as a Kafka producer, generating data related to banking operations such as account information, customer details, account balances, and transactions. The application provides APIs for consuming and storing data in Kafka topics, dynamically creating topics for each model of data.

## Features
- **Data Generation**:
  - Generates data related to accounts, customers, balances, and transactions.
  - Provides realistic and customizable data for testing and simulation purposes.

- **Dynamic Topic Creation**:
  - Automatically creates Kafka topics for each model of data.
  - Ensures seamless integration with Kafka for efficient data streaming.

- **RESTful APIs**:
  - Exposes APIs for consuming and storing data in Kafka topics.
  - Supports various HTTP methods for interaction with the application.

## Technologies Used
- Java 8
- Spring Boot
- Apache Kafka
- RESTful APIs


## Usage
1. Access the provided APIs to consume and store data in Kafka topics.
2. Use appropriate endpoints to generate and retrieve data related to accounts, customers, balances, and transactions.
3. Data will be automatically stored in dynamically created Kafka topics for further processing or analysis.

## API Endpoints
- **POST /accounts**: Generate account data and store it in the corresponding Kafka topic.
- **POST /customers**: Generate customer data and store it in the corresponding Kafka topic.
- **POST /balances**: Generate balance data and store it in the corresponding Kafka topic.
- **POST /transactions**: Generate transaction data and store it in the corresponding Kafka topic.

## Kafka Topics
- **accounts_topic**: Stores data related to accounts.
- **customers_topic**: Stores data related to customers.
- **balances_topic**: Stores data related to balances.
- **transactions_topic**: Stores data related to transactions.



## Acknowledgements
- Spring Boot and Apache Kafka for providing robust frameworks for building event-driven applications.
- Open-source contributors for their valuable contributions.
  
