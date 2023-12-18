package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import base.Test_Base;
import utility.ReadData;

public class Login_Page extends Test_Base
{
	@FindBy(xpath="//input[@name='user-name']")private WebElement userTxtBox;
	@FindBy(xpath="//input[@name='password']")private WebElement passwordTxtBox;
	@FindBy(xpath="//input[@name='login-button']")private WebElement loginBtn;
	

	public Login_Page()
	{
		PageFactory.initElements(driver, this);
	}
	public String loginToApplication() throws IOException
	{
		logger= report.createTest("Login to sauce lab application");
		userTxtBox.sendKeys("standard_user");
		logger.log(Status.INFO, "User Name is entered");
		passwordTxtBox.sendKeys("secret_sauce");
		logger.log(Status.INFO, "password is entered");
		loginBtn.click();
		logger.log(Status.INFO, "Login btn is click");
		logger.log(Status.PASS, "Login is successfull");
		return driver.getCurrentUrl();
	}
	public String loginToAppWithMulticreds(String un, String pass)
	{
		userTxtBox.sendKeys(un);
		passwordTxtBox.sendKeys(pass);
		loginBtn.click();
		return driver.getCurrentUrl();
		
	}
	
	public String VerifyTitleofApplication()
	{
		return driver.getTitle();
	}
	public String verifyCartURLApplicationTestpage()
	{
		return driver.getCurrentUrl();
	}
	
	}
	
	
	
	
	
	


