@bvt @smoke @uat
Feature: Verify number of records displayed 

@positive
Scenario: Verify number of records displayed 

Given User should be login to lab
When Verify the default number of records displayed
Then Default number '10' should be displayed in the dropdown box

When Click on dropdown that shows no of records to be displayed on the page
Then User should be able to view and select the options from the list and the corresponding number of records should be displayed on the page