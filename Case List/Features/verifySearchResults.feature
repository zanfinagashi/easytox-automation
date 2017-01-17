@bvt @smoke @uat
Feature: Verify the search results

@positive 
Scenario: Verify the search results

Given User should be login to the lab
When Enter any search criteria and click on search icon
Then Matching records with entered data should be displayed in the case list

When Verify keyword search by entering Case Accession#/Patient First or last name/ Date of Birth/ or with case status of "Preocessing or finalized"
Then Matching records with entered data should be displayed in the case list