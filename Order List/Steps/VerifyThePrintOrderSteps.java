package com.easytox.automation.steps.orderList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.easytox.automation.driver.DriverBase;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class VerifyThePrintOrderSteps {
	private WebDriver driver;
	
	public VerifyThePrintOrderSteps() {
		DriverBase.instantiateDriverObject();
		driver = DriverBase.getDriver();
	}
	
	@Given("^User should be login to lab$")
	public void user_should_be_login_to_lab() throws Throwable {
		String USERNAME = "cgiclinician1";
		String PASSWORD = "Welcome@123";
		String FIND_USERNAME = "j_username";
		String FIND_PASSWORD = "j_password";
		String URL = "http://bmtechsol.com/easytox";
		
		driver.navigate().to(URL);
		
		WebElement username = driver.findElement(By.name(FIND_USERNAME));
		username.click();
		username.sendKeys(USERNAME);
		
		WebElement password = driver.findElement(By.name(FIND_PASSWORD));
		password.clear();
		password.sendKeys(PASSWORD);
		
		driver.findElement(By.cssSelector(".btn")).click();
	}
	
	@When("^Click on PDF icon under the column 'Print Order'$")
	public void click_on_PDF_icon_under_the_column_Print_Order() throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#caseorder tbody > tr > td:nth-child(10) .fa-file-pdf-o")).click();
	}

	@Then("^Order report should be printed$")
	public void order_report_should_be_printed() throws Throwable {
		driver.navigate().refresh();
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.cssSelector("#caseorder tbody > tr > td:nth-child(10) .fa-eye")).getAttribute("title"), "Order has been printed");
	}

}
