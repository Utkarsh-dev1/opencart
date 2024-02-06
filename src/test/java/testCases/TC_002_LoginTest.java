package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass

{
	@Test(groups = { "sanity", "master" })
	public void verify_login()

	{
		logger.info("*** Starting TC_002_LoginTest **** ");

		try {

			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();

			LoginPage login = new LoginPage(driver);

			logger.info("entering login details");
			login.setEmail(p.getProperty("email"));
			logger.info("entering password detail");
			login.setPassword(p.getProperty("password"));
			logger.info("login clicked");
			login.clickLogin();

			MyAccountPage Myap = new MyAccountPage(driver);

			boolean targetPage = Myap.isMyAccountPageExists();

			if (targetPage == true) {

				Assert.assertTrue(true);
			}

			else {

				Assert.fail();
			}

		} catch (Exception e) {

			Assert.fail();

		}

	}

}
