package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Test_Base;

public class CheckoutPage1 extends Test_Base
{
	@FindBy(xpath="//span[@class='title']")private WebElement Titleofcheckoutpage;
	@FindBy(xpath="//input[@name='firstName']") private WebElement firstname;
	@FindBy(xpath="//input[@name='lastName']")private WebElement lastname;
	@FindBy(xpath="//input[@name='postalCode']")private WebElement Zipcode;
	//@FindBy(xpath="//button[@name='cancel']")private WebElement cancelbutton;
	@FindBy(xpath="//input[@name='continue']")private WebElement continuebtn;
	public CheckoutPage1()
		{
			PageFactory.initElements(driver, this);
		}
		public String verifyURLofCheckoutPage1()
		{
			return driver.getCurrentUrl();
		}
		public String verifytitleofapplication()
		{
			return Titleofcheckoutpage.getText();
		}
		public String Inputinformation()
		{
			firstname.sendKeys("Harry");
			lastname.sendKeys("Potter");
			Zipcode.sendKeys("411087");
			continuebtn.click();
			return driver.getCurrentUrl();
			
		}
		
}


