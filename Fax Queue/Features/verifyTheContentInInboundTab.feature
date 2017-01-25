@bvt @smoke @uat
Feature: Verify the content in inbound tab

@positive
Scenario: Verify the conent in inbound tab

Given User should be login to lab
When Click on InBound tab on Fax Queue List
Then InBound Fax Queue page should be diplayed 

When Enter any search criteria and click on search icon
Then Matching records with entered data should be displayed in the InBound Fax Queue List