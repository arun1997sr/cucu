package com.mobileSearch.stepdefinition;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AmazonSearch {
	@Given("launch the browser")
	public void launch_the_browser() {
	   
		Hooks.driver.get("https://www.amazon.in/");
		
		
	}

	@When("search mobile in search bar")
	public void search_mobile_in_search_bar() throws InterruptedException {
		Hooks.driver.findElement(By.id("twotabsearchtextbox")).sendKeys("mobiles",Keys.ENTER);
		Thread.sleep(3000);
	    
	}

	@Then("validate the mobile page")
	public void validate_the_mobile_page() throws IOException {
		TakesScreenshot ss=(TakesScreenshot) Hooks.driver;
		File sourse=ss.getScreenshotAs(OutputType.FILE);
		File Target=new File("C:\\Users\\hp\\eclipse-workspace\\cucumberflip\\target\\ss.png");
		FileUtils.copyFile(sourse, Target);
		System.out.println("hiiiiiiiiiiiiiiiiii");
	    
	}


	

}
