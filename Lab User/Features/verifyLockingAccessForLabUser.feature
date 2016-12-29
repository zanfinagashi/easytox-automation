@bvt @smoke @uat
Feature: Verify unlocking access for a Lab User

@positive
Scenario: Verify unlocking access for a Lab User

Given User should be login to the lab
When Select Settings -> User
Then User List screen with list of users is displayed

When Click "Lock" icon for any existing user under Action column
Then User should be locked and "User locked successfully" message should be populated

When Logout and attempt logging in with the above lab user credentials
Then Account locked message should be populated and user should not be able to login to application
