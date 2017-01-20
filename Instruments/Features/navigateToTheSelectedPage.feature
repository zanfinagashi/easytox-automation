@bvt @smoke @uat
Feature: Navigate to the selected page

@positive
Scenario: Navigate to the selected page

Given User should be login to the lab
When Click on Settings icon and click on the 'Instruments List'
Then Instruments List screen should be displayed 
