package coyni_mobile.components;

import org.openqa.selenium.By;

import coyni_mobile.pages.EditAddressPage;
import coyni_mobile.pages.EditEmailPage;
import coyni_mobile.pages.EditPhoneNumberPage;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class EnterYourPINComponent extends MobileFunctions {
	private By txtPin =MobileBy.xpath("");
	private By lnkForgotPin =MobileBy.xpath("");
	
	public void fillPin(String pin) {
		enterText(txtPin, pin," Fill Pin " );
	}
	public void clickForgotPin() {
		click(lnkForgotPin, "click Forgot Pin");
	}


public EditEmailPage editEmailPage() {
	return new EditEmailPage();
}
public EditPhoneNumberPage editPhoneNumberPage() {
	return new EditPhoneNumberPage();
}

public EditAddressPage editAddressPage() {
	return new EditAddressPage();
}
}
