@bvt @smoke @uat
Feature: Navigating to selected screen

@positive
Scenario: Navigating to selected screen

Given User should be login to lab
When  Click on 'Print Reports' tab on the menu
Then 'Finalized Case List' screen should be displayed
