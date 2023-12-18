package testcases;

import java.io.IOException;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.Test_Base;
import pages.Login_Page;
import utility.CaptureScreenshot;
public class VerifyMultiplecredentialsTest extends Test_Base
{
	Login_Page login;
	@BeforeMethod(alwaysRun = true)
	public void setup() throws InterruptedException, IOException 
	{
		initialization();
		login= new Login_Page();
	}
	@DataProvider(name="Credentials")
	public Object[][]getData()
	{
		return new Object[][]
				{
					{"standard_user","secret_sauce"},
					//"standard_user","secret_sauce"
					{"standard_user1","secret_sauce"},
					//"locked_out_user","secret_sauce"
					{"standard_user","secret_sauce1"},
					//"problem_user","secret_sauce"
					{"standard_user1","secret_sauce1"},
					//"performance_glitch_user","secret_sauce"
					//{},
					//"error_user","secret_sauce"
					//{},
					//"visual_user","secret_sauce"
				};
	}
	@Test(dataProvider = "Credentials")
	public void loginToAppWithMulticreds(String un, String pass)
	{
		SoftAssert s=new SoftAssert();
		String expURL="https://www.saucedemo.com/inventory.html";
		String actURL=login.loginToAppWithMulticreds(un, pass);
		s.assertEquals(expURL, actURL);
		s.assertAll();
		
	}
	@AfterMethod
	public void closebrowser(ITestResult it) throws IOException
	{
		if(it.FAILURE==it.getStatus())
		{
			CaptureScreenshot.screenshot(it.getName());
			
		}
		driver.close();
	}


}
