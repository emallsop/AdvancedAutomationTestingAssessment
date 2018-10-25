package com.qa.pet;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewOwnerPage {
	
	@FindBy(id = "firstName")
	private WebElement firstName;
	
	@FindBy(id = "lastName")
	private WebElement lastName;
	
	@FindBy(id = "address")
	private WebElement address;
	
	@FindBy(id = "city")
	private WebElement city;
	
	@FindBy(id = "telephone")
	private WebElement telephone;
	
	@FindBy(xpath = "/html/body/app-root/app-owner-add/div/div/form/div[7]/div/button[2]")
	private WebElement addOwner;
	
	@FindBy(xpath = "/html/body/app-root/app-owner-edit/div/div/form/div[7]/div/button[2]")
	private WebElement updateOwner;
	
	public void enterFirstName(String text) {
		firstName.sendKeys(text);	
	}
	
	public void enterLastName(String text) {
		lastName.clear();
		lastName.sendKeys(text);	
	}
	
	public void enterAddress(String text) {
		address.sendKeys(text);	
	}
	
	public void enterCity(String text) {
		city.sendKeys(text);	
	}
	
	public void enterTelephone(String text) {
		telephone.sendKeys(text);	
	}
	
	public WebElement addOwner() {
		return addOwner;	
	}
	
	public WebElement updateOwner() {
		return updateOwner;	
	}

}
