@bvt @smoke @uat
Feature: Verify disabling access for a lab user

@positive
Scenario: Verify disabling access for a lab user

Given User should be login to the lab
When Select Settings -> User
Then User List screen with list of users is displayed

When Click "Disable User" icon for any existing user under Enable/Disable column
Then User should be disabled and "User disabled successfully" message should be populated

When Logout and attempt logging in with the above lab user credentials
Then Account disabled message should be populated and user should not be able to login to application