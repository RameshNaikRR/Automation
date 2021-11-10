package coyni_mobile.pages;

import org.openqa.selenium.By;

import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class CreateAnAccountPage extends MobileFunctions {

	private By lblHeading = MobileBy.xpath("");
	private By txtFirstName = MobileBy.xpath("");
	private By txtLastName = MobileBy.xpath("");
	private By txtEmail = MobileBy.xpath("");
	private By txtPhoneNumber = MobileBy.xpath("");
	private By txtPassword = MobileBy.xpath("");
	private By txtConfirmPassword = MobileBy.xpath("");
	private By iconviewPassword = MobileBy.xpath("");
	private By iconviewConfirmPassword = MobileBy.xpath("");
	private By lnkTermsAndService = MobileBy.xpath("");
	private By lnkPrivacyPolicy = MobileBy.xpath("");
	private By btnNext = MobileBy.xpath("");
	private By btnDone = MobileBy.xpath("");
	private By btnRefresh = MobileBy.xpath("");
	private By btnAlphabetSize = MobileBy.xpath("");

	public void verifyHeading(String expHeading) {

	}

	public void fillFirstName(String userName) {
		enterText(txtFirstName, userName, "First Name ");

	}

	public void fillLastName(String lastName) {
		enterText(txtLastName, lastName, "Last Name ");

	}

	public void fillEmail(String email) {
		enterText(txtEmail, email, "Email ");

	}

	public void fillPhoneNumber(String phoneNumber) {
		enterText(txtPhoneNumber, phoneNumber, "Phone Number ");

	}

	public void fillPassword(String password) {
		enterText(txtPassword, password, "Password ");

	}

	public void fillConfirmPassword(String confirmPassword) {
		enterText(txtConfirmPassword, confirmPassword, "Confirm Password ");

	}

	public void clickiconviewPassword() {
		click(iconviewPassword, "Click IconViewPassword ");

	}

	public void clickiconviewConfirmPassword() {
		click(iconviewConfirmPassword, "Click IconViewConfirmPassword ");

	}

	public void clickTermsAndService() {
		click(lnkTermsAndService, "TermsAndService ");

	}

	public void clickPrivacyPolicy() {
		click(lnkPrivacyPolicy, "Privacy Policy ");

	}

	public void clickNext() {
		click(btnNext, "Next ");

	}

	public void clickDone() {
		click(btnDone, "Done ");

	}

	public void clickRefresh() {
		click(btnRefresh, "Refresh ");

	}

	public void clickAlphabetSize() {
		click(btnAlphabetSize, "Alphabet Size ");

	}

	public VerifyPhoneNumberAndEmailPage verifyPhoneNumberAndEmailPage() {

		return new VerifyPhoneNumberAndEmailPage();

	}

}
