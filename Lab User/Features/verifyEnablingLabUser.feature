@bvt @smoke @uat
Feature: Verify enabling a lab user

@positive
Scenario: Verify enabling a lab user

Given User should be login to the lab
When Select Settings -> User
Then User List screen with list of users is displayed

When Select a user which is disabled and click "Enable" icon under Enable/Disable column
Then User account should be enabled and "User enabled successfully" message should be populated

When Logout and attempt logging in with the above lab user credentials
Then User login should be successful