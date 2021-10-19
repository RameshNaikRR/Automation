package coyni.customer.popups;

import org.openqa.selenium.By;

import ilabs.WebFramework.BrowserFunctions;

public class VerifyNewPhoneNumberPopup extends BrowserFunctions {
	
private By lnkResendVerificationCode = By.cssSelector("");
	
	public void clickOnResendVerificationCode() {
		click(lnkResendVerificationCode, "Click ResendVerificationCode");
	}


}
