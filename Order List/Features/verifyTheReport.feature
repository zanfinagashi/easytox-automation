@bvt @smoke @uat
Feature: Verify the report

@positive
Scenario: Verify the report

Given User should be login to lab
When Verify the Report column for finilized orders
Then A PDF icon for viewing the report should be diplayed

When Click on PDF icon under the column 'Report'
Then A 'Order' report should be generated and an 'eye' icon should be displayed beside the 'Pdf' icon under Report column

When Verify report hax been viewed
Then 'Eye' icon should be diaplyed beside the pdf icon mouse hover the icon it displayes the text message 'Report has been viewed'