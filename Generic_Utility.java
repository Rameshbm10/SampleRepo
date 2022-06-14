package Generic;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Generic_Utility
{
	public static Select dropDown(WebElement dropdown)
	{
		Select sel=new Select(dropdown);
		return sel;
	}

	public static Robot keyBoard() throws AWTException
	{
		Robot rbt=new Robot();
		return rbt;
	}

	public static void screenCapture(WebDriver driver) throws IOException
	{
		TakesScreenshot tss=(TakesScreenshot)driver;
		File source=tss.getScreenshotAs(OutputType.FILE);
		Date d=new Date();
		String d1=d.toString();
		String d2 = d1.replace(":", "-");
		File destination=new File("./screenshot/photos"+d2+".jpeg");
		FileUtils.copyFile(source, destination);
	}

	public static JavascriptExecutor javaScript(WebDriver driver)
	{
		JavascriptExecutor jss=(JavascriptExecutor)driver;
		return jss;
	}
}
