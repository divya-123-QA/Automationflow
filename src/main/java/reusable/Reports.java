package reusable;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reports {

	public static ExtentReports reportGenertaion() {
		File path=new File(System.getProperty("user.dir")+"//Reportsfile//index.html");
		
		 //path.getParentFile().mkdirs();
		 
		ExtentSparkReporter es=new ExtentSparkReporter(path);
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(es);
		return extent;
	}
}
