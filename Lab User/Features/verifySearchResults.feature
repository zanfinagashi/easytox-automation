@bvt @smoke @uat
Feature: Verify search results

@positive 
Scenario: Verify search results

Given User should be login to the lab
When Select Settings -> User
Then User List screen with list of users is displayed

When Enter any search criteria and click on search icon
Then Matching records with entered data should be displayed in the User list

