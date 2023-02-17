package coyni.customer.popups;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class AddressVerifiedPopup extends BrowserFunctions {

	private By lblAddressVerified = By.xpath("//h1[contains(text(),'Address Verified')]");
	private By txtAddressSuccessful = By.xpath("//p[contains(text(),'Your address has')]");
	private By btnDone = By.xpath("//button[contains(text(),'Done')]");

	public void verifyHeading() {
		String text = getText(lblAddressVerified, "Address Verified");
		System.out.println("Verified Heading is " + text);
	}

	public void verifySuccessfulHeading() {
		String text = getText(txtAddressSuccessful, "Address Verified Successful");
		System.out.println("Verified Successful is" + text);
	}

	public void clickDone() {
		click(btnDone, "Done");
	}
}
