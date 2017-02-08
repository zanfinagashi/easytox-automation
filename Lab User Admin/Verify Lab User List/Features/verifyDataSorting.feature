@bvt @smoke @uat
Feature: Verify lab user list

@positive
Scenario: Verify data sorting 

Given User should be login to lab
When Click on '˅' down arrow on any on Sorting column
Then Records should be displayed based on ascending order of selected field

When Click on '^' up arrow on any on Sorting column
Then Records should be displayed based on descending order of selected field