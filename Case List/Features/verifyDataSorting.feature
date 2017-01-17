@bvt @smoke @uat 
Feature: Verify data sorting 

@positive
Scenario: Verify data sorting 

Given User should be login to the lab
When Click on "˅" down arrow on any  column
Then Records should be displayed based on the asecending order of the selected field

When Click on "^"Up arrow on any column
Then Records should be displayed based on the descending order of the selected field