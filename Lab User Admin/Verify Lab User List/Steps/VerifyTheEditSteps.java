package com.easytox.automation.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.easytox.automation.driver.DriverBase;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class VerifyTheEditSteps {
	private WebDriver driver;
	
	public VerifyTheEditSteps() {
		DriverBase.instantiateDriverObject();
		driver = DriverBase.getDriver();
	}
	
	@Given("^User should be login to lab$")
	public void user_should_be_login_to_lab() throws Throwable {
		String USERNAME = "superadmin";
		String PASSWORD = "admin";
		String FIND_USRENAME = "j_username";
		String FIND_PASSWORD = "j_password";
		String URL = "http://bmtechsol.com:8080/easytox";
		
		driver.navigate().to(URL);
		
		WebElement username = driver.findElement(By.name(FIND_USRENAME));
		username.clear();
		username.sendKeys(USERNAME);
		
		WebElement password = driver.findElement(By.name(FIND_PASSWORD));
		password.clear();
		password.sendKeys(PASSWORD);
		
		driver.findElement(By.cssSelector(".btn")).click();
	}

	@When("^Cick on Edit icon$")
	public void cick_on_Edit_icon() throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".fa-users")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".fa-pencil-square-o")).click();
	}

	@Then("^Update Lab Admin screen should be displayed successfully and the followinginformation should be displayed on the screen$")
	public void update_Lab_Admin_screen_should_be_displayed_successfully_and_the_followinginformation_should_be_displayed_on_the_screen() throws Throwable {
		Thread.sleep(1000);
		Assert.assertEquals(driver.getCurrentUrl(), "http://bmtechsol.com:8080/easytox/user/edit");
	}

}
