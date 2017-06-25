package com.babel.es;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author Khushboo Taneja
 *
 */
public class AboutBabel {

	private WebDriver driver;

	AboutBabel(WebDriver driver1) {
		this.driver = driver1;
	}

	By aboutBabelMessage = By.xpath("//div[@class = 'description normal animated margins fadeIn visible']");

	public String getAboutBabelMessage() {
		WebElement messageOfAboutBabel = driver.findElement(aboutBabelMessage);
		return messageOfAboutBabel.getText();
	}
}
