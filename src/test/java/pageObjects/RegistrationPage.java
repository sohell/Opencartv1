package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage extends BasePage
{
	public RegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath=("//input[@id='input-firstname']")) WebElement txtFirstName;
	@FindBy(xpath=("//input[@id='input-lastname']")) WebElement txtLastName;
	@FindBy(xpath=("//input[@id='input-email']")) WebElement txtEmail;
	@FindBy(xpath=("//input[@id='input-telephone']")) WebElement txtTelephone;
	@FindBy(xpath=("//input[@id='input-password']")) WebElement txtPassword;
	@FindBy(xpath=("//input[@id='input-confirm']")) WebElement txtConfirmPwd;
	@FindBy(xpath=("//input[@name='agree']")) WebElement chkdPolicy;
	@FindBy(xpath=("//input[@value='Continue']")) WebElement btnContinue;
	@FindBy(xpath=("//h1[normalize-space()='Your Account Has Been Created!']")) WebElement successMsg;
	
	public void setFirstName(String fname)
	{
		txtFirstName.sendKeys(fname);
	}
	
	public void setLastName(String lname)
	{
		txtLastName.sendKeys(lname);
	}
	
	public void setEmail(String email)
	{
		txtEmail.sendKeys(email);
	}
	
	public void setTelephone(String telephone)
	{
		txtTelephone.sendKeys(telephone);
	}
	
	public void setPassword(String password)
	{
		txtPassword.sendKeys(password);
	}
	
	public void setConfirmPwd(String CPwd)
	{
		txtConfirmPwd.sendKeys(CPwd);
	}
	public void clickPolicy()
	{
		chkdPolicy.click();
	}
	
	public void clickContinue()
	{
		btnContinue.click();
	}
	
	public String getConfirmationMsg()
	{
		try
		{
			return(successMsg.getText());
		}
		catch(Exception e)
		{
			return(e.getMessage());
		}
	}
}
