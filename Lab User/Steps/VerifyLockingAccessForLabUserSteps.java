package com.easytox.automation.steps.labUser;

import java.util.List;

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

public class VerifyLockingAccessForLabUserSteps {
	private WebDriver driver;
	private WebElementHelper webElementHelper;
	private String user = "cgilabadmin";
	
	public VerifyLockingAccessForLabUserSteps() {
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

	@When("^Click \"([^\"]*)\" icon for any existing user under Action column$")
	public void click_icon_for_any_existing_user_under_Action_column(String arg1) throws Throwable {
		driver.manage().window().maximize();
		user = "CGILabUser1";
		Thread.sleep(2000);
		WebElement table = driver.findElement(By.id("example"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		
		loop:
		for (WebElement row : rows) {
			List<WebElement> cells = row.findElements(By.tagName("td"));
			for (WebElement cell : cells) {
				if(cell.getText().equals(user)) {
					Thread.sleep(1000);
					row.findElement(By.cssSelector(".fa-unlock-alt")).click();
					break loop; 
				}    
			}
		} 
	}

	@Then("^User should be locked and \"([^\"]*)\" message should be populated$")
	public void user_should_be_locked_and_message_should_be_populated(String arg1) throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".alert-success"));
	}

	@When("^Logout and attempt logging in with the above lab user credentials$")
	public void logout_and_attempt_logging_in_with_the_above_lab_user_credentials() throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".account-area > li:nth-child(7) > a")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".account-area > li:nth-child(7) > ul > li:last-child > a")).click();
        Thread.sleep(3000);
        
        login();
	}

	@Then("^Account locked message should be populated and user should not be able to login to application$")
	public void account_locked_message_should_be_populated_and_user_should_not_be_able_to_login_to_application() throws Throwable {
		String msg = driver.findElement(By.cssSelector(".alert-danger")).getText();
		Assert.assertEquals("Sorry, your account is locked.", msg);
	}
	
	private void login() {
		String USERNAME = user;
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
