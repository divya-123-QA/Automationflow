package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import reusable.Reusablecode;

public class Productcatalogue extends Reusablecode{
WebDriver driver;
	public Productcatalogue(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	/*
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='card-body']/h5/b")));
	List<WebElement> allimages=driver.findElements(By.cssSelector(".col-lg-4"));
	
	WebElement prod=allimages.stream().filter(a->
	a.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")).findFirst().orElse(null);
	//System.out.println(product.getText());
	prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
	wait.until( ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
	wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
	*/
By productload=	By.xpath("//div[@class='card-body']/h5/b");
//List<WebElement> allimages=driver.findElements(By.cssSelector(".col-lg-4"));
@FindBy(css=".col-lg-4")
List<WebElement> allimages;
By productadd=By.cssSelector(".card-body button:last-of-type");
By toaster=By.id("toast-container");
//driver.findElement(By.cssSelector(".ng-animating"))
@FindBy(css=".ng-animating")
WebElement invis;

	public List<WebElement> getListProducts() {
		visibilityOfElement(productload);
		return allimages;
		}
	public WebElement filterName(String productname) {
		List<WebElement> allimages=getListProducts();
		WebElement prod=allimages.stream().filter(a->
		a.findElement(By.cssSelector("b")).getText().equals(productname)).findFirst().orElse(null);
		return prod;
	}
	public void addToCart(String productname) {
		WebElement prod=filterName(productname);
		//elementToBeClickable(productadd);
		WebElement addToCartBtn=prod.findElement(By.cssSelector(".card-body button:last-of-type"));
		clickElement(addToCartBtn);
		visibilityOfElement(toaster);
		invisibilityOfElement(invis);
		
	}
}
