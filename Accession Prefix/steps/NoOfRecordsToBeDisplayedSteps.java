package com.easytox.automation.steps;

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

public class NoOfRecordsToBeDisplayed {
	
	private WebDriver driver;
	private WebElementHelper webElementHelper;
	
	public NoOfRecordsToBeDisplayed() {
		DriverBase.instantiateDriverObject();
		webElementHelper = new WebElementHelper();
		driver = DriverBase.getDriver();
	}
	
	@Given("^the user is Accession Prefix page$")
	public void the_user_is_Accession_Prefix_page() throws Throwable {
		user_should_be_login_to_the_lab();
		driver.navigate().to("http://bmtechsol.com:8080/easytox/accessionPrefixes/list");
	}

	@When("^clicked on dropdown that shows no of records to be displayed on the page$")
	public void clicked_on_dropdown_that_shows_no_of_records_to_be_displayed_on_the_page() throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.name("example_length")).click();
		Thread.sleep(2000);
	}

	@Then("^user should be able to view and select the options from the list and the corresponding number of records should be displayed on the page$")
	public void user_should_be_able_to_view_and_select_the_options_from_the_list_and_the_corresponding_number_of_records_should_be_displayed_on_the_page() throws Throwable {
		Select dropdown = new Select (driver.findElement(By.name("example_length")));
		dropdown.selectByIndex(1);
		Thread.sleep(2000);
		
		WebElement table = driver.findElement(By.id("example"));
		int rowsCount;
		
		for (int i = 0; i < 4; i++) {
			dropdown.selectByIndex(i);
			int value = Integer.parseInt(dropdown.getFirstSelectedOption().getText());
			rowsCount = table.findElements(By.xpath("//table[@id='example']/tbody/tr")).size();
			
			Assert.assertTrue(rowsCount <= value);
			
			Thread.sleep(2000);
		}
	}
	
	
	public void user_should_be_login_to_the_lab() throws Throwable {
		String USERNAME = "lavanya1";
		String PASSWORD = "P@ssw0rd123";
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
