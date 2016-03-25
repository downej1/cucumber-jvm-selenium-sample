package org.freecoders.cucumber_jvm.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.*;

import org.junit.Test;

public class Stepdefs {
	private WebDriver driver;
	@Before
	public void before() {
		this.driver = new FirefoxDriver();
	}
	@After
	public void after() {
		this.driver.quit();
	}
		
	@Given("^I navigate to the IST website$")
	public void i_navigate_to_the_IST_website() throws Throwable {
		driver.get("http://webcache.googleusercontent.com/search?q=cache:UOZGrE88MX8J:istresearch.com/+&cd=1&hl=en&ct=clnk&gl=us");
		
		
	}
	@Then("^I should see the \"([^\"]*)\" menu item$")
	public void i_should_see_the_menu_item(String inItem) throws Throwable {
		List<WebElement> items = driver.findElements(By.cssSelector("#header > div > div.primary-nav > ul > li"));
		String itemText = null;
		for (WebElement item : items) {
			if (item.getText().equalsIgnoreCase(inItem)){
				itemText = item.getText();
				break;
			}
		}
		assertNotNull(itemText);
	}
	
	@Given("^I navigate to google$")
	public void i_navigate_to_google() throws Throwable {
	    driver.get("http://www.google.com/");
	}

	@When("^I google \"([^\"]*)\"$")
	public void i_google(String search) throws Throwable {
		WebElement searchInput = driver.findElement(By.id("lst-ib"));
		searchInput.sendKeys(search);
		searchInput.submit();
	}


	@Then("^IST Research is the first result$")
	public void ist_Research_is_the_first_result() throws Throwable {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement topResult = wait.until(
		        ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#rso > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > h3:nth-child(1) > a")));
	    String href = topResult.getAttribute("href");
	    assertEquals(href,"http://istresearch.com/");
	}

}
