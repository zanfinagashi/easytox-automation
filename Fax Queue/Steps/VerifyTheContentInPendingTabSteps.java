package com.easytox.automation.steps;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.easytox.automation.driver.DriverBase;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class VerifyTheContentInPendingTabSteps {
	private WebDriver driver;
	
	public VerifyTheContentInPendingTabSteps() {
		DriverBase.instantiateDriverObject();
		driver = DriverBase.getDriver();
	}
	
	@Given("^User should be login to lab$")
	public void user_should_be_login_to_lab() throws Throwable {
		String USERNAME = "cgilabadmin";
		String PASSWORD = "Welcome@123";
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

	@When("^Click on 'Pending' tab$")
	public void click_on_Pending_tab() throws Throwable {
		driver.navigate().to("http://bmtechsol.com:8080/easytox/queue/faxlist");
		
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("a[href = '#pendingjobstab']")).click();
	}

	@Then("^Pending fax queue list should be displayed$")
	public void pending_fax_queue_list_should_be_displayed() throws Throwable {
		Assert.assertEquals(driver.findElement(By.cssSelector("#outboundtab ul > li.active > a")).getText(), "Pending");
	}

	@When("^Enter any search criteria and cilck on search icon$")
	public void enter_any_search_criteria_and_cilck_on_search_icon() throws Throwable {
		WebElement searchBox = driver.findElement(By.cssSelector("#queuetable_filter > label > input"));
		searchBox.clear();
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.cssSelector("#queuetable_filter > label")));
		action.click();
		action.sendKeys("test");
		action.build().perform();
	}

	@Then("^Matching records with entered data should be diplayed in the Fax Queue list$")
	public void matching_records_with_entered_data_should_be_diplayed_in_the_Fax_Queue_list() throws Throwable {
		WebElement tableBody = driver.findElement(By.cssSelector("#queuetable tbody"));
		List<WebElement> cells = tableBody.findElements(By.tagName("td"));
		
		for (WebElement cell : cells) {
			if(cell.getText().equals("test")) {
				Assert.assertTrue(cell.getText().equals("test"));
				break;
			}
		}
	}
}
