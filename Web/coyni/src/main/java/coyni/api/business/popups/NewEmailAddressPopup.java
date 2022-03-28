package coyni.api.business.popups;

import org.openqa.selenium.By;

import coyni.apibusiness.components.PhoneEmailVerificationComponent;
import coyni.customer.components.NavigationComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class NewEmailAddressPopup extends BrowserFunctions {

	private By lblNewEmailAddressHeading = By.xpath("//h1[text()='Verify New Email Address']");
	private By descNewEmailAddress = By.xpath("//span[contains(text(),'new email address')]");

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}

	public PhoneEmailVerificationComponent phoneEmailVerificationComponent() {
		return new PhoneEmailVerificationComponent();
	}

	public void verifyNewEmailAddressHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblNewEmailAddressHeading, " New Email Address  Heading is", expHeading);
	}

	public void verifyNewEmailAddressDescHeading(String expCurrentEmailAddDescHeading) {
		new CommonFunctions().verifyLabelText(descNewEmailAddress, " New Email Address Description  Heading is",
				expCurrentEmailAddDescHeading);
	}

}
