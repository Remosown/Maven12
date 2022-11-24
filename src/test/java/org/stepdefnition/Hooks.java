package org.stepdefnition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hooks {
	
	public static WebDriver driver;
	
	@Before
	public void bef() {WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");}
		
	@After
	public void aft() {
		System.out.println(">>>>After each scenario");

	}
	@After(order=3)
	public void af1() {
		System.out.println(">>>After---1");

	}
	@After(order=2)
	public void af2() {
		System.out.println(">>>After---2");

	}
	@After(order=1)
	public void af3() {
		System.out.println(">>>After---3");

	}
	
	
	@Before("@white")
	public void bf1() {
		System.out.println("Before---1");

	}
	@Before("@like")
	public void bf2() {
		System.out.println("Before---2");

	}
	@Before
	public void bf3() {
		System.out.println("Before---3");

	}

		
	

	}
	


