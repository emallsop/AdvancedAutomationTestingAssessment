package com.qa.pet;

import static org.junit.Assert.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FrontendStep {
	
	public WebDriver driver = null;
	public static ExtentReports report = new ExtentReports("C:\\Users\\Admin\\Documents\\JMETER\\Performance Test Graphs\\ExtentReport\\PetClinicReport2.html", true);
	public ExtentTest test;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
	@Given("^I am on the correct website$")
	public void i_am_on_the_correct_website() throws Throwable {
		
		driver.get(Constants.homepage);
		//test.log(LogStatus.INFO, "Entered PetClinic homepage");
		
		PetClinicHomepage homepage = PageFactory.initElements(driver, PetClinicHomepage.class);
		
//		if (homepage.getWelcome().getText().equals("Welcome to Petclinic")) {
//			test.log(LogStatus.PASS, "Homepage loaded successfully");
//		}
//		else {
//			test.log(LogStatus.FAIL, "Homepage not loaded");
//			report.endTest(test);
//		    report.flush();
//		}
		
		assertEquals("Homepage Loaded", "Welcome to Petclinic", homepage.getWelcome().getText());
	  
	}

	@When("^a new owner is added$")
	public void a_new_owner_is_added() throws Throwable {
		
		PetClinicHomepage homepage = PageFactory.initElements(driver, PetClinicHomepage.class);
		homepage.ownersButton().click();
		homepage.newOwnerButton().click();
		
		NewOwnerPage newOwnerPage = PageFactory.initElements(driver,  NewOwnerPage.class);
		newOwnerPage.enterFirstName("Reese");
		newOwnerPage.enterLastName("Witherspoon");
		newOwnerPage.enterAddress("Moonee Ponds");
		newOwnerPage.enterCity("Melbourne");
		newOwnerPage.enterTelephone("07080901");
		newOwnerPage.addOwner().click();
		Thread.sleep(10000);
	    
	}

	@When("^the owner is updated$")
	public void the_owner_is_updated() throws Throwable {
		
	    OwnersPage ownersPage = PageFactory.initElements(driver, OwnersPage.class);
	    ownersPage.owner(driver, "Reese Witherspoon").click();
	    
	    OwnerDetailsPage detailsPage = PageFactory.initElements(driver, OwnerDetailsPage.class);
	    detailsPage.editOwner().click();
	    
		NewOwnerPage newOwnerPage = PageFactory.initElements(driver,  NewOwnerPage.class);
		newOwnerPage.enterLastName("Withoutaspoon");
		newOwnerPage.updateOwner().click();
	    
	    Thread.sleep(10000);
	}
	    

	@Then("^the new information appears on the Owners page$")
	public void the_new_information_appears_on_the_Owners_page() throws Throwable {
		
		OwnerDetailsPage detailsPage = PageFactory.initElements(driver, OwnerDetailsPage.class);
		detailsPage.ownersButton().click();
		detailsPage.allOwners().click();
		
		OwnersPage ownersPage = PageFactory.initElements(driver, OwnersPage.class);
		 
		System.out.print(ownersPage.getResults(driver));
		    
		    boolean ownerPresent;
		    
		    if (ownersPage.getResults(driver).contains("Reese Withoutaspoon")) {
		    	ownerPresent = true;
		    } else {
		    	ownerPresent = false;
		    }
		    
		    
		    assertEquals(true, ownerPresent);
	}
}
