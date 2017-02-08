@bvt @smoke @uat
Feature: Verify lab client list

@positive
Scenario: Verify data sorting 

Given user should be login to lab
When Click on '˅' down arrow on any on Sorting column
Then Records should be displayed based on the asecending order of the selected field

When Click on '^' Up arrow icon on any Sorting column
Then Records should be displayed based on the descending order of the selected field