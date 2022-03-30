package coyni.api.business.popups;

import org.openqa.selenium.By;

import coyni.apibusiness.components.AuthyComponent;
import coyni.customer.components.NavigationComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class EmailAddressAuthenticationPopup extends BrowserFunctions {

	private By lblHeading1 = By.xpath("//h1[text()='Edit Email Address']");
	private By lblHeading2 = By.xpath("//h1[text() = 'Authentication']");
	private By descEmailAddressAuth = By
			.xpath("//span[contains(text(),'Please enter the code generated by your authentication app')]");

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}

	public AuthyComponent authyComponent() {
		return new AuthyComponent();
	}

	public void verifyEmailAddressAuthHeading1(String expEmailAddressHeading) {
		new CommonFunctions().verifyLabelText(lblHeading1, "Email Address Authentication Heading is",
				expEmailAddressHeading);
	}

	public void verifyEmailAddressAuthHeading2(String expEmailAddressHeading) {
		new CommonFunctions().verifyLabelText(lblHeading2, "Email Address Authentication Heading is",
				expEmailAddressHeading);
	}

	public void verifyEmailAddressDescHeading(String expEmailAddressDescHeading) {
		new CommonFunctions().verifyLabelText(descEmailAddressAuth,
				"Email Address Description  Authentication Heading is", expEmailAddressDescHeading);
	}

}
