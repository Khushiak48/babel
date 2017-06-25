/*package com.babel1.es.backup;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.babel.es.AboutBabel;
import com.babel.es.DigitalUser;
import com.babel.es.HomePage;
import com.babel.es.People;
import com.babel.es.Service;
import com.babel.es.Solutions;
import com.babel.es.Specialized;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

*//**
 * @author Khushboo Taneja
 *
 *//*
public class BabelStepDefs1 {

	private HomePage homePage;

	private AboutBabel aboutbabel;

	private Service service;

	private Solutions solutions;

	private Specialized specialized;

	private People people;

	private DigitalUser digitalUser;

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
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}

	@Given("^I am on homepage$")
	public void i_am_on_homepage() throws Throwable {
	}

	@Given("^I can see the home page video message \"([^\"]*)\" , \"([^\"]*)\"$")
	public void i_can_see_the_home_page_video_message(String videoText, String className) throws Throwable {

		homePage = new HomePage(driver);

		Assert.assertEquals(videoText, homePage.getVideoMessage());
	}

	@When("^Click on About Babel$")
	public void click_on_About_Babel() throws Throwable {
		// driver.findElement(By.xpath("(//a[@href='/en/about-babel'])[1]")).click();

		// TODO why creating an object in every method as aboutbabel = new
		// AboutBabel(driver);
		homePage = new HomePage(driver);
		homePage.clickOnAboutBabel();
	}

	//need to change message
	@Then("^Verify the message \"([^\"]*)\"$")
	public void verify_the_message(String aboutBabelMessage) throws Throwable {

		
		 * WebElement messageOfaboutBabel = driver .findElement(By.
		 * xpath("//div[@class = 'description normal animated margins fadeIn visible']"
		 * )); Assert.assertEquals(aboutBabelMessage,
		 * messageOfaboutBabel.getText());
		 
	//	aboutbabel = new AboutBabel(driver);
		aboutbabel.getAboutBabelMessage();
		System.out.println("expected message ::" + aboutBabelMessage + "::");
		System.out.println("actual message ::" + aboutbabel.getAboutBabelMessage() + "****");
		// Assert.assertEquals(aboutBabelMessage,
		// aboutbabel.getAboutBabelMessage());
		Assert.assertTrue(aboutbabel.getAboutBabelMessage().contains(aboutBabelMessage));
	}

	@When("^Click on Services$")
	public void click_on_Services() throws Throwable {
		homePage = new HomePage(driver);
		homePage.clickOnServices();
	}

	@Then("^Verify the service message \"([^\"]*)\"$")
	public void verify_the_service_message(String serviceMessage) throws Throwable {
		service = new Service(driver);
		Assert.assertEquals(serviceMessage, service.getServiceMessage());
	}

	@Then("^Click on Solutions$")
	public void click_on_Solutions() throws Throwable {
		homePage = new HomePage(driver);
		homePage.clickOnSolutions();
	}

	@Then("^Verify the solution message \"([^\"]*)\"$")
	public void verify_the_solution_message(String solutionMessage) throws Throwable {
		solutions = new Solutions(driver);
		solutions.getSolutionMessage();
		Assert.assertEquals(solutionMessage, solutions.getSolutionMessage());
	}

	@Then("^Click on Specialized Centres$")
	public void click_on_Specialized_Centres() throws Throwable {
		homePage = new HomePage(driver);
		homePage.clickOnSpecializedCentres();
	}

	@Then("^Verify the specialized centres message \"([^\"]*)\"$")
	public void verify_the_specialized_centres_message(String specialiedCentreMessage) throws Throwable {
		specialized = new Specialized(driver);
		specialized.getSpecializedCentresMessage();
		Assert.assertEquals(specialiedCentreMessage, specialized.getSpecializedCentresMessage());
	}

	@Then("^Click on People$")
	public void click_on_People() throws Throwable {
		homePage = new HomePage(driver);
		homePage.clickOnPeople();
	}

	@Then("^Verify the people message \"([^\"]*)\"$")
	public void verify_the_people_message(String peopleMessage) throws Throwable {
		people = new People(driver);
		people.getPeopleMessage();
		Assert.assertEquals(peopleMessage, people.getPeopleMessage());
	}

	@Given("^Keep the mouse on services heading$")
	public void keep_the_mouse_on_services_heading() throws Throwable {
		WebElement serviceHover = driver.findElement(By.xpath("(//a[contains(text(),'Services')])[1]"));
		Actions actions = new Actions(driver);
		actions.moveToElement(serviceHover);
		actions.build().perform();
		homePage = new HomePage(driver);
		homePage.hoverServices();
	}

	// issue : i want hold my page after click button
	@When("^I click on \"([^\"]*)\"$")
	public void i_click_on(String userDigital) throws Throwable {
		digitalUser = new DigitalUser(driver);
		//digitalUser.clickOnDigitalUser();
	}

	@Then("^Verify the heading \"([^\"]*)\"$")
	public void verify_the_heading(String user) throws Throwable {
		digitalUser = new DigitalUser(driver);
		digitalUser.getUserHeading();
		Assert.assertEquals(user, digitalUser.getUserHeading());
	}

	@When("^I click on search button$")
	public void i_click_on_search_button() throws Throwable {
		driver.findElement(By.xpath("//div[@class = 'scroll buscar']")).click();
	}

	@When("^Type the content to search \"([^\"]*)\"$")
	public void type_the_content_to_search(String searchData) throws Throwable {
		//driver.findElement(By.className("searchtext")).sendKeys(searchData);
		driver.findElement(By.xpath("//input[@class = 'blinking-cursor']")).sendKeys(searchData);
	}

	@When("^click on search$")
	public void click_on_search() throws Throwable {
		driver.findElement(By.xpath("//input[@class = 'blinking-cursor']")).sendKeys(Keys.ENTER);
		// driver.findElement(By.className("searchtext")).sendKeys(Keys.RETURN);
	}

	@Then("^Verify the search result \"([^\"]*)\"$")
	public void verify_the_search_result(String searchResult) throws Throwable {
		WebElement resultOfSearch = driver.findElement(By.xpath("//span[contains(text(),'" + searchResult + "')])[1]"));
		Assert.assertEquals(searchResult, resultOfSearch.getText());
	}

	@When("^Type the content to search$")
	public void type_the_content_to_search() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@When("^click on close button$")
	public void click_on_close_button() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Then("^Verify the same page$")
	public void verify_the_same_page() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@After
	public void close() {
		driver.quit();
	}

}
*/