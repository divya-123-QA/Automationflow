package Rahulshettyacademypack;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Standalone {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
WebDriver driver=new ChromeDriver();
//driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
driver.get("https://rahulshettyacademy.com/client");
WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
 wait.until( ExpectedConditions.visibilityOfElementLocated(By.id("userEmail")));
driver.findElement(By.id("userEmail")).sendKeys("rav123@gmail.com");
driver.findElement(By.id("userPassword")).sendKeys("Money08$");
driver.findElement(By.xpath("//input[@type='submit']")).click();

wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='card-body']/h5/b")));
List<WebElement> allimages=driver.findElements(By.cssSelector(".col-lg-4"));
/*for(int i=0;i<allimages.size();i++) {
	System.out.println(allimages.get(i).getText());
	
}*/
WebElement prod=allimages.stream().filter(a->
a.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")).findFirst().orElse(null);
//System.out.println(product.getText());
prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
wait.until( ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));

driver.findElement(By.cssSelector("button[routerlink*='cart']")).click();
List<WebElement> cartsection=driver.findElements(By.cssSelector(".cartSection h3"));
Boolean cartcheck=cartsection.stream().anyMatch(s->s.getText().equalsIgnoreCase("ZARA COAT 3"));
Assert.assertTrue(cartcheck);
driver.findElement(By.cssSelector("button[class*='btn-primary']:nth-child(1)")).click();

Actions v=new Actions(driver);
v.sendKeys(driver.findElement(By.xpath("//input[@placeholder='Select Country']")),"India").build().perform();
driver.findElement(By.xpath("//span[text()=' India']")).click();
//wait.until( ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[class*='action__submit']")));
driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("123");
driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys("test");
wait.until( ExpectedConditions.elementToBeClickable(By.cssSelector(".action__submit")));
driver.findElement(By.cssSelector(".action__submit")).click();
WebElement confirmationmsg=driver.findElement(By.cssSelector("h1[class='hero-primary']"));
Assert.assertEquals(confirmationmsg.getText(),"THANKYOU FOR THE ORDER.");
	}

}
