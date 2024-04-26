# Weather API Application

## Overview
The Weather API Application is a Spring Boot-based web service that provides endpoints for retrieving weather data using the RapidAPI service. It offers functionalities to fetch the index, status, forecast summary, and hourly forecast for a specific location.

## Table of Contents
- [Technology Stack](#technology-stack)
- [Dependencies](#dependencies)
- [Installation](#installation)
- [Configuration](#configuration)
- [Usage](#usage)
- [Monitoring and Logging](#monitoring-and-logging)

## Technology Stack
- **Java**: Programming language used for backend development.
- **Spring Boot**: Framework for building web applications.
- **RESTful API**: Architecture for designing networked applications.
- **JUnit** and **Mockito**: Testing frameworks for unit testing.

## Dependencies
- **Spring Boot Starter Web**: Starter for building web applications using Spring MVC.
- **Spring Boot Starter Test**: Starter for testing Spring Boot applications.
- **Spring Web**: Provides basic web support, including RestTemplate for consuming RESTful services.
- **JUnit 5**: Testing framework for Java applications.
- **Mockito**: Mocking framework for unit tests.

## Installation
1. Clone the repository.
2. Configure the RapidAPI key and host in the application properties file.
3. Build and run the application.
4. Access the defined endpoints to retrieve weather data.

## Configuration
- **API Key and Host Configuration**:
    - The API key and host for RapidAPI are configured in the application properties file.

## Usage
1. **Index Endpoint**
    - URL: `/rapid/index`
    - Method: `GET`
    - Description: Retrieves the index data from RapidAPI.

2. **Status Endpoint**
    - URL: `/rapid/status`
    - Method: `GET`
    - Description: Retrieves the status data from RapidAPI.

3. **Forecast Summary Endpoint**
    - URL: `/rapid/summary/{location}`
    - Method: `GET`
    - Description: Retrieves the forecast summary for a specific location.

4. **Hourly Forecast Endpoint**
    - URL: `/rapid/hourly/{location}`
    - Method: `GET`
    - Description: Retrieves the hourly forecast for a specific location.
    
## Monitoring and Logging
Have added logger and exception handling wherever necessary.