package com.easytox.automation.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.easytox.automation.driver.DriverBase;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class NavigatingToSelectedScreenSteps {
	private WebDriver driver;
	
	public NavigatingToSelectedScreenSteps() {
		
		DriverBase.instantiateDriverObject();
		driver = DriverBase.getDriver();
	}

	@Given("^User should be login to lab$")
	public void user_should_be_login_to_lab() throws Throwable {
		String USERNAME = "cgiclinician1";
		String PASSWORD = "Welcome@123";
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

	@When("^Click on 'Order List' on the menu$")
	public void click_on_Order_List_on_the_menu() throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".sidebar-menu > li")).click();
	}

	@Then("^'Order List' screen should be displayed$")
	public void order_List_screen_should_be_displayed() throws Throwable {
		Assert.assertEquals(driver.getCurrentUrl(), "http://bmtechsol.com:8080/easytox/orderFrom/list");
	}
}
