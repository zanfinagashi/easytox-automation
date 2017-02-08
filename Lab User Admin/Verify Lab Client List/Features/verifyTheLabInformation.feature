@bvt @smoke @uat
Feature: Verifing lab client list

@positive
Scenario: Verify the lab information

Given User should be login to lab
When Click on '+' icon against the lab client record in results list
Then Existing Lab Client Following values should be populated: Address: Address1,address2  Lab: LabTest