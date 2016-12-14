package com.easytox.automation.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.easytox.automation.driver.DriverBase;
import com.easytox.automation.utils.WebElementHelper;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SortingOrderSteps {
	private static final String USERNAME = "lavanya1";
	private static final String PASSWORD = "P@ssw0rd123";
	private static final String FIND_USERNAME = "j_username";
    private static final String FIND_PASSWORD = "j_password";
	private static final String URL = "http://bmtechsol.com:8080/easytox/";
	
	private WebDriver driver;
	private WebElementHelper webElementHelper;
	private WebElement element;
	
	public SortingOrderSteps() {
		DriverBase.instantiateDriverObject();
		webElementHelper = new WebElementHelper();
		driver = DriverBase.getDriver();
	}
	
	@Given("^the user is on Accession Prefix page$")
	public void the_user_is_on_Accession_Prefix_page() throws Throwable {
		if(!driver.getCurrentUrl().equals("http://bmtechsol.com:8080/easytox/accessionPrefixes/list")) {
			user_should_be_login_to_the_lab();
			driver.navigate().to("http://bmtechsol.com:8080/easytox/accessionPrefixes/list");
		}
	}

	@When("^clicked on Prefix column of the list$")
	public void clicked_on_Prefix_column_of_the_list() throws Throwable {
		clickElement(1);
	}

	@Then("^the list should be displayed in the alphabetical order$")
	public void the_list_should_be_displayed_in_the_alphabetical_order() throws Throwable {
		Assert.assertEquals(element.getAttribute("aria-sort"), "ascending");
	}

	@When("^clicked on Prefix type column of the list$")
	public void clicked_on_Prefix_type_column_of_the_list() throws Throwable {
		clickElement(2);
	}

	@When("^clicked on Sequence number column of the list$")
	public void clicked_on_Sequence_number_column_of_the_list() throws Throwable {
		clickElement(3);
	}

	@Then("^the list should be displayed in the numerical order$")
	public void the_list_should_be_displayed_in_the_numerical_order() throws Throwable {
		Assert.assertEquals(element.getAttribute("aria-sort"), "ascending");
	}

	@When("^clicked on Default column of the list$")
	public void clicked_on_Default_column_of_the_list() throws Throwable {
		clickElement(4);
	}

	@Then("^the list should be displayed in the order$")
	public void the_list_should_be_displayed_in_the_order() throws Throwable {
		Assert.assertEquals(element.getAttribute("aria-sort"), "ascending");
	}
	
	public void clickElement(int childIndex) throws InterruptedException {
		Thread.sleep(2000);
		element = driver.findElement(By.cssSelector("table > thead > tr > th:nth-child(" + childIndex + ")"));
		element.click();
	}
	
	public void user_should_be_login_to_the_lab() throws Throwable {
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
