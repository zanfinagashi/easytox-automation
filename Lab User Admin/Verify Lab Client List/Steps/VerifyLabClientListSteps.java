package com.easytox.automation.steps.labUserAdmin.verifyLabClientList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.easytox.automation.driver.DriverBase;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class VerifyLabClientListSteps {
	private WebDriver driver;
	
	public VerifyLabClientListSteps() {
		DriverBase.instantiateDriverObject();
		driver = DriverBase.getDriver();
	}
	
	@When("^Enter valid Username and Password click on 'Login' button$")
	public void enter_valid_Username_and_Password_click_on_Login_button() throws Throwable {
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

	@Then("^Lab admin user should be able to login successfully$")
	public void lab_admin_user_should_be_able_to_login_successfully() throws Throwable {
		Assert.assertEquals(driver.getCurrentUrl(), "http://bmtechsol.com:8080/easytox/lab/list");
	}

	@When("^Click on 'Lab List' on the menu$")
	public void click_on_Lab_List_on_the_menu() throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".sidebar-menu > li > a")).click();
	}

	@Then("^'Lab List' results screen should be displayed$")
	public void lab_List_results_screen_should_be_displayed() throws Throwable {
		Assert.assertEquals(driver.getCurrentUrl(), "http://bmtechsol.com:8080/easytox/lab/list");
	}

	@When("^Click on Client List Icon under 'action' column$")
	public void click_on_Client_List_Icon_under_action_column() throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".fa-list-ul")).click();
	}

	@Then("^Lab Client List screen should be displayed$")
	public void lab_Client_List_screen_should_be_displayed() throws Throwable {
		Assert.assertEquals(driver.getCurrentUrl(), "http://bmtechsol.com:8080/easytox/labClient/labclientlists");
	}
}
