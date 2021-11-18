package coyni.customer.components;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class ForgotEmailComponent extends BrowserFunctions {

	private By forgotHeading = By.cssSelector(".forgot-email__title");
	private By lnkBackToLogin = By.cssSelector(".pl-1");
	private By txtPhoneNumber = By.id("Phone-Number");
	private By btnNext = By.xpath("//button[text()='Next']");
	private By txtFirstName = By.name("first_name");
	private By txtLastName = By.name("last_name");

	public void clickforgot() {
		if (getElement(forgotHeading, "click forgot").isDisplayed()) {
			click(forgotHeading, "Heading");
		}
	}

	public void verifyForgotHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(forgotHeading, "Forgot heading", expHeading);
	}

	public void clickBackToLogin() {
		click(lnkBackToLogin, "BackToLogin");
	}

	public void fillPhoneNumber(String PhoneNumber) {
		enterText(txtPhoneNumber, PhoneNumber, "PhoneNumber");
	}

//	public void validateRemainingAttempts(String expAttempts) {
//		Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
//		String text = getText(lblerrorMsg, "error message").replaceAll("[^0-9]", "");
//		if (expAttempts.equals(text)) {
//			ExtentTestManager.setPassMessageInReport("Number of remaining invalid password attemps are " + expAttempts);
//		} else {
//			ExtentTestManager.setFailMessageInReport("Expected of number of remaining password attempts  are "
//					+ expAttempts + " but actual are " + text);
//		}
//	}

	public void clickNext() {
		if (getElement(btnNext, "Enabled").isEnabled()) {
			click(btnNext, "Next");
		} else {
			ExtentTestManager.setPassMessageInReport("Next button is Disabled");
		}
	}

	public void fillFirstName(String firstName) {
		enterText(txtFirstName, firstName, "firstName");
	}

	public void fillLastName(String lastName) {
		enterText(txtLastName, lastName, "lastName");
	}

	public void verifyFirstName() {
		getTextBoxValue(txtFirstName, "verify first Name");
	}

	public void verifyLastName() {
		getTextBoxValue(txtLastName, "verify first Name");
	}

}
