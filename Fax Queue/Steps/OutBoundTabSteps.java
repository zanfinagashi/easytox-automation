package com.easytox.automation.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.easytox.automation.driver.DriverBase;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class OutBoundTabSteps {
	private WebDriver driver;
	
	public OutBoundTabSteps() {
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

	@When("^click on 'OutBound' tab$")
	public void click_on_OutBound_tab() throws Throwable {
		Thread.sleep(2000);
		driver.navigate().to("http://bmtechsol.com:8080/easytox/queue/faxlist");
		Thread.sleep(2000);
		
		driver.findElement(By.cssSelector("#tabs > li"));
		Thread.sleep(2000);
	}

	@Then("^OutBoundFax Queue page should be displayed with (\\d+) tabs (\\d+)\\. Pending (\\d+)\\. Sent (\\d+)\\. Faillure$")
	public void outboundfax_Queue_page_should_be_displayed_with_tabs_Pending_Sent_Faillure(int arg1, int arg2, int arg3, int arg4) throws Throwable {
		String outbound[] = {"Pending", "Sent", "failure"};
		
		for (int i = 0; i < 3; i++) {
			String value = driver.findElement(By.cssSelector("#outboundtab ul > li:nth-child(" + (i + 1) + ") a")).getText();
			Assert.assertEquals(value, outbound[i]);
		}
	}
}
