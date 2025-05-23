package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TS_002_LoginTest extends BaseClass 
{
	@Test(groups={"Sanity","Master"})
	public void account_Login()
	{
		logger.info("TS_002_Test case Started");
		try
		{
			HomePage hp = new HomePage(driver);
			
			hp.clickMyAccount();
			logger.info("Clicked on My Account");
			hp.clickLogin();
			logger.info("Clicked on Login");
			
			LoginPage lg = new LoginPage(driver);
			
			lg.setEmail(prop.getProperty("email"));
			logger.info("Email entered");
			lg.setPassword(prop.getProperty("password"));
			logger.info("Password entered");
			lg.clickLogin();
			logger.info("clicked on login");
			
			MyAccountPage ap = new MyAccountPage(driver);
			
			logger.info("Validation");
			boolean status = ap.isAccountPageExist();
			
			Assert.assertTrue(status);
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("TS_002_Test case Finished");
	}
}
