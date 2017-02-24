package com.easytox.automation.steps.labUserAdmin.verifyLabAdmin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.easytox.automation.driver.DriverBase;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginAsALabAdminSteps {
	private WebDriver driver;
	
	public LoginAsALabAdminSteps() {
		DriverBase.instantiateDriverObject();
		driver = DriverBase.getDriver();
	}
	
	@When("^Enter valid Username and Password click on 'Login' Button$")
	public void enter_valid_Username_and_Password_click_on_Login_Button() throws Throwable {
		String USERNAME = "superadmin";
		String PASSWORD = "admin";
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

	@Then("^Lab user should be able to login successfully$")
	public void lab_user_should_be_able_to_login_successfully() throws Throwable {
		Thread.sleep(500);
		Assert.assertEquals(driver.getCurrentUrl(), "http://bmtechsol.com/easytox/lab/list");
	}
}
