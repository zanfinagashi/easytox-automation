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

public class VerifyDataSortingSteps {
	private WebDriver driver;
	private WebElementHelper webElementHelper;
	private WebElement element;
	
	public VerifyDataSortingSteps() {
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

	@When("^Click on \"([^\"]*)\" down arrow icon on  Sorting  column$")
	public void click_on_down_arrow_icon_on_Sorting_column(String arg1) throws Throwable {
		clickElement(2);
	}

	@Then("^Records should be displayed based on the asecending order of the selected  field$")
	public void records_should_be_displayed_based_on_the_asecending_order_of_the_selected_field() throws Throwable {
		Assert.assertTrue(element.getAttribute("class").equals("sorting_asc"));
	}

	@When("^Click on \"([^\"]*)\" Up arrow icon  on sorting column$")
	public void click_on_Up_arrow_icon_on_sorting_column(String arg1) throws Throwable {
		clickElement(2);
	}

	@Then("^Records should be displayed based on the descending order of the selected field$")
	public void records_should_be_displayed_based_on_the_descending_order_of_the_selected_field() throws Throwable {
		Assert.assertTrue(element.getAttribute("class").equals("sorting_desc"));
	}

	@When("^Repeat Steps (\\d+) and (\\d+) on all the columns$")
	public void repeat_Steps_and_on_all_the_columns(int arg1, int arg2) throws Throwable {
		for (int i = 3; i <= 7; i++) {
			clickElement(i);
			Assert.assertTrue(element.getAttribute("class").equals("sorting_asc"));
			clickElement(i);
			Assert.assertTrue(element.getAttribute("class").equals("sorting_desc"));
		}
	}

	@Then("^Sorting should work on all the columns that has sorting facility$")
	public void sorting_should_work_on_all_the_columns_that_has_sorting_facility() throws Throwable {
		Assert.assertTrue(element.getAttribute("class").equals("sorting_desc"));
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
	
	public void clickElement(int childIndex) throws InterruptedException {
		Thread.sleep(2000);
		element = driver.findElement(By.cssSelector("table > thead > tr > th:nth-child(" + childIndex + ")"));
		element.click();
	}
}
