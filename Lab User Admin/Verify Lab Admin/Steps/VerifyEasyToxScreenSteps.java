package com.easytox.automation.steps.labUserAdmin.verifyLabAdmin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.easytox.automation.driver.DriverBase;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class VerifyEasyToxScreenSteps {
	private WebDriver driver;
	
	public VerifyEasyToxScreenSteps() {
		DriverBase.instantiateDriverObject();
		driver = DriverBase.getDriver();
	}
	
	@Given("^Usern should be login to lab$")
	public void usern_should_be_login_to_lab() throws Throwable {
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

	@When("^Click on 'Lab List' on the menu$")
	public void click_on_Lab_List_on_the_menu() throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".sidebar-menu > li")).click();
	}

	@Then("^'Lab List' results screen should be diplayed$")
	public void lab_List_results_screen_should_be_diplayed() throws Throwable {
		Assert.assertEquals(driver.getCurrentUrl(), "http://bmtechsol.com:8080/easytox/lab/list");
	}

}
