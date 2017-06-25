package com.babel.es;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * @author Khushboo Taneja
 *
 */
public class HomePage {

	private WebDriver driver;

	private String servicesName;

	private String aboutbabelName;

	private String solutionsName;

	public HomePage(WebDriver driver1) {
		this.driver = driver1;
	}

	By videoMessageXpath = By.xpath("//div[@class = 'video__text']");
	By aboutBabel = By.xpath("(//a[@href='/en/about-babel'])[1]");
	By services = By.xpath("(//a[contains(text(),'Services')])[1]");
	By solutions = By.xpath("(//a[@href='/en/soluciones'])[1]");
	By specializedCentres = By.xpath("(//a[@href='/en/specialized-centres'])[1]");
	By People = By.xpath("(//a[@href='/en/personas'])[1]");
	By servicesHover = By.xpath("(//a[contains(text(),'Services')])[1]");
	By clickDigitalUser = By.xpath("(//a[@href ='/en/services/digital-user'][1])");
	By aboutBabelHover = By.xpath("(//a[contains(text(),'About BABEL')])[1]");
	By solutionshover = By.xpath("(//a[@href ='/en/soluciones'])[1]");
	By subServices = By.xpath("(//a[contains(text(),'" + servicesName + "')])[1]");
	By aboutBabelHover1 = By.xpath("(//a[contains(text(),'" + aboutbabelName + "')])[1]");
	By directWriter = By.xpath("(//a[contains(text(),'Direct Writer')])[1]");
	By solutionshover1 = By.xpath("(//a[contains(text(),'" + solutionsName + "')])[1]");

	public String getVideoMessage() {
		WebElement videoElement = driver.findElement(videoMessageXpath);
		return videoElement.getText();
	}

	public void clickOnAboutBabel() {
		driver.findElement(aboutBabel).click();
	}

	public void clickOnServices() {
		driver.findElement(services).click();
	}

	public void clickOnSolutions() {
		driver.findElement(solutions).click();
	}

	public void clickOnSpecializedCentres() {
		driver.findElement(specializedCentres).click();
	}

	public void clickOnPeople() {
		driver.findElement(People).click();
	}

	public void hoverServices() {
		WebElement serviceHover = driver.findElement(servicesHover);
		Actions actions = new Actions(driver);
		actions.moveToElement(serviceHover);
		actions.build().perform();
	}

	public void clickOnDigitalUser() {
		driver.findElement(clickDigitalUser).click();
	}

	public void hoverAboutBabel() {
		WebElement hoverAboutBabel = driver.findElement(aboutBabelHover);
		Actions actions = new Actions(driver);
		actions.moveToElement(hoverAboutBabel);
		actions.build().perform();
	}

	public void hoverSolutions() {
		WebElement hoverOfSolution = driver.findElement(solutionshover);
		Actions actions = new Actions(driver);
		actions.moveToElement(hoverOfSolution);
		actions.build().perform();
	}

	public void clickOnSubServices(String services) throws InterruptedException {
		servicesName = services;
		WebElement serviceHover = driver.findElement(subServices);
		Actions actions = new Actions(driver);
		actions.moveToElement(serviceHover).click();
		actions.build().perform();
		Thread.sleep(5000);
	}

	public void clickOnAboutBabelSection(String aboutbabel) throws InterruptedException {
		aboutbabelName = aboutbabel;
		WebElement aboutBabelHover = driver.findElement(aboutBabelHover1);
		Actions actions = new Actions(driver);
		actions.moveToElement(aboutBabelHover).click();
		actions.build().perform();
		Thread.sleep(5000);
	}
	
	public void clickOnDirectWriter() throws InterruptedException {
		driver.findElement(directWriter).click();
		Thread.sleep(2000);
	}
	
	public void clickOnSubSolutions(String solutions) throws InterruptedException {
		solutionsName = solutions;
		WebElement hoversolution =  driver.findElement(solutionshover1);
		Actions actions = new Actions(driver);
		actions.moveToElement(hoversolution).click();
		actions.build().perform();
		Thread.sleep(5000);
	}
}
