@bvt @smoke @uat
Feature: Verify adding lab admin user

@positive
Scenario: Login as lab admin

When Enter valid Username and Password click on 'Login' Button
Then Lab user should be able to login successfully