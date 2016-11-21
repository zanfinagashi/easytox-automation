@bvt @smoke @uat
Feature: Access seleniumframework.com website
  Use selenium java with cucumber-jvm and navigate to website

  @positive
  Scenario: Adding Physicians to West Lab Client
  
  Given User should be login to the lab
  Given Locations should be available  
  When Click on the Phisician icon on the LabClient list page for Zest lab
  Then 'Clinician List' page should be displayed
  
  When Select 'Edit' icon next to 'BradLemon' physician
  Then 'Edit Physician' page should be displayed
   
  When Select Lab Client Locations as 'Zest' and select Location as 'Zest' and add the location
  Then User should be able to select the location
  
  When Click on 'Submit'
  Then Physician should be added to the Zest Lab Client
  
  When Select '+' icon next to search box  
  Then 'Add Physician' page should be displayed
  
  When Enter Username as 'Calvin' and pwd as 'Welcome@123'
  Then User should be able to enter the data
  
  When Select and add Compound Profile
  Then User should be able to add the Compound Profile
  
  When Select Lab Client Locations as 'Zest' and select Location as 'Zest' and add the location
  Then User should be able to select the location
  
  When Enter the remaining information and click on 'Submit'
  Then Physician should be added to the Phisicians list
  
  When Select '+' icon next to search box 
  Then 'Add Physician' page should be displayed  
  
  When Enter Username as 'Caster' and pwd as 'Welcome@123'
  Then User should be able to enter the data

  When Select and add Compound Profile  
  Then User should be able to add the Compound Profile
  
  When Select Lab Client Locations as 'Zest' and select Location as 'Zest' and add the location
  Then User should be able to select the location
  
  When Enter the remaining information and click on 'Submit'
  Then Physician should be added to the Phisicians list
  
  When Select '+' icon next to search box
  Then 'Add Physician' page should be displayed
  
  When Enter Username as 'Cooper' and pwd as 'Welcome@123'
  Then User should be able to enter the data
  
  When Select and add Compound Profile
  Then User should be able to add the Compound Profile
  
  When Select Lab Client Locations as 'Zest' and select Location as 'Zest' and add the location
  Then User should be able to select the location
  
  When Enter the remaining information and click on 'Submit'
  Then Physician should be added to the Phisicians list
  

