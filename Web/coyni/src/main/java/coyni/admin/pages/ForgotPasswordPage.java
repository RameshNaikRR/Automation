package coyni.admin.pages;

import org.openqa.selenium.By;

import coyni.admin.components.PhoneEmailVerificationComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class ForgotPasswordPage extends BrowserFunctions {

	private By lblHeading = By.xpath("//span[text()='Forgot Password?']");
	private By lblDescription = By.xpath("//span[@class=\"forgot-password__sub-title\"]");
	private By txtEmail = By.id("Email-id");
	private By btnNext = By.xpath("//button[text()='Next']");
	private By lnkBackToLogin = By.xpath("//button[text()='Back to Login']");

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

	public void clickBackToLogin() {
		click(lnkBackToLogin, "Back to Login");
	}

	public void clickOutSide() {
		new CommonFunctions().clickOutSideElement();
	}
	public void verifyEmail() {
		new CommonFunctions().elementView(txtEmail, "Email");
	}
	public PhoneEmailVerificationComponent phoneEmailVerificationComponent() {
		return new PhoneEmailVerificationComponent();
	}
	
}
