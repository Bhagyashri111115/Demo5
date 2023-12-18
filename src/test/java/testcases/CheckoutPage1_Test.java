package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Test_Base;
import pages.CartPage;
import pages.CheckoutPage1;
import pages.Inventory_Page_2;
import pages.Login_Page;
import utility.CaptureScreenshot;

public class CheckoutPage1_Test extends Test_Base
{
	Login_Page login;
	Inventory_Page_2 invent;
	CartPage cart;
	CheckoutPage1 check1;
	@BeforeMethod
	public void setup() throws InterruptedException, IOException
	{
		initialization();
		login=new Login_Page();
		invent=new Inventory_Page_2();
		cart=new CartPage();
		check1=new CheckoutPage1();
		login.loginToApplication();
		invent.add6Products();
		cart.verifyUrlCheckout();
	}
	@Test
	public void verifyURLofCheckoutPage1()
	{
		String expURL="https://www.saucedemo.com/checkout-step-one.html";
		String actURL=check1.verifyURLofCheckoutPage1();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("URL of checkoutpage1="+actURL);
	}
	@Test
	public void verifytitleofapplication()
	{
		String expTitle="Checkout: Your Information";
		String actTitle=check1.verifytitleofapplication();
		Assert.assertEquals(expTitle, actTitle);
		Reporter.log("Title of page="+actTitle);
	}
	@Test
	public void Inputinformation()
	{
		String expURL="https://www.saucedemo.com/checkout-step-two.html";
		String actURL=check1.Inputinformation();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("Title of checkout page 2 ="+actURL);
	}
	@AfterMethod
	public void closeBrowser(ITestResult it) throws IOException 
	{
		if(it.FAILURE==it.getStatus()) {
			CaptureScreenshot.screenshot(it.getName());
		}
		driver.close();
	}

}
