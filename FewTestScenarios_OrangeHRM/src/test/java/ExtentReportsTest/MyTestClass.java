package ExtentReportsTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;

import io.netty.handler.codec.http.HttpContentEncoder.Result;

@Listeners(myListeners.class)
public class MyTestClass extends MyBaseClass {

	
	@BeforeClass
	public void setupBrowser() {
		browserInitialization();
	}
	
	@Test(priority =1)
	public void LaunchApp() {
		
		logger = extent.createTest("Launch Application");		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		logger.log(Status.PASS,"Application is launched successfully..!");				
	}
	
	@Test(priority =2)
	public void TestLoginToApp() throws InterruptedException, IOException {
		
		WebElement uName = driver.findElement(By.id("txtUsername"));
		WebElement pWord = driver.findElement(By.id("txtPassword"));
		WebElement loginButton = driver.findElement(By.name("Submit"));
		
		logger = extent.createTest("Login to Application"); 
		uName.sendKeys("Admin");
		Thread.sleep(1000);
		pWord.sendKeys("admin123");
		Thread.sleep(1000);
		loginButton.click();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/index.php/dashboard");		
		logger.log(Status.PASS, "User logged in successfully..!");

	}
	@Test(priority =3, enabled=true)
	public void logoutFromOrange() throws InterruptedException {
		WebElement logOutDropdown = driver.findElement(By.id("welcome"));
		WebElement logoutLink = driver.findElement(By.xpath("//a[text()='Logout']"));
		logger = extent.createTest("Logout from Application");
		logOutDropdown.click();
		Thread.sleep(2000);
		logoutLink.click();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		logger.pass("User logged out from Application successfully..!");
	}
	@AfterClass
	public void tearDown() {
	
		extent.flush();
		//driver.close();
		//	driver.quit();
	}
	
}
