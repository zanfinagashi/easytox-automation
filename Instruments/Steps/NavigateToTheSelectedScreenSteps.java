package com.easytox.automation.steps.Instruments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.easytox.automation.driver.DriverBase;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class NavigateToTheSelectedScreenSteps {
	WebDriver driver;
	
	public NavigateToTheSelectedScreenSteps() {
		DriverBase.instantiateDriverObject();
		driver = DriverBase.getDriver();
	}
	
	@Given("^User should be login to the lab$")
	public void user_should_be_login_to_the_lab() throws Throwable {
		String USERNAME = "cgilabadmin";
		String PASSWORD = "Welcome@123";
		String FIND_USERNAME = "j_username";
		String FIND_PASSWORD = "j_password";
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

	@When("^Click on Settings icon and click on the 'Instruments List'$")
	public void click_on_Settings_icon_and_click_on_the_Instruments_List() throws Throwable {
		Thread.sleep(2000);
		
		driver.findElement(By.cssSelector(".account-area > li:nth-child(8)")).click();
		driver.findElement(By.cssSelector("#topmenu > li:nth-child(2)")).click();
	}

	@Then("^Instruments List screen should be displayed$")
	public void instruments_List_screen_should_be_displayed() throws Throwable {
		Assert.assertEquals(driver.getCurrentUrl(), "http://bmtechsol.com:8080/easytox/instruments/list");
	}
}
