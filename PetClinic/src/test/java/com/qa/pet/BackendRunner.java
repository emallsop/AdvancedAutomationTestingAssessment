//I realise I should have used cucumber but now I have done it like this and I don't have time, sorry!
package com.qa.pet;

import static org.junit.Assert.*;

import org.json.simple.JSONObject;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BackendRunner {

	RequestSpecification request = RestAssured.given().contentType(ContentType.JSON);
	Response response = request.get("http://10.0.10.10:9966/petclinic/api/owners/"); 
	public static ExtentReports report = new ExtentReports("C:\\Users\\Admin\\Documents\\JMETER\\Performance Test Graphs\\ExtentReport\\PetClinicReport.html", true);
	public static ExtentTest test;

	@BeforeClass
	public static void before() {
		
		test = report.startTest("Owner Management");
	}
	
	@AfterClass
	public static void after() {
		
		test.log(LogStatus.INFO, "Test Complete");
		report.endTest(test);
	    report.flush();
	}
	
	@Test
	public void get() {
		
		response.prettyPrint();
		
		test.log(LogStatus.INFO, "Get all owner info");
		
		if (response.statusCode() == 200) {
			test.log(LogStatus.PASS, "Owner info successfully loaded");
		}
		else {
			test.log(LogStatus.FAIL, "Owner info not loaded successfully");
			report.endTest(test);
		    report.flush();
		}
		
		assertEquals(200,response.statusCode()); 
	}
	
	
	@SuppressWarnings("unchecked")
	@Test
	public void post() {
		
		test.log(LogStatus.INFO, "Add new owner");
		
		request.header("Content-Type", "application/json");
		
		JSONObject postOwner = new JSONObject(); 
		
		postOwner.put("firstName", "Shia"); 
		postOwner.put("lastName", "LaBeouf"); 
		postOwner.put("address", "New York"); 
		postOwner.put("city", "New York");
		postOwner.put("telephone", "077707773"); 
		postOwner.put("id", 0);

		request.body(postOwner); 
		
		Response response = request.post("http://10.0.10.10:9966/petclinic/api/owners/");
		
		if (response.statusCode() == 201) {
			test.log(LogStatus.PASS, "Owner successfully added");
		}
		else {
			test.log(LogStatus.FAIL, "Owner not added successfully");
			report.endTest(test);
		    report.flush();
		}
				
		response.then().statusCode(201); 

	}

	
	@Test
	public void delete() {

		test.log(LogStatus.INFO, "Delete an owner");
		
		Response response = request.delete("http://10.0.10.10:9966/petclinic/api/owners/26"); 
		
		if (response.statusCode() == 204) {
			test.log(LogStatus.PASS, "Owner successfully deleted");
		}
		else {
			test.log(LogStatus.FAIL, "Owner not deleted successfully");
			report.endTest(test);
		    report.flush();
		}
		response.then().statusCode(204);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void put() {
		
		test.log(LogStatus.INFO, "Update an owner's info");
		
		RequestSpecification request = RestAssured.given().contentType(ContentType.JSON);
		
		request.header("Content-Type", "application/json");
		
		JSONObject putOwner = new JSONObject(); 
		
		putOwner.put("firstName", "Paul"); 
		putOwner.put("lastName", "Rudd"); 
		putOwner.put("address", "Matacawalevu"); 
		putOwner.put("city", "Fiji");
		putOwner.put("telephone", "077707909"); 
		putOwner.put("id", 20);

		request.body(putOwner); 
		Response response = request.put("http://10.0.10.10:9966/petclinic/api/owners/20");
		
		if (response.statusCode() == 204) {
			test.log(LogStatus.PASS, "Owner info successfully updated");
		}
		else {
			test.log(LogStatus.FAIL, "Owner info not updated successfully");
			report.endTest(test);
		    report.flush();
		}
		
		response.then().statusCode(204); 
		
	}

}