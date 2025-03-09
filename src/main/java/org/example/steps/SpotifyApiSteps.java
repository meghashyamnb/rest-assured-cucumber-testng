package org.example.steps;

import org.example.utils.TokenManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class SpotifyApiSteps {

    private Response albumResponse;
    private Response artistResponse;
    private Response multipleAlbumsResponse;

    @Given("I have a valid access token")
    public void i_have_a_valid_access_token() {
        RestAssured.baseURI = "https://api.spotify.com/v1";
    }

    @When("I request album details with ID {string}")
    public void i_request_album_details_with_id(String albumId) {
        String accessToken = TokenManager.getToken();
        albumResponse = given()
                .header("Authorization", "Bearer " + accessToken)
                .get("/albums/" + albumId);
    }

    @Then("I should receive album details")
    public void i_should_receive_album_details() {
        assertEquals(200, albumResponse.getStatusCode());
        String albumName = albumResponse.jsonPath().getString("name");
        assertNotNull(albumName);
        System.out.println("Album Name: " + albumName);


    }

    @When("I request artist details with ID {string}")
    public void i_request_artist_details_with_id(String artistId) {
        String accessToken = TokenManager.getToken();
        artistResponse = given()
                .header("Authorization", "Bearer " + accessToken)
                .get("/artists/" + artistId);
    }

    @Then("I should receive artist details")
    public void i_should_receive_artist_details() {
        assertEquals(200, artistResponse.getStatusCode());
        String artistName = artistResponse.jsonPath().getString("name");
        assertNotNull(artistName);
        System.out.println("Artist Name: " + artistName);
    }
    @When("I request multiple albums details with IDs {string}")
    public void i_request_multiple_albums_details_with_ids(String albumIds) {
        String accessToken = TokenManager.getToken();
        multipleAlbumsResponse = given()
                .header("Authorization", "Bearer " + accessToken)
                .get("/albums?ids=" + albumIds.replaceAll(",", "%2C"));
    }

    @Then("I should receive multiple albums details")
    public void i_should_receive_multiple_albums_details() {
        assertEquals(200, multipleAlbumsResponse.getStatusCode());
        String albumNames = multipleAlbumsResponse.jsonPath().getString("albums.name");
        assertNotNull(albumNames);
        System.out.println("Album Names: " + albumNames);
    }
}

