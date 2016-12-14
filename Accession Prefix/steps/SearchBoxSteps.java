package com.easytox.automation.steps;

import java.util.List;

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

public class SearchBoxSteps {
	private static final String USERNAME = "lavanya1";
	private static final String PASSWORD = "P@ssw0rd123";
	private static final String FIND_USERNAME = "j_username";
    private static final String FIND_PASSWORD = "j_password";
	private static final String URL = "http://bmtechsol.com:8080/easytox/";
	
	private WebDriver driver;
	private WebElementHelper webElmentHelper;
	
	public SearchBoxSteps() {
		DriverBase.instantiateDriverObject();
		this.webElmentHelper = new WebElementHelper();
		this.driver = DriverBase.getDriver();
	}

	@Given("^the user is on Accession Prefix page$")
	public void the_user_is_on_Accession_Prefix_page() throws Throwable {
		user_should_be_login_to_the_lab();
		driver.navigate().to("http://bmtechsol.com:8080/easytox/accessionPrefixes/list");
	}

	@When("^entered some text in the Searchbox$")
	public void entered_some_text_in_the_Searchbox() throws Throwable {
		Thread.sleep(2000);
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.cssSelector("#example_filter > label")));
		actions.click();
		actions.sendKeys("Urine");
		actions.build().perform();
		Thread.sleep(2000);
	}

	@Then("^user should be able to view the search results$")
	public void user_should_be_able_to_view_the_search_results() throws Throwable {
		WebElement table = driver.findElement(By.id("example"));
		List<WebElement> rows = table.findElements(By.xpath("//table[@id='example']/tbody/tr"));
		for(int i=1;i<=rows.size();i++) {
			String cell = driver.findElement(By.xpath("//table[@id='example']/tbody/tr["+i+"]/td[2]")).getText();
			Assert.assertTrue(cell.contains("Urine"));
		}
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
