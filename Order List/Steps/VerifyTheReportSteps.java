package com.easytox.automation.steps.orderList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.easytox.automation.driver.DriverBase;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class VerifyTheReportSteps {
	private WebDriver driver;
	
	public VerifyTheReportSteps() {
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
		username.clear();
		username.sendKeys(USERNAME);
		
		WebElement password = driver.findElement(By.name(FIND_PASSWORD));
		password.clear();
		password.sendKeys(PASSWORD);
		
		driver.findElement(By.cssSelector(".btn")).click();
	}

	@When("^Verify the Report column for finilized orders$")
	public void verify_the_Report_column_for_finilized_orders() throws Throwable {
		Thread.sleep(2000);
	}

	@Then("^A PDF icon for viewing the report should be diplayed$")
	public void a_PDF_icon_for_viewing_the_report_should_be_diplayed() throws Throwable {
		driver.findElement(By.cssSelector(".fa-file-pdf-o"));
	}

	@When("^Click on PDF icon under the column 'Report'$")
	public void click_on_PDF_icon_under_the_column_Report() throws Throwable {
		driver.findElement(By.cssSelector(".fa-file-pdf-o")).click();
	}

	@Then("^A 'Order' report should be generated and an 'eye' icon should be displayed beside the 'Pdf' icon under Report column$")
	public void a_Order_report_should_be_generated_and_an_eye_icon_should_be_displayed_beside_the_Pdf_icon_under_Report_column() throws Throwable {
		driver.findElement(By.cssSelector(".fa-eye"));
	}

	@When("^Verify report hax been viewed$")
	public void verify_report_hax_been_viewed() throws Throwable {
		Thread.sleep(2000);
	}

	@Then("^'Eye' icon should be diaplyed beside the pdf icon mouse hover the icon it displayes the text message 'Report has been viewed'$")
	public void eye_icon_should_be_diaplyed_beside_the_pdf_icon_mouse_hover_the_icon_it_displayes_the_text_message_Report_has_been_viewed() throws Throwable {
		Actions action = new Actions(driver);
		WebElement element = driver.findElement(By.cssSelector(".fa-eye"));
		action.moveToElement(element).perform();
		
		Assert.assertEquals(driver.findElement(By.cssSelector(".fa-eye")).getAttribute("title"), "Report has been viewed");
	}
}
