package coyni.business.components;

import org.openqa.selenium.By;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class EmailVerificationComponent extends BrowserFunctions {

	private By lblHeading = By.xpath("");
	private By lblDescription = By.xpath("");
	private By lnkResendCode = By.xpath("");
	private By lblMessage = By.cssSelector("");
	private By lblAccountCreated = By.cssSelector("");
	private By lnkBacktoLogin = By.xpath("");
	private By backArrow = By.xpath("");

	public void verifyEmailVerificationHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Heading is: ", expHeading);
	}

	public void verifyEmailVerificationDescription(String expDes) {
		new CommonFunctions().verifyLabelText(lblDescription, "Description is: ", expDes);
	}

	public void clickResendCode() {
		new CommonFunctions().verifyCursorAction(lnkResendCode, "Resend Code");
		click(lnkResendCode, "Resend Code");
	}

	public void verifyMessage(String expMessage) {
		waitForCondition(e -> e.findElement(lblMessage).getText().contains("Verification"),
				"verification message is displayed");
		new CommonFunctions().verifyLabelText(lblMessage, "Message", expMessage);
	}

	public void fillpin(String code) {
		new AuthyComponent().fillInput(code);
	}

	public void verifyAccountCreated(String expHeading) {
		new CommonFunctions().verifyLabelText(lblAccountCreated, "Account Created PopUp Heading", expHeading);
	}

	public void clickBacktoLogin() {
		new CommonFunctions().verifyCursorAction(lnkBacktoLogin, "Back to Login");
		click(lnkBacktoLogin, "Back to Login");
	}

	public void clickBackArrow() {
		new CommonFunctions().verifyCursorAction(backArrow, "Back Arrow");
		click(backArrow, "Back Arrow");
	}

}
