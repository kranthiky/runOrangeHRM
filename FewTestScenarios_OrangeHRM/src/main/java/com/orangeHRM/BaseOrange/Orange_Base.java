package com.orangeHRM.BaseOrange;

import java.time.Duration;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.GeckoDriverInfo;
import org.openqa.selenium.firefox.GeckoDriverService;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Orange_Base {

	public static WebDriver driver;
	static String  browser;
	
	
	public static void initialiseBrowser() throws InputMismatchException{
	
		
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		
		/*
		 * Scanner scn = new Scanner(System.in); // Read Browser name
		 * System.out.println("on which Browser you'd like to run your app? :");
		 * 
		 * browser = scn.nextLine(); try { if(browser.equalsIgnoreCase("Chrome")) {
		 * WebDriverManager.chromedriver().setup(); driver= new ChromeDriver();
		 * //headless mode // driver = new ChromeDriver(new
		 * ChromeOptions().setHeadless(true)); } else
		 * if(browser.equalsIgnoreCase("firefox")) {
		 * WebDriverManager.firefoxdriver().setup(); driver= new FirefoxDriver(); //
		 * driver = new FirefoxDriver(new FirefoxOptions().setHeadless(true)); } else
		 * if(browser.equalsIgnoreCase("edge")) { WebDriverManager.edgedriver().setup();
		 * driver= new EdgeDriver(); //driver = new EdgeDriver(new
		 * EdgeOptions().setHeadless(true)); } else {
		 * System.out.println("Please enter Chrome/Firefox/Edge: ");
		 * 
		 * } } finally { scn.close(); }
		 */
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
 }	
}
