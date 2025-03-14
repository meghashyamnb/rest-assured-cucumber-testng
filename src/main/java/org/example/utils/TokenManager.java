package org.example.utils;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class TokenManager {

    private static String clientId = "";
    private static String clientSecret = "";
    private static String token;

    public static String getToken() {
        if (token == null) {
            generateToken();
        }
        return token;
    }

    private static void generateToken() {
        Response response = given()
                .header("Content-Type", "application/x-www-form-urlencoded")
                .formParam("grant_type", "client_credentials")
                .formParam("client_id", clientId)
                .formParam("client_secret", clientSecret)
                .post("https://accounts.spotify.com/api/token");

        token = response.jsonPath().getString("access_token");
    }
}

