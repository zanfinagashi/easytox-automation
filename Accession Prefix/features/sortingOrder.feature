@btv @smoke @uat
Feature: Checking the sorting order of the displayed results 

@positive
Scenario: Checking the sorting order of the displayed results 

Given the user is on Accession Prefix page 
When clicked on Prefix column of the list
Then the list should be displayed in the alphabetical order

Given the user is on Accession Prefix page 
When clicked on Prefix type column of the list
Then the list should be displayed in the alphabetical order

Given the user is on Accession Prefix page 
When clicked on Sequence number column of the list
Then the list should be displayed in the numerical order

Given the user is on Accession Prefix page 
When clicked on Default column of the list
Then the list should be displayed in the order
