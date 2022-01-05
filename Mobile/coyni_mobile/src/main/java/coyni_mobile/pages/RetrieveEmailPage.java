package coyni_mobile.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.google.common.util.concurrent.Uninterruptibles;

import coyni_mobile.components.NavigationComponent;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class RetrieveEmailPage extends MobileFunctions {

	private By lblCoyni = MobileBy.xpath("//*[contains(@resource-id,'loginBGIV')]");
	private By retrieveheading = MobileBy.xpath("//*[@text='Retrieve Email']");
	// private By lblPhoneNumber =
	// MobileBy.xpath("//*[contains(@resource-id,'hintTV')]");
	private By txtFirstName = MobileBy.xpath("//*[contains(@resource-id,'reFirstNameET')]");
	private By txtLastName = MobileBy.xpath("//*[contains(@resource-id,'reLastNameET')]");
	private By btnNext = MobileBy.xpath("//*[contains(@resource-id,'reCardViewNextBtn')]");
	private By tryAgain = MobileBy.xpath("//*[@text='Try Again']");
	private By closeIcon = MobileBy.xpath("//*[contains(@resource-id,'imgREClose')]");
	private By btnClose = MobileBy.xpath("//*[contains(@resource-id,'otpValidationCloseIV')]");
	private By headingPhoneNumber = MobileBy.xpath("//*[contains(@resource-id,'headerTV')]");
	private By txtPhoneNumber = MobileBy.xpath("//*[contains(@resource-id,'pnET')]");
	private By txtInputBoxes = MobileBy.xpath("//*[contains(@resource-id,'otpPV')]");
	private By lblAccount = MobileBy.xpath("//*[@text='We’ve Found Your Account!']");
	private By CoyniAccount = MobileBy.xpath("//*[contains(@resource-id,'llCoyniAct')]");
	private By lnkResend = MobileBy.xpath("//*[contains(@resource-id,'resendTV')]");
	private By btnOk = MobileBy.xpath("//*[contains(@resource-id,'tvAction')]");
	private By otpMsg = MobileBy.xpath("//*[contains(@resource-id,'otpPV')]");
	private By errMessage = MobileBy.xpath("//*[contains(@resource-id,'tvMessage')]");

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(retrieveheading, "Retrieve Email Heading ", expHeading);

	}

	public void verifyErrorMessage() {
		new CommonFunctions().elementView(errMessage, "Error message");

	}

	public void verifyLabelAccountHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblAccount, "Account Heading", expHeading);
	}

	public void clickCoyniAccount() {
		click(CoyniAccount, "Coyni Account");
	}

	public void clickOk() {
		click(btnOk, "Ok");
	}

//		public void verifyPhoneNumber(String expPhoneNumber) {
//			new CommonFunctions().elementView(lblPhoneNumber, expPhoneNumber);
	//
