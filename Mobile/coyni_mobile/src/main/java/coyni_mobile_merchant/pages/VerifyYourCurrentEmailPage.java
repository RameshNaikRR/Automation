package coyni_mobile_merchant.pages;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class VerifyYourCurrentEmailPage extends MobileFunctions{
	private By lblCurrentEmailHeading = MobileBy.xpath("//*[contains(@text,'Edit Email')]");
	private By btnBack = MobileBy.xpath("//*[contains(@resource-id,'otpValidationCloseIV')]");
	private By lblDescription = MobileBy.xpath("//*[contains(@resource-id,'subHeaderTV')]");
	
	
	public void verifyDescription(String expDescription) {
		new CommonFunctions().verifyLabelText(lblDescription, "Current Email Description", expDescription);
	}
	public void verifyEmailHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblCurrentEmailHeading, " Current Email Heading ", expHeading);
	}
	public void clickBack() {
		click(btnBack, "Back");
	}
}
