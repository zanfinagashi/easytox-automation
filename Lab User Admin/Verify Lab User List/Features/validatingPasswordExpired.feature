@bvt @smoke @uat
Feature: Verify lab user list

@positive
Scenario: Validating password expired

Given User should be login to lab
When Click on password not expired icon
Then 'User password expired now' message should be populated

When Logout and attempt logging in with the above lab user credentials
Then Password Expired message should be populated and user should not be able to login to application

When Click on password expired icon
Then 'User password activated now' message should be populated

When Logout and attempt logging in with the above lab user credentials
Then User login should be successful