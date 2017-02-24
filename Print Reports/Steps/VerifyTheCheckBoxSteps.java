package com.easytox.automation.steps.printReports;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.easytox.automation.driver.DriverBase;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class VerifyTheCheckBoxSteps {
	private WebDriver driver;
	
	public VerifyTheCheckBoxSteps() {
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

	@When("^Select the records that need to be printed and click on print$")
	public void select_the_records_that_need_to_be_printed_and_click_on_print() throws Throwable {
		driver.navigate().to("http://bmtechsol.com:8080/easytox/caseOrder/finalizedCaselist");
		
		Thread.sleep(2000);
		WebElement checkBox = driver.findElement(By.id("chkCase"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", checkBox);
		
		driver.findElement(By.cssSelector("#batchPrintForm .fa-print")).click();
		Thread.sleep(2000);
	}

	@Then("^'Success Print Jobs are being executed \\.\\.\\.\\.' text message should be displayed on above the finalized case list screen$")
	public void success_Print_Jobs_are_being_executed_text_message_should_be_displayed_on_above_the_finalized_case_list_screen() throws Throwable {
		driver.findElement(By.cssSelector("#printModal"));
	}
}
