@bvt @smoke @uat
Feature: Verify lab user list

@positive
Scenario: Verify the user list

Given User should be login to lab
When Click on User List icon under 'action' column	
Then Lab User List screen should be displayed
