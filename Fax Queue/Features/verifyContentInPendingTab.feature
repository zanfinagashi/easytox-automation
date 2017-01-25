@bvt @smoke @uat
Feature: Verify the content in pending tab

@positive
Scenario: Verify the contetn in pending tab

Given User should be login to lab
When Click on 'Pending' tab
Then Pending fax queue list should be displayed 

When Enter any search criteria and cilck on search icon
Then Matching records with entered data should be diplayed in the Fax Queue list
