@bvt @smoke @uat
Feature: Verify the data sorting

@positive
Scenario: Verify the data sorting

Given User should be login to lab
When Click on '˅' down arrow icon on sorting column
Then Records should be displayed based on the asecending order of the selected sorting column

When Click on '^' Up icon  arrow on Profile Name column
Then Records should be displayed based on the descending order of the selected sorting column