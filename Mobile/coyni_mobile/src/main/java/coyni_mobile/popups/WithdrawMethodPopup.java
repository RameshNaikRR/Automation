package coyni_mobile.popups;

import org.openqa.selenium.By;

import coyni_mobile.pages.WithdrawTokenPage;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class WithdrawMethodPopup extends MobileFunctions {
	
//	private By lblPopupHeading = MobileBy.xpath("//*[@name='Withdraw Method']");
	private By lblPopupHeading = MobileBy.AccessibilityId("Withdraw Method");
	private By btnAddNewPayment = MobileBy.xpath("//*[@name='Add New Payment Method']");
	private By btnArrow = MobileBy.AccessibilityId("arrow right");
	private By btnBackSpace = MobileBy.AccessibilityId("backspace");
	
	public void clickBackspace() {
		click(btnBackSpace, "Backspace");
	}
	
	public void clickArrow() {
		click(btnArrow, "Arrow");
	}
	
	public void verifyWithdrawMethodPopupView() {
		new CommonFunctions().elementView(lblPopupHeading, "Withdraw method popup");
	}
	public void verifyAddPaymentView() {
		new CommonFunctions().elementView(btnAddNewPayment, "Add New Payment Method");
	}
	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblPopupHeading, "Popup Heading", expHeading);
	}
	public void clickAddNewPayment() {
		if (getElementList(lblPopupHeading, "PopupHeading").size() > 0) {
			click(btnAddNewPayment, "Add New Payment Method");
		}
	}
	
	public By getPaymentItems(String paymentMethod, String last4digits) {
		return MobileBy.xpath(String.format("//*[contains(@name,'%s') and contains(@name,'%s')]",
			paymentMethod, last4digits));
	}

	public void clickCreditCard(String last4digits) {
		click(getPaymentItems("Credit", last4digits), "Credit");
	}

	public void clickDebitCard(String last4digits) {
		click(getPaymentItems("Debit", last4digits), "Debit");
	}
	public void clickSignetAccount(String last4digits) {
		click(getPaymentItems("Signet", last4digits), "Signet");
	}
	
	
	public void clickBankAccount1(String last4digits) {
		click(getPaymentItems("MX Bank", last4digits), "Bank");
	}

	public void clickBankAccount(String last4digits) {
		click(getPaymentItems("MX Bank", last4digits), "Bank");
	}

	public WithdrawTokenPage withdrawTokenPage() {
		return new WithdrawTokenPage();
	}
	
}
