package coyni_mobile.pages;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class CurrentEmailPage extends MobileFunctions {
	private By lblHeading = MobileBy.xpath("//*[contains(@resource-id,'intentName')]");
	private By lblCurrentEmailHeading = MobileBy.xpath("//*[contains(@resource-id,'titleTV')]");
	private By lblEmail = MobileBy.xpath("//*[contains(@resource-id,'contentTV')]");
	private By btnChange = MobileBy.xpath("//*[contains(@resource-id,'tvEnableFace')]");

	public void verifyHeading(String emailHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "emailHeading", emailHeading);
	}

	public void verifyCurrentEmailHeading(String currentEmailHeading) {
		new CommonFunctions().verifyLabelText(lblCurrentEmailHeading, "currentEmailHeading", currentEmailHeading);
	}

	public void verifyEmail(String email) {
		new CommonFunctions().verifyLabelText(lblEmail, "email", email);
	}

	public void clickChange() {
		click(btnChange, "Change");
	}
}
