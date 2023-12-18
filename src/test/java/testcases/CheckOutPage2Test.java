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
import pages.CheckOutPage2;
import pages.CheckoutPage1;
import pages.Inventory_Page_2;
import pages.Login_Page;
import utility.CaptureScreenshot;

public class CheckOutPage2Test extends Test_Base
{
	Login_Page login;
	Inventory_Page_2 invent;
	CartPage cart;
	CheckoutPage1 check1;
	CheckOutPage2 check2;
	@BeforeMethod (alwaysRun = true)
	public void setup() throws InterruptedException, IOException
	{
		initialization();
		login=new Login_Page();
		invent=new Inventory_Page_2();
		cart=new CartPage();
		check1=new CheckoutPage1();
		check2=new CheckOutPage2();
		login.loginToApplication();
		invent.add6Products();
		cart.verifyUrlCheckout();
		check1.Inputinformation();
	}
	@Test
	public void verifyURLofCTitlecheckoutpage2()
	{
		String expURL="https://www.saucedemo.com/checkout-step-two.html";
		String actURL=check2.verifyURLofTitlecheckoutpage2();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("URL of checkout page 2="+actURL);
	}
	@Test
	public void verifyQTY()
	{
		String explebal="QTY";
		String actlebal=check2.verifyQTY();
		Assert.assertEquals(explebal, actlebal);
		Reporter.log("label of qty ="+actlebal);
	}
	@Test
	public void verifyDescription()	
	{
		String expD="Description";
		String actD=check2.verifyDescription();
		Assert.assertEquals(expD, actD);
		Reporter.log("visibility of description="+actD);
	}
	@Test
	public void verifyPaymentInfo()
	{
		String exppayment="Payment Information";
		String actpayment=check2.verifyPaymentInfo();
		Assert.assertEquals(exppayment, actpayment);
		Reporter.log("visibility of payment=" +actpayment);
	}
	@Test
	public void verifyShiipingInfo()
	{
		String expshipping="Shipping Information";
		String actshipping=check2.verifyShiipingInfo();
		Assert.assertEquals(expshipping, actshipping);
		Reporter.log("visibility of shipping=" +actshipping);
	}
	public void verifyPricetotal() 
	{
		String exppricetotal="Price Total";
		String actpricetotal=check2.verifyPricetotal();
		Assert.assertEquals(exppricetotal, actpricetotal);
		Reporter.log("visibility of price ="+actpricetotal);
	}
	@AfterMethod (alwaysRun = true)
	public void closeBrowser(ITestResult it) throws IOException 
	{
		if(it.FAILURE==it.getStatus())
		{
			CaptureScreenshot.screenshot(it.getName());
		}
		driver.close();
	}

}
