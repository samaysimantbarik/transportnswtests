@API
Feature: Validate Stop Finder Feature of transportnsw service

  @tag1
  Scenario: A stop providing multiple transport options can be located
    Given Phileas is looking for a stop
    When he searches for "Wynyard Station"
    Then a stop named "Wynyard Station, Sydney" is found
    And the stop provides more than one mode of transport

