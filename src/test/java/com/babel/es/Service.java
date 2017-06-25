package com.babel.es;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author Khushboo Taneja
 *
 */
public class Service {

	private WebDriver driver;

	public Service(WebDriver driver1) {
		this.driver = driver1;
	}

	By serviceMessage = By.xpath("//div[@class = 'description animated margins description_moto fadeIn visible']");
	
	public String getServiceMessage() {
		WebElement messageOfService = driver.findElement(serviceMessage);
		return messageOfService.getText();
	}	
}
