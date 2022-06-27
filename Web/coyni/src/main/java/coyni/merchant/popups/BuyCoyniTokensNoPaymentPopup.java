package coyni.merchant.popups;

import org.openqa.selenium.By;


import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class BuyCoyniTokensNoPaymentPopup extends BrowserFunctions {

	private By lnkAddNewPayment = By.xpath("//button[@id='small-add-payment-button']");
	private By lblNoPayment = By.xpath("//h2[text()='No Payment Method Available']");

	public void clickOnAddNewPayment() {
		click(lnkAddNewPayment, "click Add New Payment");
	}

	public void verifyNoPayment() {
		new CommonFunctions().elementView(lblNoPayment, "No Payment");
	}
}
