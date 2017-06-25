package com.babel1.es.backup;

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

import com.babel.es.AboutBabel;
import com.babel.es.DigitalUser;
import com.babel.es.HomePage;
import com.babel.es.People;
import com.babel.es.Service;
import com.babel.es.Solutions;
import com.babel.es.Specialized;

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

		// TODO why creating an object in every method as aboutbabel = new
		// AboutBabel(driver);
		homePage = new HomePage(driver);
		homePage.clickOnAboutBabel();
	}

	// need to change message
	@Then("^Verify the message \"([^\"]*)\"$")
	public void verify_the_message(String aboutBabelMessage) throws Throwable {
		//aboutbabel = new AboutBabel(driver);
		aboutbabel.getAboutBabelMessage();
		System.out.println("expected message ::" + aboutBabelMessage + "::");
		System.out.println("actual message ::" + aboutbabel.getAboutBabelMessage() + "****");
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

	@When("^I click on search button$")
	public void i_click_on_search_button() throws Throwable {
		driver.findElement(By.xpath("//div[@class = 'scroll buscar']")).click();
	}

	@When("^Type the content to search \"([^\"]*)\"$")
	public void type_the_content_to_search(String searchData) throws Throwable {
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

	@When("^I click on type of sub- services (.+)$")
	public void i_click_on_type_of_sub_services(String services) throws Throwable {
		WebElement serviceHover = driver.findElement(By.xpath("(//a[contains(text(),'" + services + "')])[1]"));
		// mousehover functionality
		Actions actions = new Actions(driver);
		actions.moveToElement(serviceHover).click();
		actions.build().perform();
		Thread.sleep(5000);
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
		System.out.println("Hello :" + aboutbabel);
		WebElement aboutBabelHover = driver.findElement(By.xpath("(//a[contains(text(),'" + aboutbabel + "')])[1]"));
		// mousehover functionality
		Actions actions = new Actions(driver);
		actions.moveToElement(aboutBabelHover).click();
		actions.build().perform();
		Thread.sleep(5000);
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
		WebElement hoversolution = driver.findElement(By.xpath("(//a[contains(text(),'" + solutions + "')])[1]"));
		// mousehover functionality
		Actions actions = new Actions(driver);
		actions.moveToElement(hoversolution).click();
		actions.build().perform();
		Thread.sleep(5000);
	}

	@Then("^Verify all the (.+),(.+) of sub-solution page$")
	public void verify_all_the_of_subsolution_page(String title, String url) throws Throwable {
		System.out.println("expected title : " + title);
		System.out.println("expected url : " + url);
		// verifying the title and url
		//Assert.assertEquals(title, driver.getTitle());
		Assert.assertTrue(driver.getTitle().contains(title));
		Assert.assertEquals(url, driver.getCurrentUrl());
		
	}

	@When("^Click on linkedin link$")
	public void click_on_linkedin_link() throws Throwable {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,3000)", "");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//strong[@class='fa fa-linkedin']")).click();

		// Storing parent window reference into a String Variable
		// String Parent_Window = driver.getWindowHandle();

		// Switching from parent window to child window
		for (String Child_Window : driver.getWindowHandles()) {
			driver.switchTo().window(Child_Window);
			Thread.sleep(3000);
		}
	}

	@Then("^I can see linkedin page$")
	public void i_can_see_linkedin_page() throws Throwable {
		// Performing actions on child window
		WebElement message = driver
				.findElement(By.xpath("(//p[contains(text(),'Information Technology and Services')])[1]"));
		Assert.assertEquals("Information Technology and Services", message.getText());
	}

	@And("^Verify the url of child linkedin page (.+)$")
	public void verify_the_url_of_child_linkedin_page(String url) throws Throwable {
		Assert.assertEquals(url, driver.getCurrentUrl());
	}

	@When("^Click on twitter link$")
	public void click_on_twitter_link() throws Throwable {
		WebElement twitter = driver.findElement(By.xpath("//a[@class ='fa link-twitter']"));
		twitter.click();
	}

	@Then("^I can see twitter page$")
	public void i_can_see_twitter_page() throws Throwable {
	}

	@When("^I click on partners$")
	public void i_click_on_partners() throws Throwable {
		driver.findElement(By.xpath("(//a[@href='/en/sobre-babel/partners'])[1]")).click();
	}

	@And("^Scroll down the page with (.+)$")
	public void scroll_down_the_page_with(String coordinates) throws Throwable {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,800)", "");
		Thread.sleep(5000);
		System.out.println("hello");
	}

	@Then("^Verify the headings of (.+) field$")
	public void verify_the_headings_of_field(String partners) throws Throwable {

		// verify gold partner
		WebElement goldPartner = driver.findElement(By.xpath("//div[contains(text(),'Gold Partners')]"));
		System.out.println(goldPartner.getText());
		Assert.assertEquals(partners, goldPartner.getText());
		System.out.println("Hello");

		// verify strategic partner
		WebElement strategicPartner = driver.findElement(By.xpath("//div[contains(text(),'Strategic Partners')]"));
		System.out.println(strategicPartner.getText());
		System.out.println(partners);
		Assert.assertEquals(partners, strategicPartner.getText());
		System.out.println("Hii");
	}

	@When("^I click on Direct Writer$")
	public void i_click_on_Direct_Writer() throws Throwable {
		driver.findElement(By.xpath("(//a[contains(text(),'Direct Writer')])[1]")).click();
		Thread.sleep(4000);
	}

	@When("^Scroll down the page$")
	public void scroll_down_the_page() throws Throwable {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,950)", "");
		Thread.sleep(5000);
	}

	@Then("^Verify the insurance management platform tabs (.+)$")
	public void verify_the_insurance_management_platform_tabs_(String directwriter) throws Throwable {

		// unordered list
		WebElement unorderedList = driver.findElement(By.xpath("//ul[@class='tabs']"));
		// list of elements
		List<WebElement> liWebElementList = unorderedList.findElements(By.xpath(".//li"));
		WebElement tabElement = null;

		for (WebElement liWebElement : liWebElementList) {
			if (liWebElement.getText().equals(directwriter)) {
				tabElement = liWebElement;
				break;
			}
		}
		Assert.assertEquals(directwriter, tabElement.getText());
	}

	/*
	 * @Then("^Verify the insurance management platform tabs (.+) , (.+)$")
	 * public void verify_the_insurance_management_platform_tabs_(String
	 * directwriter, String description) throws Throwable {
	 * 
	 * WebElement descrMsgWebElement = null; // unordered list WebElement
	 * unorderedList = driver.findElement(By.xpath("//ul[@class='tabs']"));
	 * 
	 * //list of elements List<WebElement> liWebElementList =
	 * unorderedList.findElements(By.xpath(".//li"));
	 * 
	 * //xpath of target description
	 * 
	 * WebElement tabElement = null;
	 * 
	 * for (WebElement liWebElement : liWebElementList) { if
	 * (liWebElement.getText().equals(directwriter)) { liWebElement.click();
	 * Thread.sleep(1000);
	 * 
	 * descrMsgWebElement = driver.findElement(By.
	 * xpath("//div[@class ='description normal animated text-left tab_content fadeIn visible active']"
	 * ));
	 * 
	 * tabElement = liWebElement; break; } }
	 * 
	 * //Assert.assertEquals(directwriter, tabElement.getText());
	 * System.err.println("***************************" + directwriter + " :: "
	 * + descrMsgWebElement.getText()); //Assert.assertEquals(description,
	 * descriptionMessage.getText()); }
	 */

	@After
	public void close() {
		driver.quit();
	}

}
