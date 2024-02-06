package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Utilities.DataProviders;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_003_LoginDDT extends BaseClass {

	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class)
	public void verify_loginDDT(String email, String password, String exp)

	{

		logger.info("*** Starting TC_003_LoginDDT *** ");

		// Home Page
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();

		// Login Page
		LoginPage login = new LoginPage(driver);

		logger.info("entering login details");
		login.setEmail(email);
		logger.info("entering password detail");
		login.setPassword(password);
		logger.info("login clicked");
		login.clickLogin();

		// My Account Page
		MyAccountPage Myap = new MyAccountPage(driver);

		boolean targetPage = Myap.isMyAccountPageExists();

		if (exp.equalsIgnoreCase("Valid"))

		{

			if (targetPage == true)

			{
				Myap.clickLogout();
				Assert.assertTrue(true);

			}

			else {

				Assert.assertTrue(false);
			}
		}

		if (exp.equalsIgnoreCase("Invalid"))

		{

			if (targetPage == true)

			{

				Myap.clickLogout();
				Assert.assertTrue(false);

			}

			else {

				Assert.assertTrue(true);
			}
		}

	}
}
