package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TS_003_LoginDDT extends BaseClass
{
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class,groups={"Regression","Master"})
	void verify_loginDDT(String email, String password, String expected)
	{
		HomePage hp = new HomePage(driver);
		try
		{
			hp.clickMyAccount();
			logger.info("My Account Clicked ");
			hp.clickLogin();
			logger.info("Login clicked");
			
			LoginPage lp = new LoginPage(driver);
			
			lp.setEmail(email);
			logger.info("Entered Email ");
			lp.setPassword(password);
			logger.info("Entered password ");
			lp.clickLogin();
			logger.info("Clicked on login ");
			
			MyAccountPage ap = new MyAccountPage(driver);
			
			logger.info("Validation");
			boolean status = ap.isAccountPageExist();
			System.out.println(status);
			logger.info("validation start");
			
			if(expected.equalsIgnoreCase("valid"))
			{
				if(status==true)
				{
					ap.clickLogout();
					Assert.assertTrue(true);
				}
				else
				{
					Assert.assertTrue(false);
				}
			}
			if(expected.equalsIgnoreCase("invalid"))
			{
				if(status==true)
				{
					ap.clickLogout();
					Assert.assertTrue(false);
				}
				else
				{
					Assert.assertTrue(true);
				}
			}
			
		}
		catch(Exception e)
		{
			Assert.fail("An exception occurred: " + e.getMessage());
		}
		
		
		
	}

}
