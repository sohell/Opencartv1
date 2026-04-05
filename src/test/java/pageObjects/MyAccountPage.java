package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage
{
	public MyAccountPage(WebDriver driver)
	{
		super(driver);
	}

	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement msgHeading;
	
	@FindBy(xpath = "//div[@class='list-group']//a[text()='Logout']")
	WebElement lnkLogout;
	
	@FindBy(xpath="//a[@title='My Account']")
	WebElement myAccount;
	
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Logout']")
	WebElement lnkLogout1;
	
	@FindBy(xpath="//a[normalize-space()='Desktops']")
	WebElement desktopHeader;
	
	@FindBy(xpath="//a[normalize-space()='Show AllDesktops']")
	WebElement showAllDesktopHeader;
	
	public void clickLogout()
	{
		lnkLogout.click();
	}
	
	public void clickMyAccount()
	{
		myAccount.click();
	}
	
	public void clickLogout1()
	{
		lnkLogout1.click();
	}
	
	public void hoverOverDesktop()
	{
		actions.moveToElement(desktopHeader).perform();;
	}
	
	public void clickOnShowAllDesktop()
	{
		actions.moveToElement(showAllDesktopHeader).doubleClick().perform();;
	}
	
	public boolean isAccountPageExist()
	{
		try
		{
			return msgHeading.isDisplayed();
		}
		catch(Exception e)
		{
			return false;
		}
		
	}
}
