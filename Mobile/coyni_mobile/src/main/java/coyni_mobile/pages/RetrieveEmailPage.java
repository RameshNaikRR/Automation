package coyni_mobile.pages;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class RetrieveEmailPage extends MobileFunctions {

	// added p
	private By lblCoyni = MobileBy.xpath("//*[contains(@resource-id,'loginBGIV')]");
	private By retrieveheading = MobileBy.xpath("//*[@text='Retrieve Email']");
	private By lblPhoneNumber = MobileBy.xpath("//*[contains(@resource-id,'hintTV')]");
	private By txtFirstName = MobileBy.xpath("//*[contains(@resource-id,'reFirstNameET')]");
	private By txtLastName = MobileBy.xpath("//*[contains(@resource-id,'reLastNameET')]");
	private By btnNext = MobileBy.xpath("//*[contains(@resource-id,'reCardViewNextBtn')]");
	private By tryAgain = MobileBy.xpath("//*[@text='Try Again']");
	private By closeIcon = MobileBy.xpath("//*[contains(@resource-id,'imgREClose')]");
	private By btnClose = MobileBy.xpath("//*[contains(@resource-id,'otpValidationCloseIV')]");
	private By headingPhoneNumber = MobileBy.xpath("//*[@text='Please Verify Your Phone Number']");
	private By registeredPhoneNumber = MobileBy.xpath("//*[contains(@resource-id,'subHeaderTV')]");
	private By txtPhoneNumber = MobileBy.xpath("//*[contains(@resource-id,'pnET')]");
	private By txtInputBoxes = MobileBy.xpath("//*[contains(@resource-id,'otpPV')]");
	private By lnkResend = MobileBy.xpath("//*[contains(@resource-id,'resendTV')]");

//		public void clickRetrieveEmail() {
//			click(lnkRetriveEmail, "Retrieve Email");
//		}

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(retrieveheading, "Retrieve Email Heading ", expHeading);

	}

	public void verifyPhoneNumber(String expPhoneNumber) {
		new CommonFunctions().elementView(lblPhoneNumber, expPhoneNumber);

	}

	public void verifyPhone(String expHeading) {
		new CommonFunctions().verifyLabelText(headingPhoneNumber, "Phone Heading", expHeading);
	}

	public void verifyRegisteredPhoneNum(String expHeading) {
		new CommonFunctions().verifyLabelText(registeredPhoneNumber, "Reg PhoneNum", expHeading);
	}

	public void fillFirstName(String firstName) {
		enterText(txtFirstName, firstName, "First Name ");

	}

	public void fillLastName(String lastName) {
		enterText(txtLastName, lastName, "Last Name ");

	}

	public void clickNext() {
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

	}

	// DOUBT
	public void fillInputBoxes(String code) {
		enterText(txtInputBoxes, code, "Input Box ");

	}

	public void clickResend() {
		click(lnkResend, "Resend ");

	}

}
