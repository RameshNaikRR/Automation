package coyni.customer.components;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class EmailVerificationComponent extends BrowserFunctions {
	private By lblEmailHeading = By.xpath("//div[text()='Email Verification']");
	private By lblEmail = By.cssSelector(".text-base.font-bold.text-cgy5");
	private By lnkResendVerificationCode = By.xpath("//div[text()='Resend Verification Code']");
	private By lnkGoBack = By.xpath("//div[text()='Go Back']");
	private By lblAccountCreated = By.cssSelector(".account-success__title");
	
	public void verifyEmailHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblEmailHeading, "Email Verification PopUp Heading", expHeading);
	}

	public void verifyEmail(String expEmail) {
		new CommonFunctions().verifyLabelText(lblEmail, "exp Email", expEmail);
	}

	public void clickResendVerificationCode() {
		click(lnkResendVerificationCode, "Resend Verification Code");
	}

	public void clickGoBack() {
		click(lnkGoBack, "Go Back");
	}

	public void fillpin(String code) {
		new AuthyComponent().fillInput(code);
	}
	public void verifyAccountCreated(String expHeading) {
    	new CommonFunctions().verifyLabelText(lblAccountCreated, "Account Created PopUp Heading", expHeading);
    }

}
