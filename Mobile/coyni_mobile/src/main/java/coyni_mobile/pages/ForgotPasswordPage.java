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

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(forgotHeading, "Forgot Password ", expHeading);
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