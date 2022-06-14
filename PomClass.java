package PomScript;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Generic.Generic_Utility;

public class PomClass 
{
	@FindBy(id="twotabsearchtextbox")
	private WebElement searchBox;

	@FindBy(xpath="//span[text()='Account & Lists']")
	private WebElement accountslnk;

	@FindBy(xpath="//input[@type='email']")
	private WebElement email;

	@FindBy(xpath="//input[@id='continue']")
	private WebElement continueBtn;

	@FindBy(xpath="//input[@type='password']")
	private WebElement password;

	@FindBy(xpath="//input[@id='signInSubmit']")
	private WebElement singInBtn;

	@FindBy(id="nav-search-submit-button")
	private WebElement searchIcon;

	@FindBy(xpath="//span[text()='Apple iPhone 13 Pro (128 GB) - Alpine Green']")
	private WebElement iteam;

	@FindBy(xpath="//input[@id='add-to-cart-button']")
	private WebElement addToCart;

	@FindBy(xpath="//select[@id='quantity']")
	private WebElement quantity;

	@FindBy(xpath="//h2[contains(.,'Login')]")
	private WebElement loginbx;

	@FindBy(xpath="//span[text()='Sign Out']")
	private WebElement signOut;

	@FindBy(xpath="(//span[contains(.,'Added to Cart')])[1]")
	private WebElement confirm;

	@FindBy(xpath="//a[@id='nav-cart']")
	private WebElement cartIcon;

	@FindBy(xpath="//select[@id='quantity']")
	private WebElement qty;

	@FindBy(xpath="//span[text()='Add money to your balance']")
	private WebElement addMoney;

	@FindBy(xpath="//input[@name='amount']")
	private WebElement amtText;

	@FindBy(xpath="//input[@value='Checkout']")
	private WebElement amtSubmitBtn;

	@FindBy(xpath="//a[@id='nav-link-accountList']")
	private WebElement accAndLists;

	@FindBy(xpath="//span[contains(.,'was removed from Shopping Cart.')]")
	private WebElement removeIteamText;

	@FindBy(xpath="//input[@type='password']")
	private WebElement cvv;

	@FindBy(xpath="//span[text()='Place Order and Pay']")
	private WebElement placeOrderBtn;

	@FindBy(xpath="//span[text()='Continue without saving card']")
	private WebElement witoutSaveOpt;

	@FindBy(xpath="//input[@name='customerotp']")
	private WebElement otptext;

	@FindBy(xpath="//button[text()='Make Payment']")
	private WebElement makepay;

	public PomClass(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void makePaymentBtn()
	{
		makepay.click();
	}
	public void enterOtp(String otp)
	{
		otptext.sendKeys(otp);
	}
	public void clickWithoutSaveBtn()
	{
		witoutSaveOpt.click();
	}
	public void clickPlaceOrderBtn()
	{
		placeOrderBtn.click();
	}
	public void enterCVV(String cvvValue)
	{
		cvv.sendKeys(cvvValue);
	}
	public String checkIteamRemoveText()
	{
		String removeText = removeIteamText.getText();
		return removeText;
	}
	public WebElement confirmMsg()
	{
		return confirm;
	}
	public void accountsAndList()
	{
		accAndLists.click();
	}
	public void addMoneyToAccountBtn()
	{
		amtSubmitBtn.click();
	}
	public void moneyTextField(String amount)
	{
		amtText.clear();
		amtText.sendKeys(amount);
	}
	public void addMoneyToAcc()
	{
		addMoney.click();
	}
	public WebElement getQty()
	{
		return qty;
	}
	public void clickCartIcon()
	{
		cartIcon.click();
	}
	public String validation()
	{
		String text = confirm.getText();
		return text;
	}
	public void signOutlink()
	{
		signOut.click();
	}
	public void loginLink()
	{
		loginbx.click();
	}

	public void enterMailOrNum(String number)
	{
		email.sendKeys(number);
	}
	public void clkContinue()
	{
		continueBtn.click();
	}
	public void enterPassword(String pwd)
	{
		password.sendKeys(pwd);
	}
	public void clkSubmit()
	{
		singInBtn.click();   
	}
	public void iteamSelect()
	{
		iteam.click();
	}
	public void cart()
	{
		addToCart.click();
	}
	public void qty()
	{
		quantity.click();
	}
	public void serch(String iteam)
	{
		searchBox.sendKeys(iteam);   
	}
	public void clickSearchIcon()
	{
		searchIcon.click();
	} 
	public void accounts()
	{
		accountslnk.click();
	}

}
