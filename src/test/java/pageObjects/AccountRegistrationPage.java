package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage(WebDriver driver) {

		super(driver);

	}

	// Elements

	@FindBy(id = "input-firstname")
	WebElement txtFirstname;

	@FindBy(id = "input-lastname")
	WebElement txtLastname;

	@FindBy(id = "input-email")
	WebElement txtEmail;

	@FindBy(id = "input-telephone")
	WebElement txttelephone;

	@FindBy(id = "input-password")
	WebElement txtPassword;

	@FindBy(id = "input-confirm")
	WebElement txtConfirmPassword;

	@FindBy(xpath = "//input[@value='Continue']")
	WebElement btnContinue;

	@FindBy(name = "agree")
	WebElement chkdPolicy;

	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;

	// Action Methods

	public void setFirstName(String fname) {

		txtFirstname.sendKeys(fname);

	}

	public void setLastName(String lname) {

		txtLastname.sendKeys(lname);

	}

	public void setEmail(String email) {

		txtEmail.sendKeys(email);

	}

	public void setTelephone(String phone) {

		txttelephone.sendKeys(phone);

	}

	public void setPassword(String pwd) {

		txtPassword.sendKeys(pwd);

	}

	public void ConfirmPassword(String Confirmpwd) {

		txtConfirmPassword.sendKeys(Confirmpwd);

	}

	public void setPrivacyPloicy() {

		chkdPolicy.click();

	}

	public void clickContinue() {

		btnContinue.click();

	}

	public String getConfirmationMsg() {

		try {

			return (msgConfirmation.getText());
		}

		catch (Exception e) {

			return (e.getMessage());
		}
	}

}
