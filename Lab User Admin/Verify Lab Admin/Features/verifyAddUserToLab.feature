@bvt @smoke @uat
Feature: Verify adding lab admin user

@positive
Scenario: Verify add user to lab

Given Usern should be login to lab
When Click on lab name
Then 'Update lab' screen should be displayed

When Click on 'User+' icon on the right corner of the Update lab screen
Then 'Add Lab Admin User' screen should be diplayed

When Enter User Information, Personal Information and Lab  Information and click Add User
Then New user is added successfully and newly added user is listed in the Lab admin User List screen