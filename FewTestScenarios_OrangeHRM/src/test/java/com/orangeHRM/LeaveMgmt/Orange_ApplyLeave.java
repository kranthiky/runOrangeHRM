package com.orangeHRM.LeaveMgmt;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orangeHRM.BaseOrange.Orange_Base;
import com.orangeHRM.POM.Orange_loginPage;

public class Orange_ApplyLeave extends Orange_Base{
	
	Orange_loginPage loginObj;
	public String orangeURL="https://opensource-demo.orangehrmlive.com";
	
//	public Orange_ApplyLeave() {
//		super();
//	}
	
	@BeforeClass
	public void BrowserSetup() {
		
		// Launch Browser
		initialiseBrowser();
		System.out.println("Browser is ready..!");
	}
	
	@Test
	public void leaveManagement() throws InterruptedException {
		String userName ="Admin";
		String password ="admin123";
		//launch OrangeHRM
		driver.get(orangeURL);
		
		// verify title
		String Actual = driver.getTitle();
		if(Actual.equalsIgnoreCase("OrangeHRM"))
			System.out.println("Orange HRM is launched..!");
		else
			System.out.println("Something wrong! Orange is not launched properly..!");
				
		//login to OrangeHRM
		loginObj = new Orange_loginPage();
	//	System.out.println(userName+"  &  "+password);
		loginObj.Orange_login(userName, password);
		String dashboardURL = driver.getCurrentUrl();
		Thread.sleep(3000);
		if(dashboardURL.equalsIgnoreCase(orangeURL+"/index.php/dashboard")) {
		   System.out.println("Login is successful - Dashboard is displayed..!");
		   driver.findElement(By.xpath("//span[contains(text(),'Apply Leave')]")).click();
		 }
		else 
		   System.out.println("something wrong logging in..!");
		
	}

}
