package com.mobileSearch.stepdefinition;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import org.openqa.selenium.WebElement;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;


public class MobileSearchSteps {

	
	 String parwin;
@Given("user launches the flipkart application")
public void user_launches_the_flipkart_application() {
	
	Hooks.driver.get("https://www.flipkart.com/");
	
}

@Given("user login by valid email id and passward")
public void user_login_by_valid_email_id_and_passward() {
	
	WebElement email=Hooks.driver.findElement(By.xpath("(//input[@autocomplete='off'])[2]"));
	email.sendKeys("8870148903");
	WebElement pass=Hooks.driver.findElement(By.xpath("(//input[@autocomplete='off'])[3]"));
	pass.sendKeys("@arunkumar8903");
	WebElement login=Hooks.driver.findElement(By.xpath("(//button[@type='submit'])[2]"));
	login.click();
	Hooks.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    
}

@When("user search mobile and click enter")
public void user_search_mobile_and_click_enter() throws InterruptedException {
	WebElement search=Hooks.driver.findElement(By.xpath("//input[@autocomplete='off']"));
	search.sendKeys("mobiles",Keys.ENTER);
	
	
   
}

@When("user click the first mobile and click addtocart")
public void user_click_the_first_mobile_and_click_addtocart() throws InterruptedException {
	WebElement realme=Hooks.driver.findElement(By.xpath("//div[@class='_4rR01T']"));
	   String r= realme.getText();
	   System.out.println(r);
	   
	   parwin= Hooks.driver.getWindowHandle();
	  System.out.println(parwin);
	  realme.click();
	  Thread.sleep(5000);
	 Set<String> allwin= Hooks.driver.getWindowHandles();
	 for (String x : allwin) {
		 if(!parwin.equals(x)) {
			 Hooks.driver.switchTo().window(x);
		 }
	 }
	 Hooks.driver.findElement(By.xpath("//button[text()='ADD TO CART']")).click();
    
}

@Then("verify the order is placed")
public void verify_the_order_is_placed() throws InterruptedException {
	Hooks.driver.switchTo().window(parwin);
	Hooks.driver.findElement(By.xpath("//span[text()='Cart']")).click();
	Thread.sleep(5000);
	
	 WebElement order = Hooks.driver.findElement(By.xpath("//span[text()='Place Order']"));
	 String text = order.getText();
	 System.out.println(text);
	
   
}
@When("user search mobile and click enter by {int}D list")
public void user_search_mobile_and_click_enter_by_D_list(DataTable dataTable) {
    
	List<String> oneD = dataTable.asList(String.class);
	WebElement search=Hooks.driver.findElement(By.xpath("//input[@autocomplete='off']"));
	search.sendKeys(oneD.get(1),Keys.ENTER);
	
}
@When("user search mobile and click enter by one list")
public void user_search_mobile_and_click_enter_by_one_list(DataTable dataTable) {
	List<String> oneD = dataTable.asList(String.class);
	WebElement search=Hooks.driver.findElement(By.xpath("//input[@autocomplete='off']"));
	search.sendKeys(oneD.get(0),Keys.ENTER);
	
}
@When("user search mobile and click enter by one map")
public void user_search_mobile_and_click_enter_by_one_map(DataTable dataTable) {
	Map<String, String> asMap = dataTable.asMap(String.class, String.class);
	WebElement search=Hooks.driver.findElement(By.xpath("//input[@autocomplete='off']"));
	search.sendKeys(asMap.get("ph4"),Keys.ENTER);
}
@When("user search mobile and click enter{string}")
public void user_search_mobile_and_click_enter(String ph) {
	WebElement search=Hooks.driver.findElement(By.xpath("//input[@autocomplete='off']"));
	search.sendKeys(ph,Keys.ENTER);
}





}
