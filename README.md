# Getting Started

The swagger can be used directly for tests.

http://localhost:8080/swagger-ui.html#/employee-controller`

The any account should be created firstly,

`curl -X POST "http://localhost:8080/api/employee/add" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"createdDate\": \"2021-08-04T18:18:22.705Z\", \"department\": \"string\", \"employeeSalary\": 0, \"id\": 0, \"lastModifiedDate\": \"2021-08-04T18:18:22.705Z\", \"officeLocation\": \"string\", \"userAge\": 0, \"userEmail\": \"string\", \"userName\": \"string\", \"userPhone\": \"string\", \"userSurname\": \"string\"}"`

The tests can be run anytime.

`mvn clean install`

### Reference Documentation

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.4.3/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.4.3/maven-plugin/reference/html/#build-image)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/2.4.3/reference/htmlsingle/#using-boot-devtools)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.4.3/reference/htmlsingle/#boot-features-developing-web-applications)

### Guides

The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)

