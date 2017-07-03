package com.babel.es;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.testng.AbstractTestNGCucumberTests;

/**
 * @author Khushboo Taneja
 *
 */

public class BabelStepDefs extends AbstractTestNGCucumberTests {

	public static String browserType;

	private HomePage homePage;

	private AboutBabel aboutbabel;

	private Service service;

	private Solutions solutions;

	private Specialized specialized;

	private People people;

	private DigitalUser digitalUser;

	private DirectWriter directWriter;

	private WebDriver driver;

	/*
	 * @Parameters("browsername") public void parameterTest(String browsername)
	 * { System.out.println("Parameterized value is : " + browsername); }
	 */

	@Before
	public void beforeTest() {

		if (browserType == null) {
			System.out.println("*************** default Firefox ***********");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		} else if (browserType.equalsIgnoreCase("firefox")) {
			System.out.println("*************** Firefox ***********");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		} else if (browserType.equalsIgnoreCase("ie")) {
			driver = new InternetExplorerDriver();
		} else if (browserType.equalsIgnoreCase("chrome")) {
			System.out.println("*************** chrome ***********");
			driver = new ChromeDriver();
		}

	}

	@Given("^Go to \"([^\"]*)\"$")
	public void go_to_something(String url) throws Throwable {
		//driver = new FirefoxDriver();
		driver.get(url);
	}

	@Given("^Maximize the window$")
	public void maximize_the_window() throws Throwable {
		driver.manage().window().maximize();
	}

	@Given("^Set the implicitly time$")
	public void set_the_implicitly_time() throws Throwable {
		// time issue on UI browser that is not holding the page
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Given("^Keep the mouse on services heading$")
	public void keep_the_mouse_on_services_heading() throws Throwable {
		homePage = new HomePage(driver);
		homePage.hoverServices();
		//Thread.sleep(2000);
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
		System.out
				.println("*********************** driver.getTitle()*****************************" + driver.getTitle());
		Assert.assertTrue(driver.getTitle().contains(title));
		// Assert.assertEquals(title, driver.getTitle());
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
		System.out.println("actual title : " + driver.getTitle());
		System.out.println("actual url : " + driver.getCurrentUrl());
		
		// verifying the title and url
		Assert.assertTrue(driver.getTitle().contains(title));
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
		// Assert.assertEquals(title, driver.getTitle());
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

	@When("^i click on video button$")
	public void i_click_on_video_button() throws Throwable {
		WebElement videoWindow = driver.findElement(By.xpath(
				"//a[@class='popup-modal white-text hidden-sm hidden-xs']/img[@class= 'img-responsive video__img__home']"));
		videoWindow.click();
		driver.switchTo().frame(videoWindow);
	}

	@When("^New frame window open$")
	public void new_frame_window_open() throws Throwable {
	}

	@When("^Click on video button$")
	public void click_on_video_button() throws Throwable {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		// Click on play button
		jse.executeScript("jwplayer().play();");
		Thread.sleep(2000);
		// driver.findElement(By.xpath("//div[@id='video']")).click();
	}

	@When("^Pause the video$")
	public void pause_the_video() throws Throwable {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		// Pause
		jse.executeScript("jwplayer().pause()");
		Thread.sleep(2000);
	}

	@When("^Play it again$")
	public void play_it_again() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@When("^set the volume$")
	public void set_the_volume() throws Throwable {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		Thread.sleep(2000);
		jse.executeScript("jwplayer().setVolume(50);");
		Thread.sleep(2000);
	}

	@When("^mute the video$")
	public void mute_the_video() throws Throwable {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		Thread.sleep(2000);
		jse.executeScript("jwplayer().setMute(true);");
		Thread.sleep(2000);
	}

	@When("^Unmute the video$")
	public void unmute_the_video() throws Throwable {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		Thread.sleep(2000);
		jse.executeScript("jwplayer().setMute(false);");
		Thread.sleep(2000);
	}

	@After
	public void close() {
		driver.quit();
	}

}
