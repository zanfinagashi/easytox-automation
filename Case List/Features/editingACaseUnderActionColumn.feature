@bvt @smoke @uat
Feature: Editing a case under action column

@positive
Scenario: Editing a case under action column

Given User should be login to the lab
When Verify that for a case under column "Status" as "Finalized"
Then "Finalized" should be displayed under column "Status"

When Click on the Edit icon under the Action column for "Finalized" case 
Then "Select Option" window should be displayed 