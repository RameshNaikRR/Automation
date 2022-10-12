package coyni.customer.popups;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class FindYourAccountNumbersPopup extends BrowserFunctions {

	private By heading = By.xpath("//h2[text()='Where to Find My Account Information?']");
	private By btnBack = By.xpath("//button[text()='Back']");
	
	public void verifyHeading() {
		new CommonFunctions().elementView(heading, "Heading");
	}
	
	public void clickBack() {
		click(btnBack, "Back");
	}
}
