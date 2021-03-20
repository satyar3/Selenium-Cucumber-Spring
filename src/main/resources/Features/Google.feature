Feature: Google Launch And Search Feature

  @SINGLE
  Scenario: Search a String in Google 1
    Given User is on the home page of google
    When User is typing "Hello World with Java Thread 1"
    And User is on the Search result page
    Then Close the browser

  @DOUBLE
  Scenario: Search a String in Google 2
    Given User is on the home page of google
    When User is typing "Hello World with Java Thread 2"
    And User is on the Search result page
    Then Close the browser

  @DOUBLE
  Scenario: Search a String in Google 3
    Given User is on the home page of google
    When User is typing "Hello World with Java Thread 3"
    And User is on the Search result page
    Then Close the browser