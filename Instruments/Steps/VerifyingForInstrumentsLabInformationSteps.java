package com.easytox.automation.steps.Instruments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.easytox.automation.driver.DriverBase;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class VerifyingForInstrumentsLabInformationSteps {
	private WebDriver driver;
	
	public VerifyingForInstrumentsLabInformationSteps() {
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

	@When("^Click on '\\+' icon beside the record in results list$")
	public void click_on_icon_beside_the_record_in_results_list() throws Throwable {
		driver.navigate().to("http://bmtechsol.com:8080/easytox/instruments/list");
		
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".sorting_1")).click();
		Thread.sleep(2000);
	}

	@Then("^Selected Instrument lab Name and  credential information should be displayed in a popup window$")
	public void selected_Instrument_lab_Name_and_credential_information_should_be_displayed_in_a_popup_window() throws Throwable {
		WebElement tableBody = driver.findElement(By.tagName("tbody"));
		List<WebElement> rows = tableBody.findElements(By.tagName("tr"));
		String classAtr = "";
		
		for (WebElement row : rows) {
			if(row.getAttribute("class").contains("shown")) {
				classAtr = row.getAttribute("class");
			}
		}
		
		Assert.assertTrue(classAtr.contains("shown"));
	}
}
