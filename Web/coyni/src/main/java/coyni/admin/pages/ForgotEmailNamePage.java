package coyni.admin.pages;

import org.openqa.selenium.By;

import coyni.admin.components.PhoneEmailVerificationComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class ForgotEmailNamePage extends BrowserFunctions {
	private By lblHeading = By.cssSelector(".forgot-email__title");
	private By lblDescription = By.cssSelector(".forgot-email__sub-title");
	private By txtFirstName = By.cssSelector("#First-Name");
	private By txtLastName = By.cssSelector("#Last-Name");
	private By btnNext = By.xpath("//button[text()='Next']");
	private By lnkBackToLogin = By.xpath("//div[text()='Back to Login']");

	public void verifyPageHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "expHeading", expHeading);
	}

	public void verifyPageDescription(String expDescription) {
		new CommonFunctions().verifyLabelText(lblDescription, "expDescription", expDescription);
	}

	public void fillFirstName(String firstName) {
		enterText(txtFirstName, firstName, "firstName");
	}

	public void fillLastName(String lastName) {
		enterText(txtLastName, lastName, "lastName");
	}

	public void clickNext() {
		click(btnNext, "Next");
	}

	public void lnkBackToLogin() {
		click(lnkBackToLogin, "BackToLogin");
	}

	public PhoneEmailVerificationComponent phoneVerificationComponent() {
		return new PhoneEmailVerificationComponent();
	}

}
