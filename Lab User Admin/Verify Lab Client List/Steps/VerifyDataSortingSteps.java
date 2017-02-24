package com.easytox.automation.steps.labUserAdmin.verifyLabClientList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.easytox.automation.driver.DriverBase;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class VerifyDataSortingSteps {
	private WebDriver driver;
	private WebElement element;
	
	public VerifyDataSortingSteps() {
		DriverBase.instantiateDriverObject();
		driver = DriverBase.getDriver();
	}
	
	@Given("^user should be login to lab$")
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

	@When("^Click on '\\˅' down arrow on any on Sorting column$")
	public void click_on_down_arrow_on_any_on_Sorting_column() throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".fa-list-ul")).click();
		
		Thread.sleep(2000);
		element = driver.findElement(By.cssSelector("#example > thead > tr > th:nth-child(3)"));
		element.click();
	}

	@Then("^Records should be displayed based on the asecending order of the selected field$")
	public void records_should_be_displayed_based_on_the_asecending_order_of_the_selected_field() throws Throwable {
		Thread.sleep(2000);
		Assert.assertTrue(element.getAttribute("class").contains("sorting_asc"));
	}

	@When("^Click on '\\^' Up arrow icon on any Sorting column$")
	public void click_on_Up_arrow_icon_on_any_Sorting_column() throws Throwable {
		element.click();
	}

	@Then("^Records should be displayed based on the descending order of the selected field$")
	public void records_should_be_displayed_based_on_the_descending_order_of_the_selected_field() throws Throwable {
		Thread.sleep(2000);
		Assert.assertTrue(element.getAttribute("class").contains("sorting_desc"));
	}
}
