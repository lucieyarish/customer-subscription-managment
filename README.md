# Customer Insurance Managment Tool

1. [About](#about)
2. [Prerequisites](#prerequisites)
3. [Install Dependencies](#dependencies)
4. [Tech Stack](#techstack)

## About<a name="about"></a>

RESTful API for managing customers and related insurance quotations & subscriptions.

This project was built as a part of backend Java developer interview process for backend Java developer position.

## Prerequisites<a name="prerequisites"></a>
* Java 17

## Install Dependencies<a name="dependencies"></a>
```shell
mvn install
```

### Run and Test the Application
Clone the repository to your local machine and run the application with the following command:

```shell
mvn spring-boot:run
```

Dummy data are automatically seeded into an in-memory database (H2). If you wish to view the data in a console, open your browser and navigate to **localhost:8080/h2-console**

When the console GUI loads, leave everything the way it is and make sure that the **JDBC URL** is set to the following value: jdbc:h2:mem:test

To test the application, open the Postman app on your machine, paste the JSON sample data below to the request body and send GET request to **localhost:8080/customers**. By doing so, you can view all customers currently saved in the database.

## Tech Stack and Tools Used<a name="techstack"></a>
### Tech Stack
* Java 17
* Spring Boot 3
* Maven
* Spring Data JPA
* Hibernate
* Jakarta Bean Validation API
* H2
* Swagger
