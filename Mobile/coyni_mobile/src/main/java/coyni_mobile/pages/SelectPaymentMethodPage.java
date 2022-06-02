package coyni_mobile.pages;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class SelectPaymentMethodPage extends MobileFunctions {
	private By lblHeading = MobileBy.xpath("//*[@text='Select Payment Method']");

	private By btnCards(String CardName) {
		return By.xpath(String.format("//*[contains(@text,'Credit')]", CardName));
	}

	private By btnAddNewPayment = MobileBy.xpath("//*[contains(@text,'Add New')]");

	public void verifyHeading(String Heading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Heading", Heading);
	}

	public void clickBankCard() {
		click(btnCards("CashEdge"), "CashEdge");
	}

	public void clickDebitCard() {
		click(btnCards("Debit"), "Debit");
	}

	public void clickCreditCard() {
		click(btnCards("Credit"), "Credit");
	}

	public void clickAddNewPayment() {
		click(btnAddNewPayment, "Add new payment method");
	}

}
