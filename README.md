# Customer Insurance Management Tool

1. [About](#about)
2. [Prerequisites](#prerequisites)
3. [Install Dependencies](#dependencies)
4. [API Documentation](#documentation)
5. [Tech Stack](#techstack)

## About<a name="about"></a>

RESTful API for managing customers and related insurance quotations & subscriptions.

This project was built as a part of backend Java developer interview process for backend Java developer position.

## Prerequisites<a name="prerequisites"></a>
* Java 17
* Postman - for API calls

## Install Dependencies<a name="dependencies"></a>
```shell
mvn install
```

### Run and Test the Application
Clone the repository to your local machine and run the application with the following command:

```shell
mvn spring-boot:run
```
#### Viewing Database Data
* Dummy data are automatically seeded into an in-memory database (H2). If you wish to view the data in a console, open your browser and navigate to **localhost:8080/h2-console**

* When the console GUI loads, leave everything the way it is, and make sure that the **JDBC URL** value is set to: **jdbc:h2:mem:test** and click "Connect"

#### Trying API Calls
To test the application endpoints, open the Postman app on your machine and send GET request to **localhost:8080/customers**. By doing so, you can view all customers currently saved in the database.

## Documentation<a name="documentation"></a>
To view API documentation, run the app locally and navigate to **http://localhost:8080/swagger-ui/index.html#/**

## Tech Stack and Tools Used<a name="techstack"></a>
### Tech Stack
* Java 17
* Spring Boot 3
* Maven
* Spring Data JPA
* Hibernate
* H2
* OpenAPI
* Mockito
