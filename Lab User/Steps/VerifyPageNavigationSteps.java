package com.easytox.automation.steps.labUser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.easytox.automation.driver.DriverBase;
import com.easytox.automation.utils.WebElementHelper;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class VerifyPageNavigationSteps {
	private WebDriver driver;
	private WebElementHelper webElementHelper;
	private int activePage;
	
	public VerifyPageNavigationSteps() {
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

	@When("^Navigate back and forth by selecting page numbers \"([^\"]*)\"$")
	public void navigate_back_and_forth_by_selecting_page_numbers(String arg1) throws Throwable {
		Thread.sleep(1000);
		WebElement next = driver.findElement(By.cssSelector(".next > a"));
		WebElement prev = driver.findElement(By.cssSelector(".prev > a"));
		
		while(!driver.findElement(By.cssSelector(".next")).getAttribute("class").contains("disabled")) {
			next.click();
			activePage = Integer.parseInt(driver.findElement(By.cssSelector(".pagination li.active a")).getText());
			Thread.sleep(500);
		}
		
		while(!driver.findElement(By.cssSelector(".prev")).getAttribute("class").contains("disabled")) {
			prev.click();
			activePage = Integer.parseInt(driver.findElement(By.cssSelector(".pagination li.active a")).getText());
			Thread.sleep(500);
		}
	}

	@Then("^User should be navigate to the selected page$")
	public void user_should_be_navigate_to_the_selected_page() throws Throwable {
		Thread.sleep(1000);
		Assert.assertTrue(activePage == Integer.parseInt(driver.findElement(By.cssSelector(".pagination li.active a")).getText()));
	}

	@When("^Checking the message of no of records displayed on the current page bottom left corner of the screen$")
	public void checking_the_message_of_no_of_records_displayed_on_the_current_page_bottom_left_corner_of_the_screen() throws Throwable {
		Assert.assertTrue(!driver.findElement(By.id("example_info")).getText().equals(null));
	}

	@Then("^A text message “Showing x to y of z entries” should be displayed on the bottom left corner of the list\\.$")
	public void a_text_message_Showing_x_to_y_of_z_entries_should_be_displayed_on_the_bottom_left_corner_of_the_list() throws Throwable {
		String msg = driver.findElement(By.id("example_info")).getText();
		Assert.assertTrue(msg.matches("Showing (\\d)+ to (\\d)+ of (\\d)+ entries"));
	}
	
	private void login() {
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
}
