Feature: Quiz

  Scenario: User starts a quiz for location
    Given there is a quiz for the location 'Tower hill'
    When the user starts a quiz for the location 'Tower Hill'
    Then response content type should be 'application/json' and status code 200
    And response body as quiz should be valid