package pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage
{
	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement lnkMyAccount;
	
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement lnkRegister;
	
	@FindBy(xpath="//a[normalize-space()='Login']")
	WebElement lnkLogin;
	
	@FindBy(xpath="//input[@placeholder='Search']")
	WebElement txtSearch;
	
	@FindBy(xpath="//button[@class='btn btn-default btn-lg']")
	WebElement btnSearch;
	
	@FindBy(xpath="//span[@id='cart-total']")
	WebElement btnCart;
	//By cartLocator = By.xpath("//span[@id='cart-total']");

	
	@FindBy(xpath="//strong[normalize-space()='View Cart']")
	WebElement btnViewCart;
	
	@FindBy(xpath="//strong[normalize-space()='Checkout']")
	WebElement btnCheckout;
	
	public void clickMyAccount()
	{
		lnkMyAccount.click();
	}
	
	public void clickRegister()
	{
		lnkRegister.click();
	}
	
	public void clickLogin()
	{
		lnkLogin.click();
	}
	//Test to commit
	public void searchProduct(String product)
	{
		txtSearch.sendKeys(product);
	}

	public void clickSearch()
	{
		btnSearch.click();
	}
	
	public void clearSearch()
	{
		txtSearch.clear();
	}
	
	public void clickCart()
	{
		//waitForVisibility(btnCart).click();;
	   // wait.until(ExpectedConditions.elementToBeClickable(cartLocator)).click();
		js.executeScript("arguments[0].click()", btnCart);
	}
	
	public void clickViewCart()
	{
		//wait.until(ExpectedConditions.visibilityOf(btnViewCart)).click();
		//waitForVisibility(btnViewCart).click();
		js.executeScript("arguments[0].click()", btnViewCart);
	}
	
	public void clickCheckout()
	{
		wait.until(ExpectedConditions.elementToBeClickable(btnCheckout)).click();
		//btnCheckout.click();
	}
}
