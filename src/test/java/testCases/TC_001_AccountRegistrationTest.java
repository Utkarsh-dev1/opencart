package testCases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass {

	/*
	 * http://localhost/opencart/upload
	 * 
	 * http://localhost/opencart/upload/admin
	 * 
	 */

	@Test(groups = { "regression", "master" })
	public void test_account_Registration() throws InterruptedException

	{

		try {

			// Created object of HomePage to access all method and locators from HomePage
			// class
			logger.info("*** Starting TC_001_AccountRegistrationTest ***");
			HomePage hp = new HomePage(driver);

			logger.info("clicked on MyAccount");
			hp.clickMyAccount();

			logger.info("clicked in Registration");
			hp.clickRegister();

			// Created object of AccountRegistrationPage to access all method and locators
			// from AccountRegistrationPage class
			logger.info("Entering customer detail");
			AccountRegistrationPage regpage = new AccountRegistrationPage(driver);

			regpage.setFirstName(randomString().toUpperCase());

			regpage.setLastName(randomString().toUpperCase());

			regpage.setEmail(randomString() + "@gmail.com"); // Randomly generate the email

			regpage.setTelephone(randomNumber());

			String password = AlphaNumeric();

			regpage.setPassword(password);

			regpage.ConfirmPassword(password);

			regpage.setPrivacyPloicy();

			regpage.clickContinue();
			logger.info("clicked on continue");

			String confmsg = regpage.getConfirmationMsg();

			logger.info("Validating  expected message");

			if (confmsg.equals("Your Account Has Been Created!")) {

				logger.info("test passed");
				Assert.assertTrue(true);
			}

			else {
				logger.error("test failed");
				Assert.fail();
			}

		}

		catch (Exception e) {
			logger.info("test failed");
			Assert.fail();
		}
		logger.info("*** finished TC_001_AccountRegistrationTest ***");
	}

}
