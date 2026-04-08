package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import reusable.Reusablecode;

public class Orderspage extends Reusablecode {
WebDriver driver;
	public Orderspage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	/*driver.findElement(By.cssSelector("button[routerlink*='myorders']")).click();
	//visibility
	List<WebElement> ordersname=driver.findElements(By.cssSelector("tr td:nth-child(3)"));
	Boolean match=ordersname.stream().anyMatch(e->e.getText().equalsIgnoreCase(productname));
	Assert.assertTrue(match);*/
	
	//driver.findElement(By.cssSelector("button[routerlink*='myorders']")).click();
	@FindBy(css="button[routerlink*='myorders']")
	WebElement ord;
	//List<WebElement> ordersname=driver.findElements(By.cssSelector("tr td:nth-child(3)"));
	@FindBy(css="tr td:nth-child(3)")
	List<WebElement> ordersname;
	
	
	
	public List<WebElement> Ordertitle() {
		clickElement(ord);
		
		return ordersname;
	}
	public Boolean Orderproduct() {
		List<WebElement> ordersname=Ordertitle();
		Boolean match=ordersname.stream().anyMatch(e->e.getText().equalsIgnoreCase("ZARA COAT 3"));
		return match;
	}
}
