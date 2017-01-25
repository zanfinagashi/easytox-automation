package com.easytox.automation.steps;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.easytox.automation.driver.DriverBase;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SelectTheFinalizedStartDateSteps {
	private WebDriver driver;
	
	public SelectTheFinalizedStartDateSteps() {
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

	@When("^Click on the start date field select the date and verify if the correct date is shown in the box$")
	public void click_on_the_start_date_field_select_the_date_and_verify_if_the_correct_date_is_shown_in_the_box() throws Throwable {
		driver.navigate().to("http://bmtechsol.com:8080/easytox/caseOrder/finalizedCaselist");
		
		Thread.sleep(2000);
		
		driver.findElement(By.id("min")).click();
		WebElement table = driver.findElement(By.cssSelector(".datepicker-days table"));
		WebElement datepickerSwitch = table.findElement(By.cssSelector(".datepicker-switch"));
		WebElement prev = table.findElement(By.cssSelector(".prev"));
		
		while(!datepickerSwitch.getText().equals("March 2016")) {
			prev.click();
			Thread.sleep(100);
		}
		
		List<WebElement> cells = table.findElements(By.cssSelector("td"));
		for (WebElement cell : cells) {
			if(cell.getText().equals("8")) {
				cell.click();
				break;
			}
		}
		
		Thread.sleep(2000);
	}

	@Then("^Select date should be diplayed in the date field$")
	public void select_date_should_be_diplayed_in_the_date_field() throws Throwable {
		Assert.assertTrue(driver.findElement(By.id("min")).getAttribute("value").equals("03/08/2016"));
	}
}
