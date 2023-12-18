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
import pages.Completepage;
import pages.Inventory_Page_2;
import pages.Login_Page;
import utility.CaptureScreenshot;

public class CompletepageTest extends Test_Base
{
	Login_Page login;
	Inventory_Page_2 invent;
	CartPage cart;
	CheckoutPage1 check1;
	CheckOutPage2 check2;
	Completepage comp;
	@BeforeMethod
	public void setup() throws InterruptedException, IOException
	{
		initialization();
		login=new Login_Page();
		invent=new Inventory_Page_2();
		cart=new CartPage();
		check1=new CheckoutPage1();
		check2=new CheckOutPage2();
		comp=new Completepage();
		login.loginToApplication();
		invent.add6Products();
		cart.verifyUrlCheckout();
		check1.Inputinformation();
		check2.clickonfinishbtn();
	}
	@Test
	public void verifyURLoftitleCompletepage()
		{
		String expURL="https://www.saucedemo.com/checkout-complete.html";
		String actURL=comp.verifyURLoftitleCompletepage();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("URL of complete page =" +actURL);
		}
	@Test
	public void verifytitle()
	{
		String exptitle="Checkout: Complete!";
		String acttitle=comp.verifytitle();
		Assert.assertEquals(exptitle, acttitle);
		Reporter.log("title of complete page =" +acttitle);
	}
	@Test
	public void verifycompletetext()
	{
		String expct="Your order has been dispatched, and will arrive just as fast as the pony can get there!";
		String actct= comp.verifycompletetext();
		Assert.assertEquals(expct, actct);
		Reporter.log("complete text ="+actct);
	}
	@Test
	public void verifyfootertext()
	{
		String expFooter="© 2023 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy";
		String actFooter=comp.verifyfootertext();
		Assert.assertEquals(expFooter, actFooter);
		Reporter.log("visibility of text ="+actFooter);
	}

	@AfterMethod
	public void closeBrowser(ITestResult it) throws IOException 
	{
		if(it.FAILURE==it.getStatus())
		{
			CaptureScreenshot.screenshot(it.getName());
		}
		driver.close();
	}

}
