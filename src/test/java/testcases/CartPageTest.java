package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Test_Base;
import pages.CartPage;
import pages.Inventory_Page_2;
import pages.Login_Page;
import utility.CaptureScreenshot;

public class CartPageTest extends Test_Base
{
	Login_Page login;
	Inventory_Page_2 invent;
	CartPage cart;
	@BeforeMethod
	public void setup() throws InterruptedException, IOException
	{
		initialization();
		login=new Login_Page();
		invent=new Inventory_Page_2();
		cart=new CartPage();
		login.loginToApplication();
		invent.add6Products();
	}
	@Test
	public void verifyCartUrlApplicationTest() throws InterruptedException 
	{
		String actUrl="https://www.saucedemo.com/cart.html";
		String expUrl=cart.verifyCartUrlApplication();
		Thread.sleep(3000);
		Assert.assertEquals(expUrl, actUrl);
	}
	@Test
	public void verifyProductLableCartTest() 
	{
		String expLable="Your Cart";
		String actLable=cart.verifyProductLableCart();
		Assert.assertEquals(expLable, actLable);
		
	}
	@Test
	public void remove3ProductCartTest() throws InterruptedException {
		String expCount="3";
		String actCount=cart.remove3ProductCart();
		Assert.assertEquals(expCount, actCount);
	}
	@Test
	public void verifyContinueShoppingCartUrlTest() throws InterruptedException {
		String expUrl="https://www.saucedemo.com/inventory.html";
		String actUrl=cart.verifyContinueShoppingCartUrl();
		Assert.assertEquals(expUrl, actUrl);
	}
	@Test
	public void verifyUrlCheckoutTest() throws InterruptedException {
		String expUrl="https://www.saucedemo.com/checkout-step-one.html";
		String actUrl=cart.verifyUrlCheckout();
		Assert.assertEquals(expUrl, actUrl);
	}
	@Test
	public void verifyCartQTYlableTest() throws InterruptedException {
		String explable="QTY";
		String actLable=cart.verifyCartQTYlable();
		Assert.assertEquals(explable, actLable);
	}
	@Test
	public void verifyCartdecriptionLableTest() throws InterruptedException {
		String expLable="Description";
		String actLable=cart.verifyCartdecriptionLable();
		Assert.assertEquals(expLable, actLable);
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
