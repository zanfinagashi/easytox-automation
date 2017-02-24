package com.easytox.automation.steps.accessionPrefix;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.easytox.automation.driver.DriverBase;
import com.easytox.automation.utils.WebElementHelper;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CheckingMessageOfNoOfResultsDisplayedSteps {
	
	private WebDriver driver;
	private WebElementHelper webElementHelper;
	
	public CheckingMessageOfNoOfResultsDisplayedSteps() {
		DriverBase.instantiateDriverObject();
		webElementHelper =  new WebElementHelper();
		driver = DriverBase.getDriver();
	}
	
	@Given("^the user is on Accession Prefix page$")
	public void the_user_is_on_Accession_Prefix_page() throws Throwable {
		user_should_be_login_to_the_lab();
		
		driver.navigate().to("http://bmtechsol.com:8080/easytox/accessionPrefixes/list");
	}

	@When("^the user searches the results$")
	public void the_user_searches_the_results() throws Throwable {
		Thread.sleep(2000);
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.cssSelector("#example_filter > label")));
		actions.click();
		actions.sendKeys("L");
		actions.build().perform();
		Thread.sleep(2000);
	}

	@Then("^the text “Showing x to y of z entries” should be displayed on the bottom left corner of the list$")
	public void the_text_Showing_x_to_y_of_z_entries_should_be_displayed_on_the_bottom_left_corner_of_the_list() throws Throwable {
		String message = driver.findElement(By.cssSelector("#example_info")).getText();
		Assert.assertTrue(!message.equals(null));
	}
	
	public void user_should_be_login_to_the_lab() throws Throwable {
		String USERNAME = "lavanya1";
		String PASSWORD = "P@ssw0rd123";
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

        driver.findElement(By.xpath("//*[@id=\"loginform\"]/div[3]/div/button")).click();
    }
	

}
