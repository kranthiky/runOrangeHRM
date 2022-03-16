package ExtentReportsTest;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class MyBaseClass {

	public static WebDriver driver;
	public static ExtentReports extent;
	public static ExtentSparkReporter spark;
	public static ExtentTest logger; 
	
	public static void browserInitialization() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
			
		extent = new ExtentReports();
		spark = new ExtentSparkReporter(System.getProperty("user.dir")+"\\Extent-Report\\ExtentReport_"+dateFormat()+".html");
		extent.attachReporter(spark);		
	}
	
	public static String captureScreenshot(WebDriver driver, String testName) throws IOException {		
		TakesScreenshot scrShot = (TakesScreenshot)driver;
		File src = scrShot.getScreenshotAs(OutputType.FILE);
		String destPath = System.getProperty("user.dir")+"\\Screenshots\\"+testName+"-"+dateFormat()+".png";
		File destn = new File(destPath);
		FileHandler.copy(src, destn);
		return destPath;
	}

	public static String dateFormat() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd_MM_yyyy HH_mm_ss");
		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now);
	}	
//	@AfterMethod
//	public void sendReport(ITestResult result) {
//		try {
//			
//			if(result.getStatus()==ITestResult.FAILURE) {
//				String screenPath = captureScreenshot(driver, result.getMethod().getMethodName());
//				logger.fail(result.getThrowable().getMessage(),MediaEntityBuilder.createScreenCaptureFromPath(screenPath).build());
//			
//			}
//		} catch (IOException e) {		
//			e.printStackTrace();
//		}	
//	}
	
}
