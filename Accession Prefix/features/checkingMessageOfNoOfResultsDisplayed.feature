@bvt @smoke @uat
Feature: Checking the message of no of results displayed on current page

@positive
Scenario: Checking the message of no of results displayed on current page

Given the user is on Accession Prefix page 
When the user searches the results
Then the text “Showing x to y of z entries” should be displayed on the bottom left corner of the list
