package com.orangeHRM.POM;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.orangeHRM.BaseOrange.Orange_Base;

public class Orange_loginPage extends Orange_Base {

	@FindBy(id="txtUsername")
	WebElement userName;
	
	@FindBy(id="txtPassword")
	WebElement passWord;
	
	@FindBy(name="Submit")
	WebElement submitButton;
	
	public Orange_loginPage() {
		PageFactory.initElements(driver, this);
	}
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	
	// Method to login to OrangeHRM
	public void Orange_login(String uname, String pword) throws InterruptedException {
		
		wait.until(ExpectedConditions.elementToBeClickable(userName));
		userName.sendKeys(uname);
		Thread.sleep(3000);
		
		wait.until(ExpectedConditions.elementToBeClickable(passWord));
		passWord.sendKeys(pword);
		Thread.sleep(3000);
		
		wait.until(ExpectedConditions.visibilityOf(submitButton));
		submitButton.click();
		
	}
}
