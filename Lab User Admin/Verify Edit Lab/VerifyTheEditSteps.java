package com.easytox.automation.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.easytox.automation.driver.DriverBase;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class VerifyTheEditSteps {
	private WebDriver driver;
	
	public VerifyTheEditSteps() {
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

	@When("^Click on User List Icon under 'action' column$")
	public void click_on_User_List_Icon_under_action_column() throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".fa-users")).click();
	}

	@Then("^Lab User List should be displayed$")
	public void lab_User_List_should_be_displayed() throws Throwable {
		Assert.assertEquals(driver.getCurrentUrl(), "http://bmtechsol.com:8080/easytox/user/list");
	}

	@When("^Click on Edit icon$")
	public void click_on_Edit_icon() throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".fa-pencil-square-o")).click();
	}

	@Then("^Update Lab Admin User screen should be displayed successfully and the followinginformation should be displayed on the screen  User Information, Personal Information$")
	public void update_Lab_Admin_User_screen_should_be_displayed_successfully_and_the_followinginformation_should_be_displayed_on_the_screen_User_Information_Personal_Information() throws Throwable {
		Assert.assertEquals(driver.getCurrentUrl(), "http://bmtechsol.com:8080/easytox/user/edit");
	}

	@When("^User information is not editable$")
	public void user_information_is_not_editable() throws Throwable {
		Thread.sleep(2000);
		Assert.assertFalse(driver.findElement(By.name("username")).isEnabled());
		Assert.assertFalse(driver.findElement(By.name("password")).isEnabled());
	}

	@Then("^User information should be disabled and grayed out$")
	public void user_information_should_be_disabled_and_grayed_out() throws Throwable {
		Thread.sleep(2000);
		Assert.assertFalse(driver.findElement(By.name("username")).isEnabled());
		Assert.assertFalse(driver.findElement(By.name("password")).isEnabled());
	}

	@When("^Personal information is editable and click on 'Update' button$")
	public void personal_information_is_editable_and_click_on_Update_button() throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".widget-body .btn")).click();
	}

	@Then("^Personal information should be editable and and all the information should be updated successfully$")
	public void personal_information_should_be_editable_and_and_all_the_information_should_be_updated_successfully() throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".alert-success"));
	}
}
