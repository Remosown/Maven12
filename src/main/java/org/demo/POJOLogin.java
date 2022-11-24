package org.demo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.samples.BaseClass;

public class POJOLogin extends BaseClass {
	
	public POJOLogin() {
		
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="email")
	private WebElement emailtxt;
	
	@FindBy(name="pass")
	private WebElement passtxt;
	
	@FindBy(name="login")
	private WebElement login;

	public WebElement getEmailtxt() {
		return emailtxt;
	}

	public WebElement getPasstxt() {
		return passtxt;
	}

	public WebElement getLogin() {
		return login;
	}
	
	

}
