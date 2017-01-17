@bvt @smoke @uat
Feature: Verify the report

@positive
Scenario: Verify the report

Given User should be login to the lab
When Verify the Report column for finalized cases.
Then A PDF icon for viewing the report should be displayed.

When Click on PDF icon under the column "Report"
Then A case report should be displayed