package ExtentReportsTest;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

public class myListeners extends MyBaseClass implements ITestListener {

	public void onTestStart(ITestResult result) {

	//	System.out.println("Test started..");
	}

	public void onTestSuccess(ITestResult result) {

		System.out.println("Test:"+result.getMethod().getMethodName()+ " is Passed.");
		try {
			String screenPath = captureScreenshot(driver, result.getMethod().getMethodName());
			logger.addScreenCaptureFromPath(screenPath);
		} catch (Exception e) {
			System.out.println("could not capture screenshot:" + e.getMessage());
		}
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("Test:"+result.getMethod().getMethodName()+" is Failed.");
		try {
			String screenPath = captureScreenshot(driver, result.getMethod().getMethodName());
			logger.fail(result.getThrowable().getMessage(),MediaEntityBuilder.createScreenCaptureFromPath(screenPath).build());
		//	logger.fail(MediaEntityBuilder.createScreenCaptureFromPath(screenPath).build());
	
		} catch (Exception e) {
			System.out.println("could not capture screenshot:" + e.getMessage());
		}
	}

	public void onTestSkipped(ITestResult result) {

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onTestFailedWithTimeout(ITestResult result) {

	}

	public void onStart(ITestContext context) {

	}

	public void onFinish(ITestContext context) {
	
	}

}
