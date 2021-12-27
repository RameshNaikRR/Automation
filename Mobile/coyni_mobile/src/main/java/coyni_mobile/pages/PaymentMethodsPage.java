package coyni_mobile.pages;

import org.openqa.selenium.By;

import coyni_mobile.components.BuyTokenComponent;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class PaymentMethodsPage extends MobileFunctions{
	
	public By getPaymentItems(String paymentMethod,String last4digits) {
    return MobileBy.xpath(String.format("//*[contains(@name,'paymentMethodsTableView')]/XCUIElementTypeCell/XCUIElementTypeStaticText[contains(@name,'%s')and contains(@name,'%s')]", paymentMethod,last4digits));
	}
	public void clickCreditCard(String last4digits) {
		click(getPaymentItems("Credit",last4digits), "Credit");
	}
	public void clickDebitCard(String last4digits) {
		click(getPaymentItems("Debit",last4digits), "Debit");
		}
	public void clickBankAccount(String last4digits) {
		click(getPaymentItems("Bank",last4digits), "Bank");
	}
	public BuyTokenComponent buyTokenComponent() {
		return new BuyTokenComponent();
	}
}
