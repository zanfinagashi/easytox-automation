@bvt @smoke @uat
Feature: Verify the search results

@positive
Scenario: Verify the search results

Given User should be login to lab
When Enter any search criteria and click on search icon
Then Matching records with entered data should be diplayed in the case list