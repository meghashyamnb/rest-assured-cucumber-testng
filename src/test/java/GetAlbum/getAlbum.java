package GetAlbum;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.given;

import static org.testng.AssertJUnit.assertEquals;

public class getAlbum {


    @Test(description="Test")
    public static void TestModule(){

        RestAssured.given()
                .when()
                .get("https://api.spotify.com/v1")
                .then().assertThat().statusCode(200);

    }

    @Test(description = "Verify status code for GET method-users/2 as 200")
    public static void verifyStatusCodeGET() {
        // Sending GET request
        Response resp = RestAssured.given()
                .when()
                .get("https://reqres.in/api/users/2");

        // Debugging: Print response details
        System.out.println("Response: " + resp.asString());

        // Verify the status code using the StatusCode enum
        assertEquals(resp.getStatusCode(), StatusCode.OK.getCode(),
                "Expected status code does not match.");

        // Verify the `total` field if it exists
        String total = resp.path("total") != null ? resp.path("total").toString() : "Field not present";
        System.out.println("Total: " + total);

        AssertJUnit.assertEquals(total, "12",
                "Expected total does not match.");
    }

}
