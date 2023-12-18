package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Test_Base;

public class Completepage extends Test_Base
{
@FindBy(xpath="//span[@class='title']")private WebElement CheckoutComplete;
@FindBy(xpath="//div[@class='complete-text']")private WebElement completetext;
@FindBy(xpath="//button[@name='back-to-products']")private WebElement backHomebtn;
@FindBy(xpath="//div[@class='footer_copy']")private WebElement  footertext;
public Completepage()
	{
	PageFactory.initElements(driver, this);
	}
public String verifyURLoftitleCompletepage()
	{
	return driver.getCurrentUrl();
	}
public String verifytitle()
	{
	return CheckoutComplete.getText();
	}
public String verifycompletetext()
	{
	return completetext.getText();
	}
public String verifyfootertext()
	{
	return footertext.getText();
	}
public String verifyhomebtn()
	{
	backHomebtn.click();
	return driver.getCurrentUrl();
	}


}

