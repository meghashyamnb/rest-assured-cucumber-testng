RestAssured API Testing Project

This is a hobby project for API testing using RestAssured and Java. The project is designed to automate API validation and provide structured test cases to ensure the correctness of various RESTful services.

Features

Automated API testing with RestAssured

Integration with JUnit/TestNG for structured test cases

JSON and XML response validation

Request and response logging for debugging

Data-driven testing support

Prerequisites

Java 11 or later

Maven (for dependency management)

An IDE (IntelliJ IDEA, Eclipse, or VS Code)

Internet access (to fetch dependencies from Maven repository)

Installation

Clone the repository:

git clone https://github.com/yourusername/restassured-api-testing.git
cd restassured-api-testing

Ensure Java and Maven are installed:

java -version
mvn -version

Build the project:

mvn clean install

Dependencies

This project uses the following dependencies:

<dependencies>
    <dependency>
        <groupId>io.rest-assured</groupId>
        <artifactId>rest-assured</artifactId>
        <version>5.4.0</version>
    </dependency>
    <dependency>
        <groupId>org.testng</groupId>
        <artifactId>testng</artifactId>
        <version>7.9.0</version>
        <scope>test</scope>
    </dependency>
</dependencies>

Project Structure

restassured-api-testing/


Running the Tests

You can run the tests using the following command:

mvn test

If using TestNG, you can also execute specific test suites using:

mvn clean test -DsuiteXmlFile=testng.xml

Sample Test Case

Here's a simple test case using RestAssured:

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class SampleApiTest {
    @Test
    public void testGetUsers() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        
        given()
            .when()
            .get("/users")
            .then()
            .statusCode(200)
            .body("size()", greaterThan(0));
    }
}

Contributing

Feel free to fork this repository and contribute by submitting a pull request.

License

This project is licensed under the MIT License - see the LICENSE file for details.
