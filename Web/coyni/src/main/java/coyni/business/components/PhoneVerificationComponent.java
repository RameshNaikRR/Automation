package coyni.business.components;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import coyni.business.pages.ChooseAccountPage;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class PhoneVerificationComponent extends BrowserFunctions {

	private By lblPhoneHeading = By.xpath("");
	private By lblPhoneDescription = By.xpath("");
	private By lnkResendCode = By.xpath("");
	private By inputBox = By.cssSelector("");
	private By lblMessage = By.cssSelector("");
	private By lnkBacktoLogin = By.xpath("");
	private By backArrow = By.xpath("");

	public void verifyPhoneVerificationHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblPhoneHeading, "Heading is: ", expHeading);
	}

	public void verifyPhoneVerificationDescription(String expDescription) {
		new CommonFunctions().verifyLabelText(lblPhoneDescription, "Heading is: ", expDescription);
	}

	public void clickResendCode() {
		new CommonFunctions().verifyCursorAction(lnkResendCode, "Resend Code");
		click(lnkResendCode, "Resend Code");
	}

	public void fillpin(String code) {
		new AuthyComponent().fillInput(code);
	}

	public void verifyMessage(String expMessage) {
		waitForCondition(e -> e.findElement(lblMessage).getText().contains("Verification"),
				"verification message is displayed");
		new CommonFunctions().verifyLabelText(lblMessage, "Message", expMessage);
	}

	public void clickBacktoLogin() {
		new CommonFunctions().verifyCursorAction(lnkBacktoLogin, "Back to Login");
	}

	public void clickBackArrow() {
		new CommonFunctions().verifyCursorAction(backArrow, "Back Arrow");
		click(backArrow, "Back Arrow");
	}

	public WeFoundYourAccountComponent weFoundYourAccountComponent() {
		return new WeFoundYourAccountComponent();
	}

	public EmailVerificationComponent emailVerificationComponent() {
		return new EmailVerificationComponent();
	}

	public AuthyComponent authyComponent() {
		return new AuthyComponent();
	}

	public ChooseAccountPage chooseAccountPage() {
		return new ChooseAccountPage();
	}

}
