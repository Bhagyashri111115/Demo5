package testcases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import base.Test_Base;
import pages.Login_Page;
import utility.CaptureScreenshot;
import utility.ReadData;

public class LoginPageTest extends Test_Base
{
	Login_Page login;
	@BeforeMethod (alwaysRun = true)
	public void setup() throws InterruptedException, IOException 
	{
		initialization();
		login= new Login_Page();
	}
	
	@Test(enabled = false ,priority = 3, groups ="Sanity")
	public void VerifyTitleofApplication() throws EncryptedDocumentException, IOException
	{
		String expTitle=ReadData.readExcel(0, 0);//Swag Labs(0,0)
		String actTitle= login.VerifyTitleofApplication();
		Assert.assertEquals(expTitle, actTitle);
	}
	
	@Test( enabled = true,priority = 2, groups={"Sanity","Retesting"})
	public void Title() throws EncryptedDocumentException, IOException
	{
		String expURL=ReadData.readExcel(0, 1);//https://www.saucedemo.com/(0,1)
		String actURL= login.verifyCartURLApplicationTestpage();
		Assert.assertEquals(expURL, actURL);
	}
	@Test(enabled = true,priority = 1)
	public void loginToApplicationTest() throws IOException
	{
		String expURL=ReadData.readExcel(0, 2);//https://www.saucedemo.com/inventory.html(0,2)
		String actURL=login.loginToApplication();
		Assert.assertEquals(expURL, actURL);
	}
	
	@AfterMethod(alwaysRun = true)
	public void closebrowser(ITestResult it) throws IOException
	{
		if(it.FAILURE==it.getStatus())
		{
			CaptureScreenshot.screenshot(it.getName());
			
		}
		report.flush();
		driver.close();
	}

}
