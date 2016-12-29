@bvt @smoke @uat
Feature: Verify unlocking access for a Lab User

@positive
Scenario: Verify unlocking access for a Lab User

Given User should be login to the lab
When Select Settings -> User
Then User List screen with list of users is displayed

When Select a user which is locked and click "Unlock" icon under Action column
Then User account should be unlocked and "User unlocked successfully" message should be populated

When Logout and attempt logging in with the above lab user credentials.
Then User login should be successful
