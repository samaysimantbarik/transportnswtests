@UI
Feature: Validate Trip Planner Feature of transportnsw service

Scenario: A trip request can be executed and results returned 1
Given Phileas is planning a trip
When he executes a trip plan from "North Sydney Station" to "Town Hall Station"
Then a list of trips should be provided

Scenario: A trip request can be executed and results returned -Central
Given Phileas is planning a trip
When he executes a trip plan from "North Sydney Station" to "Central Station"
Then a list of trips should be provided

Scenario: A trip request can be executed and results returned - Chatswood
Given Phileas is planning a trip
When he executes a trip plan from "North Sydney Station" to "Chatswood Station"
Then a list of trips should be provided

Scenario: A trip request can be executed and results returned - Strathfield
Given Phileas is planning a trip
When he executes a trip plan from "North Sydney Station" to "Strathfield Station"
Then a list of trips should be provided

Scenario: A trip request can be executed and results returned 5
Given Phileas is planning a trip
When he executes a trip plan from "North Sydney Station" to "Town Hall Station"
Then a list of trips should be provided


Scenario: A trip request can be executed and results returned 6
Given Phileas is planning a trip
When he executes a trip plan from "North Sydney Station" to "Town Hall Station"
Then a list of trips should be provided


Scenario: A trip request can be executed and results returned 7
Given Phileas is planning a trip
When he executes a trip plan from "North Sydney Station" to "Town Hall Station"
Then a list of trips should be provided


Scenario: A trip request can be executed and results returned 8
Given Phileas is planning a trip
When he executes a trip plan from "North Sydney Station" to "Town Hall Station"
Then a list of trips should be provided



Scenario: A trip request can be executed and results returned 9
Given Phileas is planning a trip
When he executes a trip plan from "North Sydney Station" to "Town Hall Station"
Then a list of trips should be provided


Scenario: A trip request can be executed and results returned 10
Given Phileas is planning a trip
When he executes a trip plan from "North Sydney Station" to "Town Hall Station"
Then a list of trips should be provided


Scenario: A trip request can be executed and results returned 11
Given Phileas is planning a trip
When he executes a trip plan from "North Sydney Station" to "Town Hall Station"
Then a list of trips should be provided


Scenario: A trip request can be executed and results returned 12
Given Phileas is planning a trip
When he executes a trip plan from "North Sydney Station" to "Town Hall Station"
Then a list of trips should be provided