@bvt @smoke @uat
Feature: Access seleniumframework.com website
  Use selenium java with cucumber-jvm and navigate to website

  @positive
  Scenario: Adding Physicians to Quest Lab Client
  
  Given User should be login to the lab
  Given Locations should be available  
  When Click on the Phisician icon on the LabClient list page for Quest lab
  Then 'Clinician List' page should be displayed
  
  When Select '+' icon next to search box
  Then 'Add Physician' page should be displayed
  
  When Enter Username as 'Angelia' and pwd as 'Welcome@123'
  Then User should be able to enter the data
  
  When Select and add Compound Profile
  Then User should be able to add the Compound Profile
  
  When Select Lab Client Locations as 'Quest' and select Location as 'Quest' and add the location
  Then User should be able to select the location
  
  When Enter the remaining information and click on 'Submit'
  Then Physician should be added to the Phisicians list
  
  When Select '+' icon next to search box  
  Then 'Add Physician' page should be displayed
  
  When Enter Username as 'Anaron' and pwd as 'Welcome@123'
  Then User should be able to enter the data
  
  When Select and add Compound Profile
  Then User should be able to add the Compound Profile
  
  When Select Lab Client Locations as 'Quest' and select Location as 'Quest' and add the location
  Then User should be able to select the location
  
  When Enter the remaining information and click on 'Submit'
  Then Physician should be added to the Phisicians list
  
  When Select '+' icon next to search box 
  Then 'Add Physician' page should be displayed  
  
  When Enter Username as 'Avondale' and pwd as 'Welcome@123'
  Then User should be able to enter the data

  When Select and add Compound Profile  
  Then User should be able to add the Compound Profile
  
  When Select Lab Client Locations as 'Quest' and select Location as 'Quest' and add the location
  Then User should be able to select the location
  
  When Enter the remaining information and click on 'Submit'
  Then Physician should be added to the Phisicians list
  
  When Select '+' icon next to search box
  Then 'Add Physician' page should be displayed
  
  When Enter Username as 'Aarthi' and pwd as 'Welcome@123'
  Then User should be able to enter the data
  
  When Select and add Compound Profile
  Then User should be able to add the Compound Profile
  
  When Select Lab Client Locations as 'Quest' and select Location as 'Quest' and add the location
  Then User should be able to select the location
  
  When Enter the remaining information and click on 'Submit'
  Then Physician should be added to the Phisicians list
  

