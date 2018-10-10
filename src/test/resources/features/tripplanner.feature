@UI
Feature: Validate Trip Planner Feature of transportnsw service

Scenario: A trip request can be executed and results returned
Given Phileas is planning a trip
When he executes a trip plan from "North Sydney Station" to "Town Hall Station"
Then a list of trips should be provided