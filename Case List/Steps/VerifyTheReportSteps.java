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

public class VerifyTheReportSteps {
	private WebDriver driver;
	private WebElement row;
	
	public VerifyTheReportSteps() {
		DriverBase.instantiateDriverObject();
		driver = DriverBase.getDriver();
	}
	
	@Given("^User should be login to the lab$")
	public void user_should_be_login_to_the_lab() throws Throwable {
		String USERNAME = "SNOneAdmin";
		String PASSWORD = "Test@123";
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

        driver.findElement(By.cssSelector(".btn")).click();
	}
	
	@SuppressWarnings("unused")
	@When("^Verify the Report column for finalized cases\\.$")
	public void verify_the_Report_column_for_finalized_cases() throws Throwable {
		Thread.sleep(5000);
		WebElement tableBody = driver.findElement(By.xpath("//table[@id='caseorder']/tbody"));
		
		List<WebElement> rows = tableBody.findElements(By.tagName("tr"));
		for(int i=1;i<=rows.size();i++) {
			row = driver.findElement(By.xpath("//table[@id='caseorder']/tbody/tr["+i+"]"));
			String cell = row.findElement(By.xpath("//td[7]")).getText();
			Assert.assertTrue(cell.contains("finalized"));
			break;
		}
	}

	@Then("^A PDF icon for viewing the report should be displayed\\.$")
	public void a_PDF_icon_for_viewing_the_report_should_be_displayed() throws Throwable {
		System.out.println(row.getAttribute("innerHTML"));
		if(row != null) {
			row.findElement(By.cssSelector(".fa-file-pdf-o"));
		}
	}

	@When("^Click on PDF icon under the column \"([^\"]*)\"$")
	public void click_on_PDF_icon_under_the_column(String arg1) throws Throwable {
		if(row != null) {
			row.findElement(By.cssSelector(".fa-file-pdf-o")).click();
		}
	}

	@Then("^A case report should be displayed$")
	public void a_case_report_should_be_displayed() throws Throwable {
	}
}
