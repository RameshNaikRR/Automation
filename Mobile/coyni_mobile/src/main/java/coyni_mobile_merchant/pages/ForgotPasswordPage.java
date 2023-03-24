package coyni_mobile_merchant.pages;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import coyni_mobile_merchant.components.FieldValidationsComponent;
import coyni_mobile_merchant.components.PhoneAndEmailVerificationComponent;
import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class ForgotPasswordPage extends MobileFunctions {
	private By lblHeading = MobileBy.xpath("//*[contains(@resource-id,'/tvHead')]");
	private By lblDescription = MobileBy.xpath("//*[contains(@resource-id,'tvMessage')]");
	private By txtEmail = MobileBy.xpath("//*[contains(@resource-id,'etEmail')]");
	private By btnNext = MobileBy.xpath("//*[contains(@resource-id,'cvNext')]");
	private By btnCloseIcon = MobileBy.xpath("//*[contains(@resource-id,'imgFPClose')]");

	public void verifyPageHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Forgot Password Heading ", expHeading);
	}

	public void verifyPageDescription(String expDescription) {
		new CommonFunctions().verifyLabelText(lblDescription, "Forgot Password Description ", expDescription);
	}
//forgot password
	public void fillEmail(String email) throws InterruptedException {
		new CommonFunctions().verifyAutoFocusElement(txtEmail, "Email");
		enterText(txtEmail, email, "Email");
		DriverFactory.getDriver().hideKeyboard();
	}

	public void verifyKeBaordTypeOfEmail(String email,String keyBoardType) throws InterruptedException {
		click(txtEmail, "Email");
		new CommonFunctions().verifyKeyBoardType(txtEmail, email, keyBoardType, "Email");
		DriverFactory.getDriver().hideKeyboard();
	}
	
	public void clickNext() {
		new CommonFunctions().clickFocusableElement(btnNext, " Next ");
	}

	public void verifyForgotPasswordPageView() {
		new CommonFunctions().elementView(lblHeading, "Email Verification Page");
	}

	public void clickCloseIcon() {
		click(btnCloseIcon, " Close Icon");
	}
	
	public PhoneAndEmailVerificationComponent phoneAndEmailVerificationComponent() {
		return new PhoneAndEmailVerificationComponent();
	}
	
	public FieldValidationsComponent fieldValidationsComponent() {
		return new FieldValidationsComponent();
	}
}
