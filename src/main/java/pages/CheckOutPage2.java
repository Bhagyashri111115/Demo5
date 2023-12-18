package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Test_Base;

public class CheckOutPage2 extends Test_Base
{
	@FindBy(xpath="//span[@class='title']")private WebElement Titlecheckoutpage2;
	@FindBy(xpath="//div[@class='cart_quantity_label']")private WebElement QTY;
	@FindBy(xpath="//div[@class='cart_desc_label']")private WebElement Description;
	@FindBy(xpath="//div[text()='Payment Information']")private WebElement PaymentInfo;
	@FindBy(xpath="//div[text()='Shipping Information']")private WebElement ShiipingInfo;
	@FindBy(xpath="//div[text()='Price Total']")private WebElement Pricetotal;
	@FindBy(xpath="//button[@name='finish']")private WebElement FinishBtn;
	public CheckOutPage2()
	{
		PageFactory.initElements(driver, this);
	}
	public String verifyURLofTitlecheckoutpage2()
	{
		return driver.getCurrentUrl();
	}
	public String verifyQTY()
	{
		return QTY.getText();
	}
	public String verifyDescription()
	{
		return Description.getText();
	}
	public String verifyPaymentInfo()
	{
		return PaymentInfo.getText();
	}
	public String verifyShiipingInfo()
	{
		return ShiipingInfo.getText();
	}
	public String verifyPricetotal()
	{
		return Pricetotal.getText();
	}
	public String clickonfinishbtn()
	{
		FinishBtn.click();
		return driver.getCurrentUrl();
		
		
	}

}
