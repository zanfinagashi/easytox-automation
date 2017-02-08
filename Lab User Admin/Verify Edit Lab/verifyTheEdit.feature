@bvt @smoke @uat
Feature: Verify edit lab

@positvie
Scenario: Verify the edit

When Enter valid Username and Password click on 'Login' button
Then Lab admin user should be able to login successfully

When Click on 'Lab List' on the menu
Then 'Lab List' results screen should be displayed

When Click on User List Icon under 'action' column
Then Lab User List should be displayed

When Click on Edit icon
Then Update Lab Admin User screen should be displayed successfully and the followinginformation should be displayed on the screen  User Information, Personal Information

When User information is not editable
Then User information should be disabled and grayed out

When Personal information is editable and click on 'Update' button
Then Personal information should be editable and and all the information should be updated successfully