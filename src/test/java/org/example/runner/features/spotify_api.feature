Feature: Spotify API

  Scenario: Get album details
    Given I have a valid access token
    When I request album details with ID "4aawyAB9vmqN3uQ7FjRGTy"
    Then I should receive album details

  Scenario: Get artist details
    Given I have a valid access token
    When I request artist details with ID "1vCWHaC5f2uS3yhpwWbIA6"
    Then I should receive artist details

  Scenario: Get multiple albums details
    Given I have a valid access token
    When I request multiple albums details with IDs "382ObEPsp2rxGrnsizN5TX,1A2GTWGtFfWp7KSQTwWOyo,2noRn2Aes5aoNVsU6iWThc"
    Then I should receive multiple albums details


