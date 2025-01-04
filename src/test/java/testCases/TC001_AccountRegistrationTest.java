package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest  extends BaseClass{

	@Test
	public void verify_Account_Registration() {
		
		logger.info("*************starting TC001_AccountRegistrationTest**********");
		
		try {
		// create object of HomePage class to access variable and method
		HomePage hp= new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on My Account");
		
		hp.clickRegister();
		logger.info("Clicked on Rwegister link");
		// create object of AccountRegistrationPage class to access variable and method
		AccountRegistrationPage acregpage= new AccountRegistrationPage(driver);
		
		logger.info("Providing customer details");
		acregpage.setFirstName(randomString().toUpperCase());
		acregpage.setLastName(randomString().toUpperCase());
		acregpage.setEmail(randomString()+"@gmail.com");  // randomaly generate Email
		acregpage.setTelephone(randomNumbers());
		
		String password=randomAlphaNumeric();// randomly generate password data
		
		acregpage.setPassword(password);
		acregpage.setConfirmPassword(password);
		acregpage.clickAgrreCheckBox();
		acregpage.clickContinue();
		
		logger.info("Validation expected message....");
		String confmsg=acregpage.getConfirmationMsg();
		
		if(confmsg.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("Test Failed.....");
			logger.debug("Debug logs....");
			Assert.assertTrue(false);
		}
		//Assert.assertEquals(confmsg," Your Account Has Been Created!!");
		
		}
		catch(Exception e) {
		
			Assert.fail();
		}
		logger.info("*************finished TC001_AccountRegistrationTest**********");
	}
	
	
}
