package coyni.apibusiness.pages;

import org.openqa.selenium.By;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;


public class ForgotEmailPage extends BrowserFunctions {

	private By lblHeading = By.cssSelector(".forgot-email__title");
	private By lblDescription = By.cssSelector(".forgot-email__sub-title");
	private By txtPhoneNumber = By.cssSelector("#Phone_Number");
	private By btnNext = By.xpath("//button[text()='Next']");
	private By lnkBackToLogin = By.xpath("//div[text()='Back to Login']");

	public void verifyPageHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "expHeading", expHeading);
	}

	public void verifyPageDescription(String expDescription) {
		new CommonFunctions().verifyLabelText(lblDescription, "expDescription", expDescription);
	}

	public void fillPhoneNumber(String phoneNumber) {
		enterText(txtPhoneNumber, phoneNumber, "phoneNumber");
	}

	public void clickNext() {
		click(btnNext, "Next");
	}

	public void lnkBackToLogin() {
		click(lnkBackToLogin, "BackToLogin");
	}

	public ForgotEmailNamePage forgotEmailNamePage() {
		return new ForgotEmailNamePage();
	}

	/**
	 * Order -minChar, alphabets, specialChar, spaces, maxiPlus
	 */
	public void validateNumber(By ele, String eleName, String textField) {
		String[] field = textField.split(",");
		new CommonFunctions().validateField(ele, eleName, field[0]);
		for (int i = 1; i < 4; i++) {
			new CommonFunctions().validateTextFeild(ele, eleName, field[i]);
		}
		new CommonFunctions().validateFieldMaxichar(ele, eleName, field[4]);
	}

	public void validatePhoneNumber(String phoneNumber) {
		validateNumber(txtPhoneNumber, "Phone Number", phoneNumber);
	}
}
