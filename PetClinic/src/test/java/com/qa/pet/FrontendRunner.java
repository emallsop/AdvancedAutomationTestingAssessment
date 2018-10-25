package com.qa.pet;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

	@RunWith(Cucumber.class)
	@CucumberOptions(features = "src\\test\\java\\PetClinicFrontend.feature", glue = {"com.qa.pet"})

	public class FrontendRunner {
}
