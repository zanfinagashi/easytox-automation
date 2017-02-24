package com.easytox.automation.steps.labUser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.easytox.automation.driver.DriverBase;
import com.easytox.automation.utils.WebElementHelper;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class VerifyNoOfRecordsDisplayedPerPageSteps {
	
	private WebDriver driver;
	private WebElementHelper webElementHelper;
	
	public VerifyNoOfRecordsDisplayedPerPageSteps() {
		DriverBase.instantiateDriverObject();
		webElementHelper = new WebElementHelper();
		driver = DriverBase.getDriver();
	}
	
	@Given("^User should be login to the lab$")
	public void user_should_be_login_to_the_lab() throws Throwable {
		login();
		
	}

	@When("^Select Settings -> User$")
	public void select_Settings_User() throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".account-area > li:nth-child(8) > a")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".account-area > li:nth-child(8) > ul > li:first-child > a")).click();
        Thread.sleep(3000);
	}

	@Then("^User List screen with list of users is displayed$")
	public void user_List_screen_with_list_of_users_is_displayed() throws Throwable {
		Assert.assertEquals("http://bmtechsol.com:8080/easytox/user/index", driver.getCurrentUrl());
	}

	@When("^Verify the default number of records displayed$")
	public void verify_the_default_number_of_records_displayed() throws Throwable {
		WebElement table = driver.findElement(By.id("example"));
		int rowsCount = table.findElements(By.xpath("//table[@id='example']/tbody/tr")).size();
		
		Assert.assertTrue(rowsCount <= 10);
	}

	@Then("^Default number \"([^\"]*)\" should be displayed in the dropdown box$")
	public void default_number_should_be_displayed_in_the_dropdown_box(String arg1) throws Throwable {
		Thread.sleep(2000);
		Select dropdown = new Select (driver.findElement(By.name("example_length")));
		System.out.println("test:"+dropdown.getFirstSelectedOption().getText());
		int defaultNo = Integer.valueOf(dropdown.getFirstSelectedOption().getText());
		
		Assert.assertEquals(10, defaultNo);
	}

	@When("^Click on dropdown that shows no of records to be displayed on the page$")
	public void click_on_dropdown_that_shows_no_of_records_to_be_displayed_on_the_page() throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.name("example_length")).click();
		Thread.sleep(2000);
	}

	@Then("^User should be able to view and select the options from the list and the corresponding number of records should be displayed on the page$")
	public void user_should_be_able_to_view_and_select_the_options_from_the_list_and_the_corresponding_number_of_records_should_be_displayed_on_the_page() throws Throwable {
		Select dropdown = new Select (driver.findElement(By.name("example_length")));
		dropdown.selectByIndex(1);
		Thread.sleep(2000);
		
		WebElement table = driver.findElement(By.id("example"));
		int rowsCount;
		
		for (int i = 0; i < 4; i++) {
			dropdown.selectByIndex(i);
			int value = Integer.parseInt(dropdown.getFirstSelectedOption().getText());
			rowsCount = table.findElements(By.xpath("//table[@id='example']/tbody/tr")).size();
			
			Assert.assertTrue(rowsCount <= value);
			
			Thread.sleep(2000);
		}
	}
	
	private void login() {
		String USERNAME = "cgilabadmin";
		String PASSWORD = "Welcome@123";
		String FIND_USERNAME = "j_username";
	    String FIND_PASSWORD = "j_password";
		String URL = "http://bmtechsol.com:8080/easytox/";
		
        driver.navigate().to(URL);

        WebElement username = driver.findElement(By.name(FIND_USERNAME));
        username.clear();
        username.sendKeys(USERNAME);

        WebElement psw = driver.findElement(By.name(FIND_PASSWORD));
        psw.clear();
        psw.sendKeys(PASSWORD);

        driver.findElement(By.xpath("//*[@id=\"loginform\"]/div[3]/div/button")).click();
	}
}
