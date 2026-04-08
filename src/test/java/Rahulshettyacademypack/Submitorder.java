package Rahulshettyacademypack;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.Cartpage;
import pageobjects.Confirmationpage;
import pageobjects.Landing;
import pageobjects.Orderspage;
import pageobjects.Paymentpage;
import pageobjects.Productcatalogue;
import reusabletest.Basetest;

public class Submitorder extends Basetest{
	Orderspage ord;
@Test(dataProvider="setData")
	public void automationTesting(HashMap<String,String>Input) {
		// TODO Auto-generated method stub
/*WebDriver driver=new ChromeDriver();
//driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


Landing landobj=new Landing(driver);
landobj.goTO();*/
Productcatalogue prd=landobj.login(Input.get("username"),Input.get("pwds"));



//String productname="ZARA COAT 3";

prd.getListProducts();
prd.filterName(Input.get("Productname"));
prd.addToCart(Input.get("Productname"));



Cartpage car=new Cartpage(driver);
car.carttitle();
Paymentpage pay=car.cartdetails(Input.get("Productname"));



String countryname="India";
String cardno="123";
String tester="test";

pay.paymentDetails(countryname, cardno, tester);

/*WebElement confirmationmsg=driver.findElement(By.cssSelector("h1[class='hero-primary']"));
Assert.assertEquals(confirmationmsg.getText(),"THANKYOU FOR THE ORDER.");*/
 
Confirmationpage con=new Confirmationpage(driver);
con.confirmationdetails();
ord=con.validation();

}

@Test(dependsOnMethods= {"automationTesting"})
public void Order() {
	
//Orderspage ord=automationTesting();
	ord.Ordertitle();
	Boolean match=ord.Orderproduct();
	System.out.println(match);
	System.out.println("Github Webhooks");
}
@DataProvider
public Object[][] setData() throws IOException {
	/*Object[][] objs=new Object[1][3];
	objs[0][0]="rav123@gmail.com";
	objs[0][1]="Money08$";
	objs[0][2]="ZARA COAT 3";
	return objs;*/
	/*HashMap<String,String> objjs=new HashMap<String,String>();
	objjs.put("username","rav123@gmail.com");
	objjs.put("pwds","Money08$");
	objjs.put("Productname","ZARA COAT 3");*/
	List<HashMap<String,String>> sx=jsondata(System.getProperty("user.dir") 
	        + "\\src\\test\\java\\reusabletest\\Multipledataset.json");
	return new Object[][] { { sx.get(0) } };
}
}
