package coyni.customer.pages;

import org.openqa.selenium.By;

import coyni.customer.components.MailingAddressComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class VerifyYourIdentityPage extends BrowserFunctions{
	private By lblHeading =By.cssSelector("h1[class*='GetStartedIdentity_Title']");

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Heading", expHeading);
	}
	
	
	
	
	public MailingAddressComponent mailingAddressComponent() {
		return new MailingAddressComponent();
	}
}
