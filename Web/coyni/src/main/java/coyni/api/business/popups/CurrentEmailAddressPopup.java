package coyni.api.business.popups;

import org.openqa.selenium.By;
import coyni.apibusiness.components.AuthyComponent;
import coyni.apibusiness.components.PhoneEmailVerificationComponent;
import coyni.customer.components.NavigationComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class CurrentEmailAddressPopup extends BrowserFunctions {

	private By lblCurrentEmailAddressHeading = By.xpath("//h1[text()='Verify Current Email Address']");
	private By descCurrentEmailAddress = By.xpath("//span[contains(text(),'current email address')]");

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}

	public PhoneEmailVerificationComponent phoneEmailVerificationComponent() {
		return new PhoneEmailVerificationComponent();
	}

	public void verifyCurrentEmailAddressHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblCurrentEmailAddressHeading, " Current Email Address  Heading is",
				expHeading);
	}

	public void verifyCurrentEmailAddressDescHeading(String expCurrentEmailAddDescHeading) {
		new CommonFunctions().verifyLabelText(descCurrentEmailAddress, " Current Email Address Description  Heading is",
				expCurrentEmailAddDescHeading);
	}

	public AuthyComponent authyComponent() {
		return new AuthyComponent();
	}

	public NewEmailAddressPopup newEmailAddressPopup() {
		return new NewEmailAddressPopup();
	}

}
