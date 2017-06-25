package com.babel.es;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author Khushboo Taneja
 *
 */
public class DirectWriter {
	
	private WebDriver driver;

	public DirectWriter(WebDriver driver1) {
		this.driver = driver1;
	}
	
	
	    By tabs =  By.xpath("//ul[@class='tabs']");
	    
	    
	    
	    public String getTabName(String directwriter) {
			// unordered list
			WebElement unorderedList = driver.findElement(tabs);
			// list of elements
			List<WebElement> liWebElementList = unorderedList.findElements(By.xpath(".//li"));
			WebElement tabElement = null;

			for (WebElement liWebElement : liWebElementList) {
				if (liWebElement.getText().equals(directwriter)) {
					tabElement = liWebElement;
					break;
				}
			}
			return tabElement.getText();
		}


}
