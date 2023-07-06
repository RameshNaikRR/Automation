
package coyni.business.pages;

import java.awt.AWTException;

import org.openqa.selenium.By;

import coyni.business.components.EmailVerificationComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class ForgotPasswordPage extends BrowserFunctions {
	private By lblHeading = By.xpath("");
	private By lblDescription = By.xpath("");
	private By txtEmail = By.id("");
	private By btnNext = By.xpath("");
	private By lnkBackToLogin = By.xpath("");
	private By errMsg = By.xpath("");

	public void verifyPageHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Forgot Password Heading ", expHeading);
	}

	public void verifyErrMessage(String message) {
		new CommonFunctions().verifyLabelText(errMsg, "Error Message ", message);
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

	public void clickOutSide() throws AWTException {
		new CommonFunctions().clickTab();
	}

	public void verifyEmail() {
		new CommonFunctions().elementView(txtEmail, "Email");
	}

	public EmailVerificationComponent emailVerificationComponent() {
		return new EmailVerificationComponent();
	}

}