//		}

	public void verifyPhone(String expHeading) {
		new CommonFunctions().verifyLabelText(headingPhoneNumber, "Phone Heading", expHeading);
	}

	public void fillFirstName(String firstName) {
		enterText(txtFirstName, firstName, "First Name ");
		click(txtPhoneNumber, "Phone Number");

	}

	public void fillLastName(String lastName) {
		scrollDownToElement(txtLastName, "Last Name");
		enterText(txtLastName, lastName, "Last Name ");

	}

	public void pasteOption(String code) {
		copyDataToClipboard(code);
		click(otpMsg, "Paste");

		Uninterruptibles.sleepUninterruptibly(10000, TimeUnit.MILLISECONDS);
	}

	public void clickNext() {
		scrollDownToElement(btnNext, "Next");
		if (getElement(btnNext, "Next").isEnabled()) {
			click(btnNext, "Next ");
		} else {
			ExtentTestManager.setPassMessageInReport("Next button is in disabled mode");
		}

	}

	public void ViewCoyni() {
		new CommonFunctions().elementView(lblCoyni, "Coyni");
	}

	public void verifyTryAgain(String expHeading) {
		new CommonFunctions().verifyLabelText(tryAgain, "Try Again", expHeading);

	}

	public void clickTryAgain() {
		click(tryAgain, "Try Again");
	}

	public void clickClose() {
		click(btnClose, "Close ");

	}

	public void clickCloseIcon() {
		click(closeIcon, "close Icon");
	}

	public void fillPhoneNumber(String phoneNumber) {
		enterText(txtPhoneNumber, phoneNumber, "Phone Number ");
		click(txtFirstName, "First Name");

	}

	// DOUBT
	MobileFunctions functions = new MobileFunctions();

	public void fillInputBoxes(String code) {
		List<WebElement> elementList = functions.getElementList(txtInputBoxes, "code");
		int elements = elementList.size();
		if (elements == 6) {
			for (int i = 0; i < elements; i++) {
				elementList.get(i).sendKeys(code.charAt(i) + " ");
			}
			ExtentTestManager.setPassMessageInReport("Verification Text Entered");
		}

	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}

	public void clickResend() {
		click(lnkResend, "Resend ");

	}

	public void validateFirstNameField(String minChar, String minPlusChar, String moreThanChar, String specialChar,
			String numbers) {
		new CommonFunctions().validateField(txtFirstName, "firstName", minChar);
		new CommonFunctions().clearText(txtFirstName, "firstName");
		new CommonFunctions().validateField(txtFirstName, "firstName", minPlusChar);
		new CommonFunctions().clearText(txtFirstName, "firstName");
		new CommonFunctions().validateFieldMaxichar(txtFirstName, "firstName", moreThanChar);
		new CommonFunctions().clearText(txtFirstName, "firstName");
		new CommonFunctions().validateFieldWithSpecialchar(txtFirstName, "firstName", specialChar);
		new CommonFunctions().clearText(txtFirstName, "firstName");
		new CommonFunctions().validateFieldWithNumber(txtFirstName, "firstName", numbers);

	}

	public void validateLastNameField(String minChar, String minPlusChar, String moreThanChar, String specialChar,
			String numbers) {
		new CommonFunctions().validateField(txtLastName, "lastName", minChar);
		new CommonFunctions().clearText(txtLastName, "lastName");
		new CommonFunctions().validateField(txtLastName, "lastName", minPlusChar);
		new CommonFunctions().clearText(txtLastName, "lastName");
		new CommonFunctions().validateFieldMaxichar(txtLastName, "lastName", moreThanChar);
		new CommonFunctions().clearText(txtLastName, "lastName");
		new CommonFunctions().validateFieldWithSpecialchar(txtLastName, "lastName", specialChar);
		new CommonFunctions().clearText(txtLastName, "LastName");
		new CommonFunctions().validateFieldWithNumber(txtLastName, "lastName", numbers);

	}
	//
	// public void validatePhoneNumberField(String minPhoneNumber) {// String
	// minPhoneNumber, String maxPhoneNumber, String
	// // specialCharacter,
	// // String alphabets
	// new CommonFunctions().validateFieldWithNumber(txtPhoneNumber, "phoneNumber",
	// minPhoneNumber);
	// new CommonFunctions().clearText(txtPhoneNumber, "phoneNumber");
	//// new CommonFunctions().validateFieldWithNumber(txtPhoneNumber,
	// "phoneNumber", maxPhoneNumber);
	//// new CommonFunctions().clearText(txtPhoneNumber, "phoneNumber");
	//// new CommonFunctions().validateFieldWithSpecialchar(txtPhoneNumber,
	// "phoneNumber", specialCharacter);
	//// new CommonFunctions().clearText(txtPhoneNumber, "phoneNumber");
	//// new CommonFunctions().validateFieldWithalphabet(txtPhoneNumber,
	// "phoneNumber", alphabets);
	//
	// }

}
