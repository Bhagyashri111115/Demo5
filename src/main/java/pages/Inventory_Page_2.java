package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.Test_Base;
import net.bytebuddy.asm.MemberSubstitution.FieldValue;
import utility.HandleDropdownList;

public class Inventory_Page_2 extends Test_Base
{
	//Object Repository
	@FindBy(xpath="//span[@class='title']")private WebElement ProductsLebal;
	@FindBy(xpath="//span[@class='shopping_cart_badge']")private WebElement Cartcount;
	@FindBy(xpath="// select[@class='product_sort_container']")private WebElement Dropdown;
	//element added
	@FindBy(xpath="// button[@id='add-to-cart-sauce-labs-backpack']")private WebElement BackPackProduct;
	@FindBy(xpath="// button[@id='add-to-cart-sauce-labs-bike-light']")private WebElement BikeLightProduct;
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']")private WebElement boltTshirt;
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-fleece-jacket']")private WebElement jacketproduct;
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-onesie']")private WebElement onesieproduct;
	@FindBy(xpath="//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']")private WebElement redTshirtproduct;
	//element Removed
	@FindBy(xpath="//button[@id='remove-sauce-labs-backpack']")private WebElement removeBackpack;
	@FindBy(xpath="//button[@id='remove-sauce-labs-bike-light']")private WebElement removebikeLightproduct;
	@FindBy(xpath="//button[@id='remove-sauce-labs-bolt-t-shirt']")private WebElement removeboltTshirtproduct;
	@FindBy(xpath="//button[@id='remove-sauce-labs-fleece-jacket']")private WebElement removefjacketproduct;
	@FindBy(xpath="//button[@id='remove-sauce-labs-onesie']")private WebElement removeOnesie;
	@FindBy(xpath="//button[@id='remove-test.allthethings()-t-shirt-(red)']")private WebElement removeTshirtRed;
	
	@FindBy(xpath="// a[text()='Twitter']")private WebElement TwitterLogo;
	@FindBy(xpath="//a[text()='Facebook']")private WebElement FacebookLogo;
	@FindBy(xpath="//a[text()='LinkedIn']")private WebElement LinkedInLogo;
	@FindBy(xpath="//div[@class='app_logo']")private WebElement Title ;
	@FindBy(xpath="(//div[@class='inventory_item_price'])[1]")private WebElement price;
	@FindBy(xpath="(//div[@class='inventory_item_img'])[1]")private WebElement image;
	
	
	//Constructor
	public Inventory_Page_2()
	{
		PageFactory.initElements(driver, this);;
	}
	public String verifyProductsLebal() throws InterruptedException
	{
		Thread.sleep(2000);
		return ProductsLebal.getText();
	}
	public boolean verifyimage() throws InterruptedException
	{
		Thread.sleep(3000);
		return image.isDisplayed();
	}
	public boolean verifyTwitterLogo() throws InterruptedException
	{
		Thread.sleep(2000);
		return TwitterLogo.isDisplayed();
	}
	public boolean verifyFacebookLogo() throws InterruptedException
	{
		Thread.sleep(0);
		return FacebookLogo.isDisplayed();
	}
	public boolean verifyprice() throws InterruptedException
	{
		Thread.sleep(2000);
		return price.isDisplayed();
	}
	public boolean verifyLinkedInLogo() throws InterruptedException
	{
		Thread.sleep(2000);
		return LinkedInLogo.isDisplayed();
	}
	public String VerifyTitleofApplication() throws InterruptedException
	{
		Thread.sleep(2000);
		return Title.getText();
	} 
	public String add6Products() throws InterruptedException
	{
		Thread.sleep(3000);
		HandleDropdownList.handleselectclass(Dropdown, "Price (low to high)");
		BikeLightProduct.click();
		BackPackProduct.click();
		boltTshirt.click();
		jacketproduct.click();
		onesieproduct.click();
		redTshirtproduct.click();
		
		return Cartcount.getText();
	}
	
	public String remove2Products() throws InterruptedException
	{
		add6Products();
		Thread.sleep(3000);
		removeBackpack.click();
		removebikeLightproduct.click();
		return Cartcount.getText();
		
	}
	
	}

