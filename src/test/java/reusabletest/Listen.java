package reusabletest;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.Writable;

import reusable.Reports;

public class Listen extends Basetest implements ITestListener{
public ExtentReports extent=Reports.reportGenertaion();
public ExtentTest test;
ThreadLocal<ExtentTest> loc=new ThreadLocal<ExtentTest>();
	@Override
	public void onTestStart(ITestResult result) {
	//	extent=Reports.reportGenertaion();
		// TODO Auto-generated method stub
	test=	extent.createTest(result.getMethod().getMethodName());
	loc.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		loc.get().log(Status.PASS, "pass Testcase");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		loc.get().log(Status.FAIL,result.getThrowable());
		// TODO Auto-generated method stub
		WebDriver driver=null;
		try
		{
		driver=(WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
		File hj=	Screenshot(result.getMethod().getMethodName(),driver);
			test.addScreenCaptureFromPath(hj.getAbsolutePath(),result.getMethod().getMethodName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
