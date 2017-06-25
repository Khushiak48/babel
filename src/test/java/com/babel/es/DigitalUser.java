package com.babel.es;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author Khushboo Taneja
 *
 */
public class DigitalUser {

	private WebDriver driver;

	public DigitalUser(WebDriver driver1) {
		this.driver = driver1;
	}

	By digitalUserHeading = By.xpath("//h2[@class ='header text-left oswald animated fadeIn visible']");


	public String getUserHeading() {
	WebElement userHeading = driver.findElement(digitalUserHeading);
	return userHeading.getText();
	}


}
