package coyni_mobile.pages;

import org.openqa.selenium.By;

import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class RetrieveEmailPage extends MobileFunctions {

	private By heading = MobileBy.xpath("");
	private By lblPhoneNumber = MobileBy.xpath("");
	private By txtFirstName = MobileBy.xpath("");
	private By txtLastName = MobileBy.xpath("");
	private By btnNext = MobileBy.xpath("");
	private By btnClose = MobileBy.xpath("");
	private By txtPhoneNumber = MobileBy.xpath("");
	private By txtInputBoxes = MobileBy.xpath("");
	private By lnkResend = MobileBy.xpath("");

	public void verifyHeading(String expHeading) {

	}

	public void verifyPhoneNumber(String expPhoneNumber) {

	}

	public void fillFirstName(String firstName) {
		enterText(txtFirstName, firstName, "First Name ");

	}

	public void fillLastName(String lastName) {
		enterText(txtLastName, lastName, "Last Name ");

	}

	public void clickNext() {
		click(btnNext, "Next ");

	}

	public void clickClose() {
		click(btnClose, "Close ");

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
