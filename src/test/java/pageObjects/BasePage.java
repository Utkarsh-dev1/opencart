package pageObjects;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

	WebDriver driver;

	public BasePage(WebDriver drvier) {

		this.driver = driver;

		PageFactory.initElements(drvier, this);

	}

}
