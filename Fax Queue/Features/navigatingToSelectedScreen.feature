@bvt @smoke @uat
Feature: Navigating to selected screen

@positive
Scenario: Navigating to selected screen

Given User should be login to lab
When Click on 'Fax Queue' tab on the menu and click on 'See All'
Then Fax Queue list page should be displayed