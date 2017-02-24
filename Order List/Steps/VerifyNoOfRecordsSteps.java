package com.easytox.automation.steps.orderList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.easytox.automation.driver.DriverBase;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class VerifyNoOfRecordsSteps {
	private WebDriver driver;
	private int noOfRows;
	
	public VerifyNoOfRecordsSteps() {
		DriverBase.instantiateDriverObject();
		driver = DriverBase.getDriver();
	}
	
	@Given("^User should be login to lab$")
	public void user_should_be_login_to_lab() throws Throwable {
		String USERNAME = "cgiclinician1";
		String PASSWORD = "Welcome@123";
		String FIND_USERNAME = "j_username";
		String FIND_PASSWORD = "j_password";
		String URL = "http://bmtechsol.com/easytox";
		
		driver.navigate().to(URL);
		
		WebElement username = driver.findElement(By.name(FIND_USERNAME));
		username.clear();
		username.sendKeys(USERNAME);
		
		WebElement password = driver.findElement(By.name(FIND_PASSWORD));
		password.clear();
		password.sendKeys(PASSWORD);
		
		driver.findElement(By.cssSelector(".btn")).click();
	}

	@When("^Verify the default number of records displayed$")
	public void verify_the_default_number_of_records_displayed() throws Throwable {
		Thread.sleep(2000);
		Select select = new Select(driver.findElement(By.name("caseorder_length")));
		noOfRows = Integer.parseInt(select.getFirstSelectedOption().getText());
	}

	@Then("^Deafult number '(\\d+)' should be displayed in the dropdown box$")
	public void deafult_number_should_be_displayed_in_the_dropdown_box(int arg1) throws Throwable {
		Assert.assertEquals(noOfRows, 10);
	}

	@When("^Click on the dropdown that shows no of records to be displayed on the page$")
	public void click_on_the_dropdown_that_shows_no_of_records_to_be_displayed_on_the_page() throws Throwable {
		driver.findElement(By.name("caseorder_length")).click();
	}

	@Then("^User should be able to view and select the options from the list and the corresponding number of records should be diplayed on the page$")
	public void user_should_be_able_to_view_and_select_the_options_from_the_list_and_the_corresponding_number_of_records_should_be_diplayed_on_the_page() throws Throwable {
		Select select = new Select(driver.findElement(By.name("caseorder_length")));
		WebElement tableBody = driver.findElement(By.cssSelector("#caseorder tbody"));
		for (int i = 1; i < 4; i++) {
			select.selectByIndex(i);
			int nrOfRows = tableBody.findElements(By.tagName("tr")).size();
			Assert.assertTrue(nrOfRows <= Integer.parseInt(select.getFirstSelectedOption().getText()));
			Thread.sleep(500);
		}
	}
}
