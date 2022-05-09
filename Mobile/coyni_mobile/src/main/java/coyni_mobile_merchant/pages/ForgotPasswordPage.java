package coyni_mobile_merchant.pages;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import coyni_mobile_merchant.components.PhoneAndEmailVerificationComponent;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class ForgotPasswordPage extends MobileFunctions {
	private By lblHeading = MobileBy.xpath("//*[contains(@resource-id,'/tvHead')]");
	private By lblDescription = MobileBy.xpath("//*[contains(@resource-id,'tvMessage')]");
	private By txtEmail = MobileBy.xpath("//*[contains(@resource-id,'etEmail')]");
	private By btnNext = MobileBy.xpath("//*[contains(@resource-id,'cvNext')]");
	private By btnCloseIcon = MobileBy.xpath("//*[contains(@resource-id,'imgFPClose')]");

	public void verifyPageHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Forgot Password Heading ", expHeading);
	}

	public void verifyPageDescription(String expDescription) {
		new CommonFunctions().verifyLabelText(lblDescription, "Forgot Password Description ", expDescription);
	}

	public void fillEmail(String email) {
		enterText(txtEmail, email, "Email");
	}

	public void clickNext() {
		if (getElement(btnNext, "Next").isEnabled()) {
			click(btnNext, " Next ");
		} else {
			ExtentTestManager.setInfoMessageInReport(" Next Button is Disabled");
		}
	}

	public void verifyForgotPasswordPageView() {
		new CommonFunctions().elementView(lblHeading, "Email Verification Page");
	}

	public PhoneAndEmailVerificationComponent phoneEmailVerificationComponent() {
		return new PhoneAndEmailVerificationComponent();
	}

	public void clickCloseIcon() {
		click(btnCloseIcon, " Close Icon");
	}

	public void validateEmailField(String minChar, String minCharPlus, String maxLessChar, String maxChar,
			String moreThanMax) {

		new CommonFunctions().validateFieldMaxichar(txtEmail, "Email", moreThanMax);
		new CommonFunctions().clearText(txtEmail, "Email");
		new CommonFunctions().validateField(txtEmail, "Email", minChar);
		new CommonFunctions().clearText(txtEmail, "Email");
		new CommonFunctions().validateField(txtEmail, "Email", minCharPlus);
		new CommonFunctions().clearText(txtEmail, "Email");
		new CommonFunctions().validateField(txtEmail, "Email", maxLessChar);
		new CommonFunctions().clearText(txtEmail, "Email");
		new CommonFunctions().validateField(txtEmail, "Email", maxChar);

	}
}
