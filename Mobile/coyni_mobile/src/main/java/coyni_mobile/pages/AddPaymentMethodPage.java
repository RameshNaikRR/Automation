package coyni_mobile.pages;

import org.openqa.selenium.By;

import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class AddPaymentMethodPage extends MobileFunctions{
	
	private By lnkExternalBankAccount = MobileBy.xpath("");
	private By lnkDebitCard = MobileBy.xpath("");
	private By lnkCreditCard = MobileBy.xpath("");
	private By btnCross = MobileBy.xpath("");
	
	public void clickExternalBankAccount() {
		click(lnkExternalBankAccount, "ExternalBankAccount");
	}
	
	public void clickDebitCard() {
		click(lnkDebitCard, "Debit Card");
	}
	public void clickCreditCard() {
		click(lnkCreditCard, "Credit Card");
	}
	public void clickCrossMark() {
		click(btnCross, "Cross");
	}
	
	

}
