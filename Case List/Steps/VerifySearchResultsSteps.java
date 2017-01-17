package com.easytox.automation.steps;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.easytox.automation.driver.DriverBase;
import com.easytox.automation.utils.WebElementHelper;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class VerifySearchResultsSteps {
	private WebDriver driver;
	private WebElementHelper webElementHelper;
	private String searchKey;
	
	public VerifySearchResultsSteps() {
		DriverBase.instantiateDriverObject();
		webElementHelper = new WebElementHelper();
		driver = DriverBase.getDriver();
	}
	
	@Given("^User should be login to the lab$")
	public void user_should_be_login_to_the_lab() throws Throwable {
		String USERNAME = "SNOneAdmin";
		String PASSWORD = "Test@123";
		String FIND_USERNAME = "j_username";
		String FIND_PASSWORD= "j_password";
		String URL = "http://bmtechsol.com:8080/easytox/";
		
		driver.navigate().to(URL);
		
		WebElement username = driver.findElement(By.name(FIND_USERNAME));
		username.clear();
		username.sendKeys(USERNAME);
		
		WebElement password = driver.findElement(By.name(FIND_PASSWORD));
		password.clear();
		password.sendKeys(PASSWORD);
		
		driver.findElement(By.cssSelector(".btn")).click();
	}

	@When("^Enter any search criteria and click on search icon$")
	public void enter_any_search_criteria_and_click_on_search_icon() throws Throwable {
		searchKey = "Patient";
		search();
	}

	@Then("^Matching records with entered data should be displayed in the case list$")
	public void matching_records_with_entered_data_should_be_displayed_in_the_case_list() throws Throwable {
		Thread.sleep(2000);
		WebElement table = driver.findElement(By.id("caseorder"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		
		loop:
		for (WebElement row : rows) {
			List<WebElement> cells = row.findElements(By.tagName("td"));
			for (WebElement cell : cells) {
				if(cell.getText().equals(searchKey)) {
					Assert.assertTrue(cell.getText().equals(searchKey));
					break loop; 
				}    
			}
		} 
	}

	@When("^Verify keyword search by entering Case Accession#/Patient First or last name/ Date of Birth/ or with case status of \"([^\"]*)\"$")
	public void verify_keyword_search_by_entering_Case_Accession_Patient_First_or_last_name_Date_of_Birth_or_with_case_status_of(String arg1) throws Throwable {
		searchKey = "finalized";
		search();
	}
	
	private void search() throws InterruptedException {
		Thread.sleep(2000);
		WebElement searchBox = driver.findElement(By.cssSelector("#caseorder_filter > label > input"));
		searchBox.clear();
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.cssSelector("#caseorder_filter > label")));
		actions.click();
		actions.sendKeys(searchKey);
		actions.build().perform();
		Thread.sleep(2000);
	}
}
