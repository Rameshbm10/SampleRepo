package TestScript;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Set;
import java.util.function.Function;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Generic.BaseClass;
import Generic.Generic_Utility;

public class AddToCartTestCase extends BaseClass
{
	@Test(priority = 1)
	public void addToCart() throws Exception
	{
		FileInputStream fis=new FileInputStream("./properties/SampleFile.properties");
		ppt.load(fis);
		String product=ppt.getProperty("product");
		pom.serch(product);
		pom.clickSearchIcon();
		pom.iteamSelect();
		String parentid=driver.getWindowHandle();
		Set<String> allids = driver.getWindowHandles();
		for(String id:allids)
		{
			if(id.equals(parentid))
			{
				System.out.println();
			}
			else
			{
				driver.switchTo().window(id);
				pom.cart();
				String text = pom.validation();
				System.out.println(text);
				System.out.println("making testCase fail intentionally");
				Assert.assertEquals(text, "Added to Cart");
				System.out.println("testcase1 passed");
			}
		}
	}

	@Test(priority = 2)
	public void removeFromCart() 
	{
		pom.clickCartIcon();
		WebElement sel = pom.getQty();
		Select quantity = Generic_Utility.dropDown(sel);
		quantity.selectByIndex(0);
		String text = pom.checkIteamRemoveText();
		Assert.assertEquals(text.contains("was removed from Shopping Cart."), true);
		System.out.println("testcase2 passed");
	}

	@Test(priority = 3)
	public void addMoneyToWallet() throws Exception
	{
		FileInputStream fis=new FileInputStream("./properties/SampleFile.properties");
		ppt.load(fis);
		String amount=ppt.getProperty("amount");
		String cvv=ppt.getProperty("cvv");
		String otp=ppt.getProperty("otp");
		pom.accountsAndList();
		pom.addMoneyToAcc();
		pom.moneyTextField(amount);
		pom.addMoneyToAccountBtn();
		pom.enterCVV(cvv);
		pom.clickPlaceOrderBtn();
		pom.clickWithoutSaveBtn();
		pom.enterOtp(otp);
		pom.makePaymentBtn();
		Assert.assertEquals(true,false);
	}
}
