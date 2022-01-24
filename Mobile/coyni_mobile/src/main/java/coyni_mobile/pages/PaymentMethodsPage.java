package coyni_mobile.pages;

import org.openqa.selenium.By;

import coyni_mobile.components.AddNewPaymentComponent;
import coyni_mobile.components.BuyTokenComponent;
import coyni_mobile.popups.CvvPopup;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class PaymentMethodsPage extends MobileFunctions {

	private By lblHeading = MobileBy.xpath("//*[@text='Payment Methods']");
	private By btnAddNewPaymentMethod = MobileBy.xpath("//*[contains(@resource-id,'cvAddPayment')]");

	public void verifyHeading(String expHeading) {
		if (getElementList(lblHeading, "heading").size() > 0) {
			new CommonFunctions().verifyLabelText(lblHeading, "Heading", expHeading);
		}
	}

	public void clickAddNewPaymentMethod() {
		if (getElementList(lblHeading, "heading").size() > 0) {
			click(btnAddNewPaymentMethod, "Add New Payment Method");
		}
	}

	public By getPaymentItems(String paymentMethod, String last4digits) {
		return MobileBy.xpath(String.format(
				"//*[contains(@text,'%s')]/following-sibling::*[contains(@text,'%s')]",
				paymentMethod, last4digits));
	}

	public void clickCreditCard(String last4digits) {
		click(getPaymentItems("Credit", last4digits), "Credit");
	}

	public void clickDebitCard(String last4digits) {
		click(getPaymentItems("Debit", last4digits), "Debit");
	}

	public void clickBankAccount(String last4digits) {
		click(getPaymentItems("Bank", last4digits), "Bank");
	}

	public BuyTokenComponent buyTokenComponent() {
		return new BuyTokenComponent();
	}

	public AddNewPaymentComponent addNewPaymentComponent() {
		return new AddNewPaymentComponent();
	}

	public CvvPopup cvvPopup() {
		return new CvvPopup();
	}
}
