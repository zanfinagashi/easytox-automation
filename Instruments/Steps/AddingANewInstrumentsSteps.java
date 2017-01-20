package com.easytox.automation.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.easytox.automation.driver.DriverBase;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddingANewInstrumentsSteps {
	private WebDriver driver;
	
	public AddingANewInstrumentsSteps() {
		DriverBase.instantiateDriverObject();
		driver = DriverBase.getDriver();
	}
	
	@Given("^Should be login to lab$")
	public void should_be_login_to_lab() throws Throwable {
		String USERNAME = "cgilabadmin";
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

	@When("^Click on '\\+' icon beside the Search Box$")
	public void click_on_icon_beside_the_Search_Box() throws Throwable {
		driver.navigate().to("http://bmtechsol.com:8080/easytox/instruments/list");
		
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".fa-plus-circle")).click();
	}

	@Then("^'Add Instruments' screen should be displayed$")
	public void add_Instruments_screen_should_be_displayed() throws Throwable {
		Assert.assertEquals(driver.getCurrentUrl(), "http://bmtechsol.com:8080/easytox/instruments/create");
	}
}
