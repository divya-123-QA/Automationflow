package reusabletest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pageobjects.Landing;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Basetest {
	public WebDriver driver;
	public Landing landobj;
	
	public WebDriver browserInvoke() throws IOException {
	
Properties prop=new Properties();
	FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/Global/Browser.properties");
	
prop.load(fis);
	String browsername=System.getProperty("Browser")!=null?System.getProperty("Browser"):prop.getProperty("Browser");
//String browsername=prop.getProperty("Browser");
if(browsername != null && browsername.contains("chrome")) {
	WebDriverManager.chromedriver().setup();
	//System.setProperty("webdriver.chrome.driver","C:\\Users\\rakes\\OneDrive\\Desktop\\Chrome\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
	ChromeOptions cr=new ChromeOptions();
	if(browsername.contains("headless")) {
		
		cr.addArguments("headless");
		
		
	}
	driver=new ChromeDriver(cr);
	if(browsername.contains("headless")) {
	driver.manage().window().setSize(new Dimension(1440,900));
	}
}
else if(browsername != null && browsername.equalsIgnoreCase("Firefox"))
{
	driver=new FirefoxDriver();
}
else if(browsername != null && browsername.equalsIgnoreCase("Edge"))
{
	driver=new EdgeDriver();
}

driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
return driver;
}
	public List<HashMap<String,String>> jsondata(String path) throws IOException {
		String content=FileUtils.readFileToString(new File(path),StandardCharsets.UTF_8);
		ObjectMapper om=new ObjectMapper();
		List<HashMap<String,String>> datass=om.readValue(content,new TypeReference<List<HashMap<String,String>>>(){
			
		});
		return datass;
	}
	
	public File Screenshot(String testcasename,WebDriver driver) throws IOException
	{
		File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	File dest=new File(System.getProperty("user.dir")+"//pics//"+testcasename+".png");
		FileUtils.copyFile(source,dest);
		return dest;
	}
	@BeforeClass(alwaysRun=true)
	public Landing initialLand() throws IOException {
		driver=browserInvoke();
	   landobj=new Landing(driver);
		landobj.goTO();
		return landobj;
	}
	@AfterClass(alwaysRun=true)
	public void lastLand() {
		if(driver != null) {
		driver.quit();
	}}
}