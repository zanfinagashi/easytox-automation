@bvt @smoke @uat
Feature: Editing a case under action column

@positive
Scenario: Editing a case under action column

Given User should be login to the lab
When Verify that for a case under column 'Status' as 'Processing'
Then 'Processing' should be displayed under column 'statu'

When Click on the delete icon under the column 'Action' field for a Processing case 
Then Delete conformation window should be displayed