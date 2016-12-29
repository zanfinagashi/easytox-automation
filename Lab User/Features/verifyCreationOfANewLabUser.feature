@btv @smoke @uat
Feature: Verify Creation Of A New Lab User

@positive
Scenario: Verify Creation Of A New Lab User

Given User should be login to the lab
When Select Settings -> User
Then User List screen with list of users is displayed

When Click Add User "+" icon displayed
Then Add Lab User screen is displayed

When Enter User Information, Personal Information and Lab Information and click Add User
Then New user is added successfully and newly added user is listed in the User List screen

When Click "+" icon against newly created user
Then Following values should be populated