package coyni.apibusiness.pages;

import org.openqa.selenium.By;

import coyni.apibusiness.components.PhoneEmailVerificationComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class ForgotEmailNamePage extends BrowserFunctions {

	private By lblHeading = By.xpath("//span[text()='Forgot Email?']");
	private By lblDescription = By.cssSelector(".forgot-email__sub-title");
	private By txtFirstName = By.cssSelector("#First-Name");
	private By txtLastName = By.cssSelector("#Last-Name");
	private By btnNext = By.xpath("//button[text()='Next']");
	private By lnkBackToLogin = By.xpath("//button[text()='Back to Login']");

	public void verifyPageHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "expHeading", expHeading);
	}

	public void verifyPageDescription(String expDescription) {
		new CommonFunctions().verifyLabelTextContains(lblDescription, "expDescription", expDescription);
	}

	public void fillFirstName(String firstName) {
		enterText(txtFirstName, firstName, "firstName");
	}

	public void clickOutside() {
		new CommonFunctions().clickOutSideElement();
	}

	public void fillLastName(String lastName) {
		enterText(txtLastName, lastName, "lastName");
	}
	public void clickNext() {
		if (getElement(btnNext, "Enabled").isEnabled()) {
			click(btnNext, "Next");
		} else {
			ExtentTestManager.setPassMessageInReport("Next button is Disabled");
		}
		new CommonFunctions().elementView(btnNext, "Next");
	}

	public void clickBackToLogin() {
		click(lnkBackToLogin, "BackToLogin");
	}

	public PhoneEmailVerificationComponent phoneEmailVerificationComponent() {
		return new PhoneEmailVerificationComponent();
	}

	/**
	 * Order -minChar, minCharPlus, maxCharMinus, maxChar, specialChar, Number,
	 * spaces maxiPlus
	 */
	public void validateNameField(By ele, String eleName, String textField) {
		String[] field = textField.split(",");
		for (int i = 0; i < 4; i++) {
			new CommonFunctions().validateField(ele, eleName, field[i]);
		}
		System.out.println(textField.length());
		for (int j = 4; j < 7; j++) {
			new CommonFunctions().validateTextFeild(ele, eleName, field[j]);
		}
		new CommonFunctions().validateFieldMaxichar(ele, eleName, field[7]);
	}

	public void validateFirstNameField(String firstName) {
		validateNameField(txtFirstName, "First Name", firstName);
	}

	public void validateLastNameField(String LastName) {
		validateNameField(txtLastName, "Last Name", LastName);
	}

}
