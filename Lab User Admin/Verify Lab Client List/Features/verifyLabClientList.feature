@bvt @smoke @uat
Feature: Verify lab client list

@positive
Scenario: Verify lab client list

When Enter valid Username and Password click on 'Login' button
Then Lab admin user should be able to login successfully

When Click on 'Lab List' on the menu
Then 'Lab List' results screen should be displayed

When Click on Client List Icon under 'action' column
Then Lab Client List screen should be displayed

