@bvt @smoke @uat
Feature: Verify the content in failure tab

@positive
Scenario: Verify the content in failure tab

Given User should be login to lab
When Click on 'Failure' tab
Then Failure fax queue list should be displayed

When Enter any search criteria and click on search icon
Then Matching records with entered data should be displayed in the Fax Queue List