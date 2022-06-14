package Generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.System.Logger;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import PomScript.PomClass;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass
{
	public static WebDriver driver;
	public PomClass pom;
	public Properties ppt=new Properties();
 	@BeforeMethod
	public void setup() throws IOException
	{
		FileInputStream fis=new FileInputStream("./properties/SampleFile.properties");
		ppt.load(fis);
		String url=ppt.getProperty("applicationUrl");
		String mob=ppt.getProperty("mobNumber");
		String password=ppt.getProperty("password");
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
		driver.manage().window().maximize();
		pom=new PomClass(driver);
		pom.accounts();
		pom.enterMailOrNum(mob);
		pom.clkContinue();
		pom.enterPassword(password);
		pom.clkSubmit();
	}

	@AfterMethod
	public void tearDown(ITestResult result) throws IOException, InterruptedException
	{
		if(ITestResult.FAILURE==result.getStatus())
		{   
			Generic_Utility.screenCapture(driver); 
		}
		Thread.sleep(2000);
		driver.quit();
	}
}
