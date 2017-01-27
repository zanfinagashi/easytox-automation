@bvt @smoke @uat
Feature: Verify number of records

@positive
Scenario: Verify number of records

Given User should be login to lab
When Verify the default number of records displayed
Then Deafult number '10' should be displayed in the dropdown box

When Click on the dropdown that shows no of records to be displayed on the page
Then User should be able to view and select the options from the list and the corresponding number of records should be diplayed on the page