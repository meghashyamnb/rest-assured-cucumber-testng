package org.example.utils;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class TokenManager {

    private static String clientId = "a2a2483e48084ce7bdaf366316a7cebf";
    private static String clientSecret = "5a7677031fdb4a768ed111db93a4140c";
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

