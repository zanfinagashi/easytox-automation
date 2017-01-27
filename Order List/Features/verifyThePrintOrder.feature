@bvt @smoke @uat
Feature: Verify the print order

@positive
Scenario: Verify the print order

Given User should be login to lab
When Click on PDF icon under the column 'Print Order'
Then Order report should be printed