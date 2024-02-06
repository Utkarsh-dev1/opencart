package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {
	
	public MyAccountPage(WebDriver driver) {
		
		super(driver);
	}
	
	// Elements
	
	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement msgHeading;       // My Account Page heading
	
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement lnkLogout;
	
  
	// Action Methods
	
	
	// My Account Page heading displayed status
	public boolean isMyAccountPageExists() {
		
		
		try {
			
			return (msgHeading.isDisplayed());
		}
		
		catch(Exception e) {
			
			return(false);
		}
	}
	
	public void clickLogout() {
		
		lnkLogout.click();
	}
	
	
	
}
