package com.babel.es;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author Khushboo Taneja
 *
 */
public class People {
	private WebDriver driver;

	public People(WebDriver driver1) {
		this.driver = driver1;
	}

	
	By PeopleMessage = By.xpath("//div[@class = 'description animated fadeIn visible text-left']");

	public String getPeopleMessage() {
		WebElement messageOfPeople = driver.findElement(PeopleMessage);
		return messageOfPeople.getText();
	}
}


