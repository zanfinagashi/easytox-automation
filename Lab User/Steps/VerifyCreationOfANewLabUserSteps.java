package com.easytox.automation.steps;

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

public class VerifyCreationOfANewLabUserSteps {
	private WebDriver driver;
	private WebElementHelper webElementHelper;
	private String user;
	
	public VerifyCreationOfANewLabUserSteps() {
		DriverBase.instantiateDriverObject();
		webElementHelper = new WebElementHelper();
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

        WebElement psw = driver.findElement(By.name(FIND_PASSWORD));
        psw.clear();
        psw.sendKeys(PASSWORD);

        driver.findElement(By.xpath("//*[@id=\"loginform\"]/div[3]/div/button")).click();
	}
	
	@When("^Select Settings -> User$")
	public void select_Settings_User() throws Throwable {
		user_List_screen_with_list_of_users_is_displayed();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".account-area > li:nth-child(8) > a")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".account-area > li:nth-child(8) > ul > li:first-child > a")).click();
        Thread.sleep(3000);
	}

	@Then("^User List screen with list of users is displayed$")
	public void user_List_screen_with_list_of_users_is_displayed() throws Throwable {
	}

	@When("^Click Add User \"([^\"]*)\" icon displayed$")
	public void click_Add_User_icon_displayed(String arg1) throws Throwable {
		driver.findElement(By.cssSelector(".fa-plus-circle")).click();
		Thread.sleep(2000);
	}

	@Then("^Add Lab User screen is displayed$")
	public void add_Lab_User_screen_is_displayed() throws Throwable {
		Assert.assertEquals("http://bmtechsol.com:8080/easytox/user/create", driver.getCurrentUrl());
	}

	@When("^Enter User Information, Personal Information and Lab Information and click Add User$")
	public void enter_User_Information_Personal_Information_and_Lab_Information_and_click_Add_User() throws Throwable {
		user = "testJunit2";
		driver.findElement(By.name("username")).sendKeys(user);
		driver.findElement(By.name("password")).sendKeys("Welcome@123");
		
		WebElement form = driver.findElement(By.cssSelector("#registration-form"));
		form.findElement(By.name("firstName")).sendKeys("test");
		form.findElement(By.name("lastName")).sendKeys("Junit");
		driver.findElement(By.name("email")).sendKeys("test@email.com");
		//driver.findElement(By.name("contact")).sendKeys("9999999999");
		
		Select roles = new Select (driver.findElement(By.name("roles")));
		roles.selectByIndex(1);
		
		form.findElement(By.cssSelector(".btn-primary")).click();
	}

	@Then("^New user is added successfully and newly added user is listed in the User List screen$")
	public void new_user_is_added_successfully_and_newly_added_user_is_listed_in_the_User_List_screen() throws Throwable {
		driver.findElement(By.cssSelector(".alert-success"));
	}

	@When("^Click \"([^\"]*)\" icon against newly created user$")
	public void click_icon_against_newly_created_user(String arg1) throws Throwable {
		Select list = new Select(driver.findElement(By.name("example_length")));
		list.selectByValue("-1");
		Thread.sleep(1000);
		WebElement table = driver.findElement(By.cssSelector("#example"));
		List<WebElement> rows = table.findElements(By.xpath("//table[@id='example']/tbody/tr"));
		for(int i=1;i<=rows.size();i++) {
			String cell = driver.findElement(By.xpath("//table[@id='example']/tbody/tr["+i+"]/td[2]")).getText();
			if(cell.contains(user)){
				driver.findElement(By.xpath("//table[@id='example']/tbody/tr["+i+"]/td[1]")).click();
			}
		}
	}

	@Then("^Following values should be populated$")
	public void following_values_should_be_populated() throws Throwable {
		WebElement tableRow = driver.findElement(By.cssSelector(".shown + tr"));
		WebElement table = tableRow.findElement(By.cssSelector(".table"));
		
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		
		for (WebElement row : rows) {
			Assert.assertTrue(!row.getText().isEmpty());
		}
	}
}
