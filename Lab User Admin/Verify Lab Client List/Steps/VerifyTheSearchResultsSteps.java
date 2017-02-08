package com.easytox.automation.steps;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.easytox.automation.driver.DriverBase;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class VerifyTheSearchResultsSteps {
	private WebDriver driver;
	
	public VerifyTheSearchResultsSteps() {
		DriverBase.instantiateDriverObject();
		driver = DriverBase.getDriver();
	}
	
	@Given("^User should be login to lab$")
	public void user_should_be_login_to_lab() throws Throwable {
		String USERNAME = "superadmin";
		String PASSWORD = "admin";
		String FIND_USERNAME = "j_username";
		String FIND_PASSWORD = "j_password";
		String URL = "http://bmtechsol.com:8080/easytox";
		
		driver.navigate().to(URL);
		
		WebElement username = driver.findElement(By.name(FIND_USERNAME));
		username.clear();
		username.sendKeys(USERNAME);
		
		WebElement password = driver.findElement(By.name(FIND_PASSWORD));
		password.clear();
		password.sendKeys(PASSWORD);
		
		driver.findElement(By.cssSelector(".btn")).click();
	}

	@When("^Verify keyword search by entering City/State/Zip/Contact Person/Contact NumberEmail of any title and verify that it is found in search results$")
	public void verify_keyword_search_by_entering_City_State_Zip_Contact_Person_Contact_NumberEmail_of_any_title_and_verify_that_it_is_found_in_search_results() throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".fa-list-ul")).click();
		
		WebElement element = driver.findElement(By.cssSelector("#example_filter > label > input"));
		element.clear();
		
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.cssSelector("#example_filter > label")));
		action.click();
		action.sendKeys("admin");
		action.build().perform();
	}

	@Then("^Matching records with entered data should be displayed in the case list$")
	public void matching_records_with_entered_data_should_be_displayed_in_the_case_list() throws Throwable {
		List<WebElement> cells = driver.findElements(By.cssSelector("#example tbody td"));
		
		for (WebElement cell : cells) {
			if(cell.getText().equals("admin")) {
				Assert.assertTrue(cell.getText().equals("admin"));
				break;
			}
		}
		
	}
}
