package com.easytox.automation.steps.addPhysicians;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.easytox.automation.driver.DriverBase;
import com.easytox.automation.utils.WebElementHelper;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class NavigatingToNextPrevPageSteps {
	
	private WebDriver driver;
	private WebElementHelper webElementHelper;
	private int activePage;
	
	public NavigatingToNextPrevPageSteps() {
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
	
	@When("^clicked on next button$")
	public void clicked_on_next_button() throws Throwable {
		Thread.sleep(1000);
		WebElement next = driver.findElement(By.cssSelector(".next > a"));
		
		if(next.isEnabled()) {
			next.click();
			activePage = Integer.parseInt(driver.findElement(By.cssSelector(".pagination li.active a")).getText());
		}
	}
	
	@Then("^the user should be able to navigate to the next page$")
	public void the_user_should_be_able_to_navigate_to_the_next_page() throws Throwable {
		Assert.assertTrue(activePage == Integer.parseInt(driver.findElement(By.cssSelector(".pagination li.active a")).getText()));
	}
	
	@When("^clicked on Prev button$")
	public void clicked_on_Prev_button() throws Throwable {
		Thread.sleep(1000);
		WebElement prev = driver.findElement(By.cssSelector(".prev > a"));
		
		if(prev.isEnabled()) {
			prev.click();
			activePage = Integer.parseInt(driver.findElement(By.cssSelector(".pagination li.active a")).getText());
		}
	}
	
	@Then("^the user should be able to navigate to the Previous page$")
	public void the_user_should_be_able_to_navigate_to_the_Previous_page() throws Throwable {
		Assert.assertTrue(activePage == Integer.parseInt(driver.findElement(By.cssSelector(".pagination li.active a")).getText()));
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
