package com.easytox.automation.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.easytox.automation.driver.DriverBase;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class VerifyTheLabInformationSteps {
	private WebDriver driver;
	
	public VerifyTheLabInformationSteps() {
		DriverBase.instantiateDriverObject();
		driver = DriverBase.getDriver();
	}
	
	@Given("^User should be login to lab$")
	public void user_should_be_login_to_lab() throws Throwable {
		String USERNAME = "superadmin";
		String PASSWORD = "admin";
		String FIND_USERNAME = "j_username";
		String FIND_PASSWORD = "j_password";
		String URL = "http://bmtechsol.com:8080/easytox/";
		
		driver.navigate().to(URL);
		
		WebElement username = driver.findElement(By.name(FIND_USERNAME));
		username.clear();
		username.sendKeys(USERNAME);
		
		WebElement password = driver.findElement(By.name(FIND_PASSWORD));
		password.clear();
		password.sendKeys(PASSWORD);
		
		driver.findElement(By.cssSelector(".btn")).click();
	}

	@When("^Click on '\\+' icon against the lab client record in results list$")
	public void click_on_icon_against_the_lab_client_record_in_results_list() throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".fa-list-ul")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#example > tbody .details-control")).click();
	}

	@Then("^Existing Lab Client Following values should be populated: Address: Address(\\d+),address(\\d+)  Lab: LabTest$")
	public void existing_Lab_Client_Following_values_should_be_populated_Address_Address_address_Lab_LabTest(int arg1, int arg2) throws Throwable {
		Thread.sleep(4000);
		driver.findElement(By.cssSelector("#example > tbody .table"));
	}

}
