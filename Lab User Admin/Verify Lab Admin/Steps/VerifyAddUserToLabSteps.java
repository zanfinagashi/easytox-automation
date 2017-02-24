package com.easytox.automation.steps.labUserAdmin.verifyLabAdmin;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.easytox.automation.driver.DriverBase;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class VerifyAddUserToLabSteps {
	private WebDriver driver;
	
	public VerifyAddUserToLabSteps() {
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

	@When("^Click on lab name$")
	public void click_on_lab_name() throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.linkText("RLab")).click();
	}

	@Then("^'Update lab' screen should be displayed$")
	public void update_lab_screen_should_be_displayed() throws Throwable {
		Assert.assertEquals(driver.getCurrentUrl(), "http://bmtechsol.com:8080/easytox/lab/edit");
	}

	@When("^Click on 'User\\+' icon on the right corner of the Update lab screen$")
	public void click_on_User_icon_on_the_right_corner_of_the_Update_lab_screen() throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".fa-user-plus")).click();
	}

	@Then("^'Add Lab Admin User' screen should be diplayed$")
	public void add_Lab_Admin_User_screen_should_be_diplayed() throws Throwable {
		Assert.assertEquals(driver.getCurrentUrl(), "http://bmtechsol.com:8080/easytox/user/create");
	}

	@When("^Enter User Information, Personal Information and Lab  Information and click Add User$")
	public void enter_User_Information_Personal_Information_and_Lab_Information_and_click_Add_User() throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.name("username")).sendKeys("zanfina1");
		driver.findElement(By.name("password")).sendKeys("Welcome@123");
		driver.findElement(By.name("firstName")).sendKeys("Zanfina");
		driver.findElement(By.name("lastName")).sendKeys("Gashi");
		driver.findElement(By.name("email")).sendKeys("zgashi@email.com");
		driver.findElement(By.name("contact")).sendKeys(String.valueOf(1234567890));
		Select select = new Select(driver.findElement(By.name("roles")));
		select.selectByValue("LAB_ADMIN");
		
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#registration-form .btn")).click();
		Thread.sleep(5000);
	}

	@Then("^New user is added successfully and newly added user is listed in the Lab admin User List screen$")
	public void new_user_is_added_successfully_and_newly_added_user_is_listed_in_the_Lab_admin_User_List_screen() throws Throwable {
		Thread.sleep(5000);
		driver.findElement(By.cssSelector(".alert-success"));
		
		Thread.sleep(2000);
		List<WebElement> cells = driver.findElements(By.cssSelector("#example tbody tr > td:nth-child(2)"));
		
		for (WebElement cell : cells) {
			if(cell.getText().equals("zanfina1")) {
				Assert.assertTrue(cell.getText().equals("zanfina1"));
			}
		}
	}
}
