package Cucumbercode;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.Cartpage;
import pageobjects.Confirmationpage;
import pageobjects.Landing;
import pageobjects.Paymentpage;
import pageobjects.Productcatalogue;
import reusabletest.Basetest;

public class Stepdefinition extends Basetest{
	//public WebDriver driver;
	public Landing landobj;
	public Productcatalogue prd;
	public Cartpage car;
	public Paymentpage pay;
	
	@Given ("Go to URL")
	public void Go_to_URL() throws IOException {
		driver = browserInvoke();
        landobj = new Landing(driver);
        landobj.goTO();
		//landobj=initialLand();
	}
	
	@Given ("^user enters (.+) and (.+)$")
	public void user_enters_username_and_password(String username,String password) {
		prd=landobj.login(username,password);
	}

	@When ("^user select the product (.+) and add to cart$")
	public void When_user_select_the_product_name_and_add_to_cart(String productname) {
		prd.getListProducts();
		prd.filterName(productname);
		prd.addToCart(productname);
	}
	
	@And ("confirm the {string} is displayed in cart section")
		public void confirm_the_product_and_make_payment(String name) {
		car=new Cartpage(driver);
		car.carttitle();
		pay=car.cartdetails(name);
		
	}
	@And ("make payment with {string},{string},{string}")
	public void make_pay(String country,String card,String tesname) {
		pay.paymentDetails(country,card,tesname);
}
	@Then ("user should get the confirmation of order msg")
	public void confirm() {
		Confirmationpage con=new Confirmationpage(driver);
		con.confirmationdetails();
		con.validation();

	}
	
	@Then ("error message {string} should be displayed")
	public void errmsg(String mes) {
		String msgCheck=landobj.loginError();
		Assert.assertEquals(msgCheck,mes);
	}
	}

