package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Confirmationpage {
WebDriver driver;
	public Confirmationpage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	//WebElement confirmationmsg=driver.findElement(By.cssSelector("h1[class='hero-primary']"));
	//Assert.assertEquals(confirmationmsg.getText(),"THANKYOU FOR THE ORDER.");*/
	
	@FindBy(css="h1[class='hero-primary']")
	WebElement confirmationmsg;
	public WebElement confirmationdetails() {
		return confirmationmsg;
	}
	public Orderspage validation() {
		WebElement confirmationmsg=confirmationdetails();
		Assert.assertEquals(confirmationmsg.getText(),"THANKYOU FOR THE ORDER.");
		Orderspage ord=new Orderspage(driver);
		return ord;
	}
}
