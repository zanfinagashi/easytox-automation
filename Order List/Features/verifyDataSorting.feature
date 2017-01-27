@bvt @smoke @uat
Feature: Verify data sorting

@postive
Scenario: Verify data sorting

Given User shoulb bo login to lab
When Click on '˅' down arrow on any on Sorting column
Then Records should be displayed based on the asecending order of the selected field

When Click on '^' Up arrow icon on any Sorting column
Then Records should be displayed based on the descending order of the selected field