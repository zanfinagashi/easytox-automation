@btv @smoke @uat
Feature: Verify updating a lab user

@positive
Scenario: Verify updating a lab user

Given User should be login to the lab
When Select Settings -> User
Then User List screen with list of users is displayed

When Click "Edit" icon for any existing user under Action column
Then Edit lab User screen is displayed

When Verify User Information section
Then User Information should be locked for editing

When Make changes to Personal Information and click update
Then Changes made to personal information should be saved successfully

When Click "+" icon against newly created user
Then Following values should be populated with updated information
