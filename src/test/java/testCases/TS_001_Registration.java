package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import testBase.BaseClass;

public class TS_001_Registration extends BaseClass
{
	
	@Test(groups={"Sanity"})
	public void account_Register()
	{
		logger.info("*** Test Case Started ***");
		try {
			HomePage hm = new HomePage(driver);
			hm.clickMyAccount();
			logger.info("Clicked on My Account");
			hm.clickRegister();
			logger.info("Clicked on Register");
			
			RegistrationPage rp = new RegistrationPage(driver);
			
			logger.info("Providing Customer Details");
			rp.setFirstName(randomString());
			rp.setLastName(randomString());
			rp.setEmail(randomString()+"@gmail.com");
			rp.setTelephone(randomNumber());
			String password = randomAlphanumeric();
			rp.setPassword(password);
			rp.setConfirmPwd(password);
			rp.clickPolicy();
			rp.clickContinue();
			logger.info("Validating Expected result");
			String ConfMsg = rp.getConfirmationMsg();
			//Assert.assertEquals(ConfMsg, "Your Account Has Been Created!");
			if(ConfMsg.equals("Your Account Has Been Created!"))
			{
				Assert.assertTrue(true);
			}
			else
			{
				logger.error("Test Failed");
				logger.debug("Debug logs.......");
				Assert.assertTrue(false);
			}
			
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("*** Test Case Finished ***");
	}
}
