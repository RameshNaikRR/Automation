package coyni_mobile.pages;

import org.openqa.selenium.By;

import coyni_mobile.components.NavigationComponent;

import coyni_mobile.components.VerifyEmailComponent;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class ForgotPasswordPage extends MobileFunctions {

	private By forgotHeading = MobileBy.xpath("//*[contains(@resource-id,'tvHead')]");
	private By txtEmail = MobileBy.xpath("//*[contains(@resource-id,'etEmail')]");
	private By btnClose = MobileBy.xpath("//*[contains(@resource-id,'llClose')]");
	private By btnNext = MobileBy.xpath("//*[contains(@resource-id,'cvNext')]");
	private By contentForgot = MobileBy.xpath("//*[contains(@resource-id,'tvMessage')]");

	private By popErrorMessage = MobileBy.xpath("//*[contains(@resource-id,'textTV')]");  //
	private By popHeading = MobileBy.xpath("//*[@text='Coyni']");
	
	public void verifyPopEHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(popHeading, "PopUp Heading ", expHeading);
	}
	
	
	public void verifyPopErrMessa(String expHeading) {
		new CommonFunctions().verifyLabelText(popErrorMessage, "User data not found ", expHeading);
	}

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(forgotHeading, "Forgot Password ", expHeading);
	}

	public void verifyContentHeading(String expContent) {
		new CommonFunctions().verifyLabelText(contentForgot, "Forgot Content ", expContent);
	}

	public void fillEmail(String email) {
		enterText(txtEmail, email, "Email");
	}

	public void clickClose() {
		click(btnClose, "Close");
	}

	public void clickNext() {
		click(btnNext, "Next");
	}

	public VerifyEmailComponent verifyEmailComponent() {
		return new VerifyEmailComponent();
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}
}