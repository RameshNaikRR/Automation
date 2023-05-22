package coyni.business.pages;

import java.awt.AWTException;

import org.openqa.selenium.By;

import coyni.business.components.AuthyComponent;
import coyni.business.components.ToastComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class LoginPage extends BrowserFunctions {

	private By lblHeading = By.xpath("");
	private By lblDescription = By.xpath("");
	private By txtEmail = By.cssSelector("");
	private By txtPassword = By.cssSelector("");
	private By eyeIcon = By.xpath("");
	private By lnkRetrieveEmail = By.xpath("");
	private By lnkForgotPassword = By.xpath("");
	private By btnNext = By.cssSelector("");

	CommonFunctions commonfunctions = new CommonFunctions();

	public void verifyPageHeading(String heading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Heading", heading);
	}

	public void verifyPageDescription(String description) {
		new CommonFunctions().verifyLabelText(lblDescription, "Description", description);
	}

	public void fillEmail(String email) {
		enterText(txtEmail, email, "Email");
	}

	public void fillPassword(String password) {
		enterText(txtPassword, password, "Password");
	}

	public void clickEyeIcon() {
		click(eyeIcon, "EyeIcon");
	}

	public void clickNext() {
		if (getElement(btnNext, "Enabled").isEnabled()) {
			click(btnNext, "Next");
			ExtentTestManager.setPassMessageInReport("Next button is Enabled");
		} else {
			ExtentTestManager.setPassMessageInReport("Next button is Disabled");
		}
	}

	public void clickForgotEmail() {
		click(lnkRetrieveEmail, "ForgotEmailLink");
	}

	public void clickForgotPassword() {
		click(lnkForgotPassword, "ForgotPasswordLink");
	}

	public void verifyEmail() {
		new CommonFunctions().elementView(txtEmail, "Email");
	}

	public void verifyPassword() {
		new CommonFunctions().elementView(txtPassword, "Password");
	}

	public void verifyForgotEmail() {
		new CommonFunctions().elementView(lnkRetrieveEmail, "ForgotEmail");
	}

	public void verifyForgotPassword() {
		new CommonFunctions().elementView(lnkForgotPassword, "ForgotPassword");
	}

	public void verifyPasswordMaskedView(String attribute, String password) {
		String attributeValue = getAttributeValue(txtPassword, attribute, password);
		if (attributeValue.contains("password")) {

			ExtentTestManager.setInfoMessageInReport(password + " masked with black circles");
		} else {
			ExtentTestManager.setInfoMessageInReport(password + " not masked with black circles");
		}
	}

	public void clickOutSide() throws AWTException {
		new CommonFunctions().clickTab();
	}

	public AuthyComponent authyComponent() {
		return new AuthyComponent();
	}

	public ToastComponent toastComponent() {
		return new ToastComponent();
	}

}
