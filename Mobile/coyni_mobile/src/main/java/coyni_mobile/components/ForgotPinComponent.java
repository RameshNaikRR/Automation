package coyni_mobile.components;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class ForgotPinComponent extends MobileFunctions {

	private By txtEmail = MobileBy
			.xpath("//*[contains(@resource-id,'etEmail')]|//*[contains(@name,'Before')]/following-sibling::*[1]");
	private By txEmailFieldInputBoxes = MobileBy.xpath("//*[contains(@resource-id,'otpPV')]");
	private By txtChooseYourPinInputBoxes = MobileBy.xpath("");
	private By btnNext = MobileBy.xpath("//*[contains(@resource-id,'cvNext')]|(//*[@name='Next'])[1]");
	private By lblEnterYourPinHeading = MobileBy.xpath("//*[contains(@resource-id,'tvHead')] ");
	private By lblForgotPinHeading = MobileBy
			.xpath("//*[contains(@resource-id,'tvHead')]|//*[@name='Forgot Your PIN?']");
	private By lblForgotPinDescrp = MobileBy
			.xpath("//*[contains(@resource-id,'tvMessage')]|//*[contains(@name,'Before we can')]");
	private By lblEmailFiled = MobileBy.xpath("//*[contains(@resource-id,'etlEmail')]|//*[@name='Email']");
	private By lblEmailVericationHeading = MobileBy.xpath("//*[contains(@resource-id,'headerTV')]");
	private By lblEmailVerificationDescrp = MobileBy.xpath("//*[contains(@resource-id,'subHeaderTV')]");
	private By lblVerifyDidntGetCode = MobileBy.xpath("");

	private By lblNumberKeyPad = MobileBy.xpath("");
	private By crossIcon = MobileBy.xpath("//*[contains(@resource-id,'llClose')]");
	private By headingUserDetails = MobileBy.xpath("//*[contains(@resource-id,'tvUserName')]");
	private By resendIcon = MobileBy.xpath("");
	private By btnBack = MobileBy.xpath("");
	private By lblForgotYourPin = MobileBy
			.xpath("//*[contains(@resource-id,'tvHead')]|//*[contains(@name,'Forgot Your')]");
	private By btnClose= MobileBy.xpath("//*[contains(@resource-id,'llClose')]");

	public void verifyForgotYourPinView() {
		new CommonFunctions().elementView(lblForgotYourPin, "ForgotYourPin");
	}

	public void verifyEmail(String email) {
		new CommonFunctions().verifyLabelText(txtEmail, "email is displayed as", email);
	}
	// public VerifyNewEmailPage verifyNewEmailPage() {
	// return new VerifyNewEmailPage();
	// }

	public void clickNext() {
		click(btnNext, "Next");
	}

	private By btnForgotPin = MobileBy.xpath("//*[contains(@resource-id,'tvForgot')]");

	public void clickForgotPin() {
		click(btnForgotPin, "Forgot Pin");
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}

	public VerifyEmailComponent verifyEmailComponent() {
		return new VerifyEmailComponent();
	}

	public void headingEnterYourPin(String expEnterYourPinHeading) {
		new CommonFunctions().verifyLabelText(lblEnterYourPinHeading, "Forgot Pin Heading is", expEnterYourPinHeading);
	}

	public void headingForgotPin(String expForgotPinHeading) {
		new CommonFunctions().verifyLabelText(lblForgotPinHeading, "Forgot Pin Heading is", expForgotPinHeading);
	}

	public void forgotPinDescription(String expForgotPinDescrp) {
		new CommonFunctions().verifyLabelText(lblForgotPinDescrp, "Forgot pin Description", expForgotPinDescrp);
	}

	public void emailFieldTiltle() {
		new CommonFunctions().elementView(lblEmailFiled, "Email Field Tilte");
	}

	public void crossIconView() {
		new CommonFunctions().elementView(crossIcon, "Cross Icon");

	}

	public void verifyHeadingClickOnCrossIcon() {
		click(crossIcon, "Click Cross Icon");

		if (!isElementPresent(headingUserDetails)) {
			ExtentTestManager.setPassMessageInReport("User Details Screen not displayed");
		} else {
			ExtentTestManager.setFailMessageInReport("user Details Screen displayed");

		}
	}

	public void verifyEmailVerificationHeading(String expEmailVerificationHeading) {
		new CommonFunctions().verifyLabelText(lblEmailVericationHeading, "Email Verification Heading",
				expEmailVerificationHeading);
	}

	public void verifyEmailVerificationDescription(String expEmailVerificationDescrp) {
		new CommonFunctions().verifyLabelText(lblEmailVerificationDescrp, "Email Verification Descrption",
				expEmailVerificationDescrp);
	}

	public void verifyForgotPinInputBoxes() {
		new CommonFunctions().elementView(txEmailFieldInputBoxes, "Input Boxex viewing");
	}

	public void verifyChooseYourPinUnputBoxes() {
		new CommonFunctions().elementView(txtChooseYourPinInputBoxes, "Choose Your pin Input Boxes");

	}

	public void verifyPopulatedNumberKeyPad() {
		new CommonFunctions().elementView(lblNumberKeyPad, "Number KeyPad");
	}

	public void clickBack() {
		click(btnBack, "Clicked Back");
	}
	public void verifyForgotPinClose() {
		click(btnClose,"close forgot pin");
	}
}