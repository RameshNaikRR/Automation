package coyni_mobile_merchant.components;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class ForgotPinComponent extends MobileFunctions {
	
	private By lblForgotPinHeading = MobileBy.xpath("//*[@text='Forgot Your PIN?']");
	private By lbltxtForgotPindesc = MobileBy.xpath("//*[contains(@resource-id,'tvMessage')]");
	private By txtEmail = MobileBy.xpath("//*[contains(@resource-id,'etEmail')]");
	private By btnNext = MobileBy.xpath("//*[contains(@resource-id,'cvNext')]");
	
	public void verifyForgotYourPinView() {
		new CommonFunctions().elementView(lblForgotPinHeading, "Forgot Your Pin");
	}
	
	public void verifyForgotPinDescView() {
		new CommonFunctions().elementView(lbltxtForgotPindesc, "Forgot pin Description");
	}
	public void verifyEmail(String email) {
		new CommonFunctions().verifyLabelText(txtEmail, "email is displayed as", email);
	}
	public void clickNext() {
		click(btnNext, "Next");
	}
  
	public PhoneAndEmailVerificationComponent phoneAndEmailVerificationComponent() {
		return new PhoneAndEmailVerificationComponent();
	}
	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}
	public EnterYourPINComponent enterYourPINComponent() {
		return new EnterYourPINComponent();
	}
	
	public void VerifyHeadingForgotPin(String expForgotPinHeading) {
		new CommonFunctions().verifyLabelText(lblForgotPinHeading, "Forgot Pin Heading is", expForgotPinHeading);
	}

}
