package com.qa.pet;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PetClinicHomepage {

	
	@FindBy(xpath = "/html/body/app-root/app-welcome/h1")
	private WebElement welcome;
	
	@FindBy(xpath = "/html/body/app-root/div[1]/nav/div/ul/li[2]/a")
	private WebElement ownersButton;
	
	@FindBy(xpath = "/html/body/app-root/div[1]/nav/div/ul/li[2]/ul/li[2]/a")
	private WebElement newOwnerButton;
	
	public WebElement getWelcome() {
		return welcome;
	}

	public WebElement ownersButton() {
		return ownersButton;
	}
	
	public WebElement newOwnerButton() {
		return newOwnerButton;
	}
	
	
}
