package pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import reusable.Reusablecode;

public class Landing extends Reusablecode {
WebDriver driver;

public Landing(WebDriver driver) {
	super(driver);
	this.driver=driver;
	PageFactory.initElements(driver,this);
}
	/*driver.get("https://rahulshettyacademy.com/client");
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
	 wait.until( ExpectedConditions.visibilityOfElementLocated(By.id("userEmail")));
	driver.findElement(By.id("userEmail")).sendKeys("rav123@gmail.com");
	driver.findElement(By.id("userPassword")).sendKeys("Money08$");
	driver.findElement(By.xpath("//input[@type='submit']")).click();*/
	
By userbox=By.id("userEmail");
//driver.findElement(By.id("userEmail"))
@FindBy(id="userEmail")
WebElement user;
//driver.findElement(By.id("userPassword"))
@FindBy(id="userPassword")
WebElement passwordbox;
//driver.findElement(By.xpath("//input[@type='submit']"))
//@FindBy(xpath="//input[@type='submit']")
//WebElement loginbutton;
//driver.findElement(By.cssselector("input[type='submit']").click();
@FindBy(css="input[type='submit']")
WebElement signin;
@FindBy(css=".ng-trigger-flyInOut")
WebElement logerror;
//By loginclick=By.xpath("//input[@type='submit']");
	
	public void goTO() {
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	public Productcatalogue login(String username,String password) {
		visibilityOfElement(userbox);
		user.sendKeys(username);
		passwordbox.sendKeys(password);
		waitForLoaderToDisappear();  
		scrollToElement(signin); 
		elementToBeClickable(signin);
		signin.click();
		Productcatalogue prd=new Productcatalogue(driver);
		return prd;
	}
	public String loginError() {
		//.ng-tns-c4-9.ng-star-inserted.ng-trigger.ng-trigger-flyInOut.ngx-toastr.toast-error
		visibilityOfWebElement(logerror);
	String logerrormsg=	logerror.getText();
	return logerrormsg;
	}
}
