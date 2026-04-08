package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import reusable.Reusablecode;

public class Paymentpage extends Reusablecode{
WebDriver driver;
	public Paymentpage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	/*Actions v=new Actions(driver);
	v.sendKeys(driver.findElement(By.xpath("//input[@placeholder='Select Country']")),"India").build().perform();
	driver.findElement(By.xpath("//span[text()=' India']")).click();
	//wait.until( ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[class*='action__submit']")));
	driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("123");
	driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys("test");
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
	wait.until( ExpectedConditions.elementToBeClickable(By.cssSelector(".action__submit")));
	driver.findElement(By.cssSelector(".action__submit")).click();*/
	
	//driver.findElement(By.xpath("//input[@placeholder='Select Country']"))
	@FindBy(xpath="//input[@placeholder='Select Country']")
	WebElement countrybox;
	//driver.findElement(By.xpath("//span[text()=' India']")).click();
	@FindBy(xpath="//span[contains(text(),'India')]")
	WebElement dropbox;
	//driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("123");
	@FindBy(xpath="(//input[@type='text'])[2]")
	WebElement carddetails;
	//driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys("test");
	@FindBy(xpath="(//input[@type='text'])[3]")
	WebElement testname;
	//By.cssSelector(".action__submit");
	By submitButton=By.cssSelector(".action__submit");
	//driver.findElement(By.cssSelector(".action__submit")).click();
	@FindBy(css=".action__submit")
	WebElement ok;
	
	public void paymentDetails(String countryname,String cardno,String tester) {
		Actions v=new Actions(driver);
		v.sendKeys(countrybox,countryname).build().perform();
		clickElement(dropbox);
		carddetails.sendKeys(cardno);
		testname.sendKeys(tester);
		elementToBeClickable(submitButton);
		ok.click();
		
	}
	
	
	
}
