@bvt @smoke @uat
Feature: Verify lab user list

@positive
Scenario: Verify the pagination 

Given User should be login to lab
When Navigate back and forth by selecting page numbers 'Prev/1,2,3/Next'
Then User should be navigate to the selected page

When Checking the message of no of records displayed on the current page bottom left corner of the screen
Then A text message 'Showing x to y of z entries' should be displayed on the bottom left corner of the list