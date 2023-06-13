package coyni_mobile.components;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class ReloadPopup extends MobileFunctions {
	private By lblInsuffHeading = MobileBy.AccessibilityId("");
	private By lblInsuffDescription = MobileBy.AccessibilityId(" ");
	private By btnNewAmt = MobileBy.AccessibilityId("");
	private By btnReload = MobileBy.AccessibilityId("//*[@text='Paying Method']");
	private By lblAddCaReloadHeading = MobileBy.AccessibilityId("");
	private By lblAddCaReDescription = MobileBy.AccessibilityId("");
	private By btnAddDebit = MobileBy.AccessibilityId("//*[contains(@resource-id,'myUserIDTV')]");
	private By btnAddCredit = MobileBy.AccessibilityId("//*[contains(@resource-id,'messageTV')]");
	private By lblReloadHeading = MobileBy.AccessibilityId("");
	private By txtAmount = MobileBy.AccessibilityId("");
	private By btnPaymentMethod = MobileBy.AccessibilityId("//*[contains(@resource-id,'refIDTV')]");
	private By btnAddPayment = MobileBy.AccessibilityId("");
	private By lblAddPaymentHeading = MobileBy.AccessibilityId("");
	private By lblPurchaseAmount = MobileBy.AccessibilityId("//*[contains(@resource-id, 'im_lock')]");
	private By lblTotal = MobileBy.AccessibilityId("");
	private By lblProcessingFee = MobileBy.AccessibilityId("//*[contains(@resource-id,'doneCV')]|//*[@text='Done']");
	private By btnLoad = MobileBy.AccessibilityId("");
	private By txtCVV = MobileBy.AccessibilityId("");
	private By btnOk = MobileBy.AccessibilityId("");

	WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 30);

	public void verifyInsuffHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblInsuffHeading, "Insufficient Balance Heading", expHeading);
		new CommonFunctions().elementView(lblInsuffDescription, "Insufficient Description");
	}

	public void verifyAddCardReloadHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblAddCaReloadHeading, "Add Card Reload Heading", expHeading);
		new CommonFunctions().elementView(lblAddCaReDescription, "Add Card Reload Description");
	}

	public void verifyReloadHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblReloadHeading, "Reload popup heading", expHeading);
	}

	public void verifyAddPaymnetHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblAddPaymentHeading, "Add Payment Heading", expHeading);
	}
	
	public void clickNewAmount() {
		click(btnNewAmt, "New Amount");
	}

	public void clickReload() {
		click(btnReload, "Reload");
	}

	public void clickAddDebitCard() {
		click(btnAddDebit, "Add Debit Card");
	}

	public void clickAddCreditCard() {
		click(btnAddCredit, "Add Crdit Card");
	}

	public void fillAmount(String amount) {
		enterText(txtAmount, amount, "Amount");
	}

	public void clickPaymentMethod() {
		click(btnPaymentMethod, "Payment Method");
	}
	
	public void clickAddPayment() {
		click(btnAddPayment, "Add Payment Method");
	}
	
	public void clickLoad() {
		click(btnLoad, "Load");
	}

	public void fillCVV(String cvv) {
		enterText(txtCVV, cvv, "Cvv");
	}
	
	public void clickOk() {
		click(btnOk, "Ok");
	}
	
}
