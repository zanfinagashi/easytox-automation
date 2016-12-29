@bvt @smoke @uat
Feature: Verify data sorting

@positive
Scenario: Verify data sorting

Given User should be login to the lab
When Select Settings -> User
Then User List screen with list of users is displayed

When Click on "˅" down arrow icon on  Sorting  column
Then Records should be displayed based on the asecending order of the selected  field

When Click on "^" Up arrow icon  on sorting column
Then Records should be displayed based on the descending order of the selected field

When Repeat Steps 1 and 2 on all the columns
Then Sorting should work on all the columns that has sorting facility

