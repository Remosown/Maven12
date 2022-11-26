package org.demo;

import org.openqa.selenium.WebElement;
import org.samples.BaseClass;

public class Launching4 extends BaseClass {
	
	public static void main(String[] args) {
		
		LaunchBrowser();
		LaunchUrl("https://www.facebook.com/");
		
		POJOLogin p = new POJOLogin();
		
		WebElement email  = p.getEmailtxt();
		email.sendKeys("pk92862@gmail.com");
		
		WebElement pass = p.getPasstxt();
		pass.sendKeys("home34");
		
		WebElement login = p.getLogin();
		login.click();
		
		driver.navigate().refresh();
		
		email.sendKeys("remokumar526@gmail.com");
		pass.sendKeys("pradeep97");
		
		
		
	}

}

