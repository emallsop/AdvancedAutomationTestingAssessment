package com.qa.pet;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OwnersPage {

	public WebElement owner(WebDriver driver, String username) {
		
		WebElement ownerList = driver.findElement(By.className("ownerFullName"));
		WebElement owner = ownerList.findElement(By.xpath("//*[contains(text(), '" + username + "')]"));
		
		return owner;
		
		
	}
	
	public List<String> getResults(WebDriver driver) {
		
		//xpath of search results
		WebElement ownerList = driver.findElement(By.xpath("/html/body/app-root/app-owner-list/div/div/div/table"));
		
		//create list of product names within search results
	    List<String> ownerName = new ArrayList<String>();
	    List<WebElement> allOwnersNames = ownerList.findElements(By.className("ownerFullName"));
	    
	    
	    for(WebElement w : allOwnersNames) {
	        ownerName.add(w.getText());
	    }
	
	    return ownerName;
	}
}
