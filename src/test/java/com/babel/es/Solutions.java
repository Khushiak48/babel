package com.babel.es;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author Khushboo Taneja
 *
 */
public class Solutions {

	private WebDriver driver;

	public Solutions(WebDriver driver1) {
		this.driver = driver1;
	}


	By solutionsMessage = By.xpath("//div[@class = 'description animated margins description_moto fadeIn visible']");

	public String getSolutionMessage() {
		WebElement messageOfSolution = driver.findElement(solutionsMessage);
		return messageOfSolution.getText();
	}

}
