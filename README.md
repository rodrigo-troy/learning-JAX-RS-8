# Learning JAX-RS

This project showcases the development of a RESTful web service using JAX-RS and Java EE 8. It implements RESTful
endpoints with Jersey, ensures robust input validation through the Jakarta Bean Validation API, and features custom
error handling for improved user feedback. Detailed logging is achieved with Log4j2, while dependency injection is
seamlessly integrated using Weld. Furthermore, the project includes comprehensive API documentation powered by Swagger.
## Overview

The project includes:

- Creation of RESTful endpoints using **Jersey** (JAX-RS implementation).
- Validation of input data using **Jakarta Bean Validation API**.
- Handling of various exceptions and return of appropriate HTTP statuses with **Jersey**.
- Logging of request and response details using **Log4j2**.
- CDI integration for dependency injection using **Weld** (Jakarta CDI implementation).
- Documentation for API endpoints and usage examples using **Swagger**.

## Getting Started

### Prerequisites

- Java 8 or higher
- Maven

### Installing

Clone the repository:

```bash
git clone https://github.com/your-username/learning-jax-rs.git
cd learning-jax-rs
```

Build the project using Maven:

```bash
mvn clean install
```

### Running the Application

You can run the application using the following command:

```bash
mvn jetty:run
```

The application will be available at `http://localhost:8080/api`.

## Project Structure

### Domain

The domain package contains the classes representing the requests and responses for operations. The key classes include:

- `OperationRequest`: Represents a request for a mathematical operation.
- `OperationResponse`: Represents the response for a mathematical operation.

### Resources

The resources package contains the RESTful services. The key class is:

- `MathOperationResource`: Provides endpoints to perform mathematical operations.

### Configuration

The configuration class initializes the JAX-RS application:

- `RestResourceConfig`: Configures the application by specifying the package to scan for resources and settings for bean
  validation.

### Exception Handling

The exception package contains custom exception mappers to handle various exceptions and return appropriate responses:

- `ArithmeticExceptionMapper`
- `NullPointerExceptionMapper`
- `ConstraintViolationExceptionMapper`

### Logging

Logging is configured using Log4j2, and the configuration is provided in `log4j2.xml`. The log messages are color-coded
for different logging levels.

## Usage

#### Request

The request should be a JSON object containing `firstNumber`, `secondNumber`, and `operation`:

```json
{
  "firstNumber": 10,
  "secondNumber": 5,
  "operation": "ADD"
}
```

#### Response

The response will be a JSON object indicating success or failure and the result:

```json
{
  "isError": false,
  "message": "Success",
  "result": 15
}
```

## Contributing

Contributions are welcome! Please fork the repository and create a pull request with your changes.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## API Documentation

- [Swagger UI](http://localhost:8090/swagger-ui/index.html)
- [OpenAPI JSON](http://localhost:8090/api/openapi.json)
- [OpenAPI YAML](http://localhost:8090/api/openapi.yaml)
