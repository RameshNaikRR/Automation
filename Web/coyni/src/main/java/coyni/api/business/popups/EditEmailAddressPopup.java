package coyni.api.business.popups;

import org.openqa.selenium.By;

import coyni.apibusiness.components.PhoneEmailVerificationComponent;
import coyni.customer.components.NavigationComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class EditEmailAddressPopup extends BrowserFunctions {

	private By lblEmailAddressHeading = By.xpath("//h1[text()='Edit Email Address']");
	private By descEmailAddress = By.xpath("//span[contains(text(),'Please enter a new email address')]");
	private By txtNewEmailAddress = By.xpath("//input[@id='Email']");
	private By btnEmailSendCode = By.cssSelector(".w-60");

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}

	public PhoneEmailVerificationComponent phoneEmailVerificationComponent() {
		return new PhoneEmailVerificationComponent();
	}

	public void verifyEditEmailAddressHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblEmailAddressHeading, "Email Address  Heading is", expHeading);
	}

	public void verifyEmailAddressDescHeading(String expEmailAddressDescHeading) {
		new CommonFunctions().verifyLabelText(descEmailAddress, "Email Address Description  Heading is",
				expEmailAddressDescHeading);
	}

	public void fillNewEmailText(String expEmail) {
		enterText(txtNewEmailAddress, expEmail, "New Email Address");
	}

	public void clickEmailSendCode() {
		click(btnEmailSendCode, "Send Code");
	}
}
