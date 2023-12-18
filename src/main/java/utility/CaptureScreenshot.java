package utility;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import base.Test_Base;

public class CaptureScreenshot extends Test_Base
{
	public static String getData()
	{
		return new SimpleDateFormat("dd-MM-YYYY ss-mm-HH").format(new Date());
	}
	public static void screenshot(String nameOfMethod) throws IOException
	{
		File source =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest=new File("C:\\Users\\bhagy\\eclipse-workspace3\\Demo4_Selenium\\Screenshot\\"+nameOfMethod+"--"+getData()+".jpeg");
		FileHandler.copy(source, dest);
	}
}
