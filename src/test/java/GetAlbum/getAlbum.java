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




}
