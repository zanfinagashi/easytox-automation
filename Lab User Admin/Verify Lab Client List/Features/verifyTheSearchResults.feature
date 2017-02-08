@bvt @smoke @uat
Feature: Verify lab client list

@positive
Scenario: Verify the search results 

Given User should be login to lab
When Verify keyword search by entering City/State/Zip/Contact Person/Contact NumberEmail of any title and verify that it is found in search results
Then Matching records with entered data should be displayed in the case list
