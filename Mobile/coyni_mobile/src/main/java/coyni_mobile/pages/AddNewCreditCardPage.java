package coyni_mobile.pages;

import org.openqa.selenium.By;

import ilabs.MobileFramework.MobileFunctions;

public class AddNewCreditCardPage extends MobileFunctions{
	
	public AddNewDebitCardPage addNewDebitCardPage() {
		return new AddNewDebitCardPage();
	}
	public PreAuthorizationPage preAuthorizationPage() {
		return new PreAuthorizationPage();
	}
	public AuthorizationFailedPage authorizationFailedPage() {
		return new AuthorizationFailedPage();
	}

}
