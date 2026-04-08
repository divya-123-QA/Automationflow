package pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import reusable.Reusablecode;

public class Cartpage extends Reusablecode{
WebDriver driver;
	public Cartpage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	/*driver.findElement(By.cssSelector("button[routerlink*='cart']")).click();
	List<WebElement> cartsection=driver.findElements(By.cssSelector(".cartSection h3"));
	Boolean cartcheck=cartsection.stream().anyMatch(s->s.getText().equalsIgnoreCase("ZARA COAT 3"));
	Assert.assertTrue(cartcheck);
	driver.findElement(By.cssSelector("button[class*='btn-primary']:nth-child(1)")).click();*/
	
	//driver.findElement(By.cssSelector("button[routerlink*='cart']")).click();
	@FindBy(css="button[routerlink*='cart']")
	WebElement cartsymbol;
	//List<WebElement> cartsection=driver.findElements(By.cssSelector(".cartSection h3"));
	@FindBy(css=".cartSection h3")
	List<WebElement> cartsection;
	//driver.findElement(By.cssSelector("button[class*='btn-primary']:nth-child(1)")).click();
	@FindBy(css="button[class*='btn-primary']:nth-child(1)")
	WebElement proceed;
	
	
	public List<WebElement> carttitle() {
	//	elementToBeClickable(cartsymbol);
		clickElement(cartsymbol);
		return cartsection;
		}
	public Paymentpage cartdetails(String productname) {
		List<WebElement> cartsection=carttitle();
		Boolean cartcheck=cartsection.stream().anyMatch(s->s.getText().equalsIgnoreCase(productname));
		Assert.assertTrue(cartcheck);
		proceed.click();
		Paymentpage pay=new Paymentpage(driver);
		return pay;
	}
}
