package coyni_mobile.components;

import org.openqa.selenium.By;

import coyni_mobile.pages.VerifyNewEmailPage;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class ForgotPinComponent extends MobileFunctions{
	
	private By txtEmail = MobileBy.xpath("");
	private By btnNext = MobileBy.xpath("");
	private By lblForgotYourPin = MobileBy.xpath(" ");
 
	public void clickNext() {
		click(btnNext, "Next");
	}
	public void verifyForgotYourPinView() {
		new CommonFunctions().elementView(lblForgotYourPin, "ForgotYourPin");
	}
	public void fillEmail(String email) {
		enterText(txtEmail, "email", email);
	}
//	public VerifyNewEmailPage verifyNewEmailPage() {
//		return new VerifyNewEmailPage();
	//}
	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}
	public  VerifyEmailComponent verifyEmailComponent() {
		return new VerifyEmailComponent();
	}

}
