package org.stepdefnition;

import org.demo.POJOLogin;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.samples.BaseClass;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class StepDefnition extends BaseClass {
	
	@Given("User have to launch the browser and url")
	public void user_have_to_launch_the_browser_and_url() {
	    LaunchBrowser();
	    LaunchUrl("https://www.facebook.com/");
	}

	@When("User have to enter the valid email amd valid password")
	public void user_have_to_enter_the_valid_email_amd_valid_password() {
	   POJOLogin p = new POJOLogin();
	   WebElement email = p.getEmailtxt();
	   email.sendKeys("pk92862@gmail.com");
	   Assert.assertFalse(true);
	   WebElement pass = p.getPasstxt();
	   pass.sendKeys("Sowndaryaprank59");
	}

	@When("User have to click the login button")
	public void user_have_to_click_the_login_button() {
	    POJOLogin p = new POJOLogin();
	    WebElement login = p.getLogin();
	    login.click();
	}

	@Then("User have to clase the browser")
	public void user_have_to_clase_the_browser() {
	    driver.close();
	}

	@When("User have to enter the valid {string} and invalid {string}")
	public void user_have_to_enter_the_valid_and_invalid(String string, String string2) {
	    POJOLogin p = new POJOLogin();
	    p.getEmailtxt().sendKeys("email");
	    p.getPasstxt().sendKeys("password");
	}

	@Then("User have to close the browser")
	public void user_have_to_close_the_browser() {
	  driver.close();
	}


}
