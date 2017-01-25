@bvt @smoke @uat
Feature: Verify the check box

@positive
Scenario: Verify the check box

Given User should be login to lab
When Select the records that need to be printed and click on print
Then 'Success Print Jobs are being executed ....' text message should be displayed on above the finalized case list screen