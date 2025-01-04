package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass{
	
	@Test
	public void verify_Login() {
		logger.info("*******Starting TC002*********");
		try{
	
		//Access homepage mehtiod
		HomePage hp= new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		
		// Access methods from Login Page class
		LoginPage lp= new LoginPage(driver);
		//lp.setEmailAddress(p.getProperty("email"));
	//	lp.setPassword(p.getProperty("password"));
		
		lp.setEmailAddress("veertest@gmail.com");
		lp.setPassword("Veer@0080");
		lp.clickLoginBtn();
		
		//Acceess MyAccount Page
		
		MyAccountPage macc= new MyAccountPage(driver);
	boolean targetPage=	macc.isMyAccountPageExists();
	
	Assert.assertEquals(targetPage, true,"Login Failed");
	//Assert.assertTrue(targetPage);
		} catch(Exception e) {
			Assert.fail();
		}
	logger.info("***********Finished TC002*******");
	}
		
		
}
