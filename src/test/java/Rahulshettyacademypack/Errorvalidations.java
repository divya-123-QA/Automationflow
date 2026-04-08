package Rahulshettyacademypack;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.Productcatalogue;
import reusabletest.Basetest;

import reusabletest.Retryfail;

public class Errorvalidations extends Basetest {
	
	@Test(groups= {"smoke"},retryAnalyzer=Retryfail.class)
	public void error() {
	landobj.login("rav123456@gmail.com","Money08$");
	String msgCheck=landobj.loginError();
	Assert.assertEquals(msgCheck,"Incorrect email or password.");
	}
	
} 