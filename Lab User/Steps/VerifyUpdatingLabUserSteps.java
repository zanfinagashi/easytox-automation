package com.easytox.automation.steps.labUser;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.easytox.automation.driver.DriverBase;
import com.easytox.automation.utils.WebElementHelper;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class VerifyUpdatingLabUserSteps {
	
	private WebDriver driver;
	private WebElementHelper WebElementHelper;
	private String user;
	
	public VerifyUpdatingLabUserSteps() {
		DriverBase.instantiateDriverObject();
		WebElementHelper = new WebElementHelper();
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
		driver.findElement(By.cssSelector(".fa-pencil-square-o")).click();
	}

	@Then("^Edit lab User screen is displayed$")
	public void edit_lab_User_screen_is_displayed() throws Throwable {
		Assert.assertEquals("http://bmtechsol.com:8080/easytox/user/edit", driver.getCurrentUrl());
	}

	@When("^Verify User Information section$")
	public void verify_User_Information_section() throws Throwable {
		driver.findElement(By.name("username"));
		driver.findElement(By.name("password"));
	}

	@Then("^User Information should be locked for editing$")
	public void user_Information_should_be_locked_for_editing() throws Throwable {
		Assert.assertFalse(driver.findElement(By.name("username")).isEnabled());
		Assert.assertFalse(driver.findElement(By.name("password")).isEnabled());
	}

	@When("^Make changes to Personal Information and click update$")
	public void make_changes_to_Personal_Information_and_click_update() throws Throwable {
		Thread.sleep(2000);
		WebElement form = driver.findElement(By.id("form"));
		
		form.findElement(By.name("lastName")).sendKeys(Keys.chord(Keys.CONTROL, "a"), "LastCGi");
		user = form.findElement(By.name("username")).getText();
		Thread.sleep(2000);
		form.findElement(By.cssSelector(".btn-danger")).click();
	}

	@Then("^Changes made to personal information should be saved successfully$")
	public void changes_made_to_personal_information_should_be_saved_successfully() throws Throwable {
		driver.findElement(By.cssSelector(".alert-success "));
	}

	@When("^Click \"([^\"]*)\" icon against newly created user$")
	public void click_icon_against_newly_created_user(String arg1) throws Throwable {
		Thread.sleep(2000);
		Select list = new Select(driver.findElement(By.name("example_length")));
		list.selectByValue("-1");
		Thread.sleep(1000);
		WebElement table = driver.findElement(By.cssSelector("#example"));
		List<WebElement> rows = table.findElements(By.xpath("//table[@id='example']/tbody/tr"));
		for(int i=1;i<=rows.size();i++) {
			String cell = driver.findElement(By.xpath("//table[@id='example']/tbody/tr["+i+"]/td[2]")).getText();
			if(cell.contains(user)){
				driver.findElement(By.xpath("//table[@id='example']/tbody/tr["+i+"]/td[1]")).click();
				break;
			}
		}
	}

	@Then("^Following values should be populated with updated information$")
	public void following_values_should_be_populated_with_updated_information() throws Throwable {
		Thread.sleep(2000);
		WebElement tableRow = driver.findElement(By.cssSelector(".shown + tr"));
		WebElement table = tableRow.findElement(By.cssSelector(".table"));
		
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		
		for (WebElement row : rows) {
			Assert.assertTrue(!row.getText().isEmpty());
		}
	}
}
