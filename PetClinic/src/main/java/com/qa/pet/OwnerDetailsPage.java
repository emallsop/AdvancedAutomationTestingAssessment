package com.qa.pet;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OwnerDetailsPage {

	@FindBy(xpath = "/html/body/app-root/app-owner-detail/div/div/button[2]")
	private WebElement editOwner;
	
	@FindBy(xpath = "/html/body/app-root/div[1]/nav/div/ul/li[2]")
	private WebElement ownersButton;
	
	@FindBy(xpath = "/html/body/app-root/div[1]/nav/div/ul/li[2]/ul/li[1]")
	private WebElement allOwners;
	
	public WebElement editOwner() {
		return editOwner;	
	}
	
	public WebElement ownersButton() {
		return ownersButton;	
	}
	
	public WebElement allOwners() {
		return allOwners;	
	}

}
