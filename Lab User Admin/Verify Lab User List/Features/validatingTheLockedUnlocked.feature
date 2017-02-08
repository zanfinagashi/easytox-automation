@bvt @smoke @uat
Feature: Verify lab user list

@positive
Scenario: Validating the locked unlocked

Given User should be login to lab
When Click 'Lock' icon for any existing user Action column
Then User should be locked and 'User locked successfully' message should be populated on the top of the screen

When Logout and attempt logging in with the above lab user credential
Then Account locked message should be populated and user should not be able to login to application

When Select a user which is locked and click 'Unlock' icon under Locked column
Then User account should be unlocked and 'User unlocked successfully' message should be populated

When Logout and attempt logging in with the above lab user credentials
Then User login should be successful
