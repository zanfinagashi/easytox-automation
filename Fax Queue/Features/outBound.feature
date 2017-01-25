@bvt @smoke @uat
Feature: OutBound

@positive
Scenario: OutBound

Given User should be login to lab
When click on 'OutBound' tab 
Then OutBoundFax Queue page should be displayed with 3 tabs 1. Pending 2. Sent 3. Faillure
