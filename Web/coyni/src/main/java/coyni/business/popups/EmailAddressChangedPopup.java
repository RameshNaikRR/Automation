package coyni.business.popups;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class EmailAddressChangedPopup extends BrowserFunctions {

	private By lblEmailAddressChangedHeading = By.xpath("");
	private By lnkRedirectingtoLogin = By.xpath("");

	public void verifyEmailAddressChangedHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblEmailAddressChangedHeading, "Heading is: ", expHeading);
	}

	public void clickRedirectingtoLogin() {
		click(lnkRedirectingtoLogin, "Redirecting you to Login");
	}

}
