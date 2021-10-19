package coyni.customer.popups;

import org.openqa.selenium.By;

import ilabs.WebFramework.BrowserFunctions;

public class BuyCoyniTokensNoPaymentPopup extends BrowserFunctions {
	
	private By lnkAddNewPayment = By.cssSelector("");
	
	public void clickOnAddNewPayment() {
		click(lnkAddNewPayment, "click Add New Payment");
	}

}
