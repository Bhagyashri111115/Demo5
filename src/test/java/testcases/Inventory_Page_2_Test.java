package testcases;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import base.Test_Base;
import io.netty.util.concurrent.AbstractEventExecutor;
import pages.Inventory_Page_2;
import pages.Login_Page;
import utility.ReadData;

public class Inventory_Page_2_Test extends Test_Base
{
	Login_Page Login;
	Inventory_Page_2 invent;
	@BeforeMethod (alwaysRun = true)
	public void setup() throws InterruptedException, IOException 
	{
		initialization();
		Login= new Login_Page();
		invent=new Inventory_Page_2();
		Login.loginToApplication();
	}
	@Test(priority = 4, enabled =true, groups = "Sanity")
	public void verifyProductsLebalTest() throws InterruptedException, EncryptedDocumentException, IOException
	{
		String expLabel=ReadData.readExcel(0, 3);//Products(0,3)
		String actLabel=invent.verifyProductsLebal();
		Assert.assertEquals(expLabel, actLabel);
		Reporter.log("Label of inventory page =" +actLabel);
	}
	@Test(priority = 1, enabled = true, groups = "Retesting")
	public void verifyTwitterLogoTest() throws InterruptedException
	{
		boolean result=invent.verifyTwitterLogo();
		Assert.assertEquals(result, true);
		Reporter.log("visibility of twitter logo ="+result);
	}
	@Test(priority = 2, enabled = true, groups = {"Regression","Retesting"})
	public void verifyimage() throws InterruptedException
	{
		boolean result=invent.verifyimage();
		Assert.assertEquals(result, true);
		Reporter.log("visinbility of image="+result);
	}
	@Test(priority = 3,enabled = true, groups = {"Regression","Retesting"})
	public void verifyprice() throws InterruptedException
	{
		boolean result=invent.verifyprice();
		Assert.assertEquals(result, true);
		Reporter.log("visibility of price="+result);
	}
	@Test(priority = 5,enabled = true, groups = "Sanity")
	public void verifyFacebookLogo() throws InterruptedException
	{
		boolean result=invent.verifyFacebookLogo();
		Assert.assertEquals(result, true);
		Reporter.log("Visibility of Facebook Logo =" +result);
    }
	@Test
	public void verifyLinkedInLogo() throws InterruptedException
	{
		boolean result=invent.verifyLinkedInLogo();
		Assert.assertEquals(result, true);
		Reporter.log("Visibility of LinkdIn Logo=" +result);		
	}
	@Test
	public void add6ProductsTest() throws InterruptedException, EncryptedDocumentException, IOException
	{
		String expcount=ReadData.readExcel(0, 4);//6(0,4)
		String actcount=invent.add6Products();
		Assert.assertEquals(expcount, actcount);
		Reporter.log("Total products added to cart="+actcount);
	}
	@Test
	public void VerifyTitleofApplication() throws InterruptedException
	{
		String expTitle="Swag Labs";
		String actTitle= invent.VerifyTitleofApplication();
		Assert.assertEquals(expTitle, actTitle);
	}
	@Test
	public void remove2ProductsTest() throws InterruptedException, EncryptedDocumentException, IOException
	{
		String expcount=ReadData.readExcel(0, 5);//4(0,5)
		String actcount=invent.remove2Products();
		Assert.assertEquals(expcount, actcount);
		Reporter.log("count of Product after removing="+actcount);
	}
	@AfterMethod (alwaysRun = true)
	public void closebrowser()
	{
		driver.close();
	}

}
