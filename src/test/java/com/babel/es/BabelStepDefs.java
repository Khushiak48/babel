package com.babel.es;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * @author Khushboo Taneja
 *
 */
public class BabelStepDefs {

	private HomePage homePage;

	private AboutBabel aboutbabel;

	private Service service;

	private Solutions solutions;

	private Specialized specialized;

	private People people;

	private DigitalUser digitalUser;
	
	private DirectWriter directWriter;

	private WebDriver driver;

	@Given("^Go to \"([^\"]*)\"$")
	public void go_to_something(String url) throws Throwable {
		driver = new FirefoxDriver();
		driver.get(url);
	}

	@Given("^Maximize the window$")
	public void maximize_the_window() throws Throwable {
		driver.manage().window().maximize();
	}

	@Given("^Set the implicitly time$")
	public void set_the_implicitly_time() throws Throwable {
		// time issue on UI browser that is not holding the page
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}


	@Given("^Keep the mouse on services heading$")
	public void keep_the_mouse_on_services_heading() throws Throwable {
		homePage = new HomePage(driver);
		homePage.hoverServices();
	}

	// issue : i want hold my page after click button
	@When("^I click on \"([^\"]*)\"$")
	public void i_click_on(String userDigital) throws Throwable {
		homePage = new HomePage(driver);
		homePage.clickOnDigitalUser();
	}

	@Then("^Verify the heading \"([^\"]*)\"$")
	public void verify_the_heading(String user) throws Throwable {
		digitalUser = new DigitalUser(driver);
		digitalUser.getUserHeading();
		Assert.assertEquals(user, digitalUser.getUserHeading());
	}

	@When("^I click on type of sub- services (.+)$")
	public void i_click_on_type_of_sub_services(String services) throws Throwable {
		homePage = new HomePage(driver);
		homePage.clickOnSubServices(services);
	}

	@Then("^Verify all the (.+) of sub-services page$")
	public void verify_all_the_of_subservices_page(String title) throws Throwable {
		System.out.println("*********************** driver.getTitle()*****************************" +  driver.getTitle() );
		Assert.assertTrue(driver.getTitle().contains(title));
//		Assert.assertEquals(title, driver.getTitle());
	} 

	@Given("^Keep the mouse on about babel heading$")
	public void keep_the_mouse_on_about_babel_heading() throws Throwable {
		homePage = new HomePage(driver);
		homePage.hoverAboutBabel();
	}

	@When("^I click types of (.+)$")
	public void i_click_types_of(String aboutbabel) throws Throwable {
		homePage = new HomePage(driver);
		homePage.clickOnAboutBabelSection(aboutbabel);
	}

	@Then("^Verify all the (.+),(.+) of sub-link page$")
	public void verify_all_the_of_sublink_page(String title, String url) throws Throwable {
		System.out.println("expected title : " + title);
		System.out.println("expected url : " + url);
		// verifying the title and url
		Assert.assertTrue(driver.getTitle().contains(title));
//		Assert.assertEquals(title, driver.getTitle());
		Assert.assertEquals(url, driver.getCurrentUrl());
	}

	@Given("^Keep the mouse on solutions heading$")
	public void keep_the_mouse_on_solutions_heading() throws Throwable {
		homePage = new HomePage(driver);
		homePage.hoverSolutions();
	}

	@When("^I click on type of solutions (.+)$")
	public void i_click_on_type_of_solutions(String solutions) throws Throwable {
		homePage = new HomePage(driver);
		homePage.clickOnSubSolutions(solutions);
	}

	@Then("^Verify all the (.+),(.+) of sub-solution page$")
	public void verify_all_the_of_subsolution_page(String title, String url) throws Throwable {
		// verifying the title and url
		//Assert.assertEquals(title, driver.getTitle());
		Assert.assertTrue(driver.getTitle().contains(title));
		Assert.assertEquals(url, driver.getCurrentUrl());
		
	}

	@When("^I click on Direct Writer$")
	public void i_click_on_Direct_Writer() throws Throwable {
		homePage = new HomePage(driver);
		homePage.clickOnDirectWriter();
	}

	@When("^Scroll down the page$")
	public void scroll_down_the_page() throws Throwable {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,950)", "");
		Thread.sleep(5000);
	}

	@Then("^Verify the insurance management platform tabs (.+)$")
	public void verify_the_insurance_management_platform_tabs_(String directwriter) throws Throwable {
		directWriter = new DirectWriter(driver);
		Assert.assertEquals(directwriter, directWriter.getTabName(directwriter));
	}


	@After
	public void close() {
		driver.quit();
	}

}
