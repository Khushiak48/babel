package com.babel.es;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author Khushboo Taneja
 *
 */
public class Specialized {

	private WebDriver driver;

	public Specialized(WebDriver driver1) {
		this.driver = driver1;
	}

	
	By specializedCentresMessage = By.xpath("//div[@class = 'description text-left description_moto']");

	public String getSpecializedCentresMessage() {
		WebElement messageOfSpecializedCentre = driver.findElement(specializedCentresMessage);
		return messageOfSpecializedCentre.getText();
	}
}
