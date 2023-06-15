package coyni_mobile.popups;

import java.text.DecimalFormat;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
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
	private By lblPurchaseAmount = MobileBy.AccessibilityId("");
	private By lblTotal = MobileBy.AccessibilityId("");
	private By lblProcessingFee = MobileBy.AccessibilityId("");
	private By btnProcessingFee = MobileBy.AccessibilityId("");
	private By lblProcessingFeePercen = MobileBy.AccessibilityId("");
	private By lnkViewFees = MobileBy.AccessibilityId("");
	private By btnLoad = MobileBy.AccessibilityId("");
	private By txtCVV = MobileBy.AccessibilityId("");
	private By btnOk = MobileBy.AccessibilityId("");
	private By lblWalletFees = MobileBy.AccessibilityId("");

	WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 30);
	DecimalFormat df = new DecimalFormat("#.##");

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

	public void clickProcessingFee() {
		click(btnProcessingFee, "Processing Fee Details");
	}

	public void clickViewFees() {
		click(lnkViewFees, "View Fees");
	}

	public void viewWalletFees() {
		new CommonFunctions().elementView(lblWalletFees, "Wallet Fees");
	}

	public void validateProcessingFees() {
		double pocessingFee = Double.parseDouble(df.format(getText(lblProcessingFee).replace(" USD", "")));
		double feePer = Double.parseDouble(
				df.format(getText(lblProcessingFeePercen).replace("% processing fee for this transaction.", "")));
		double amt = Double.parseDouble(df.format(getText(lblPurchaseAmount).replace(" USD", "")));
		double fee = (amt / 100) * feePer;
		double total = Double.parseDouble(getText(lblTotal).replace(" USD", ""));
		if (fee == pocessingFee && total == fee + amt) {
			ExtentTestManager.setPassMessageInReport("");
		} else {
			ExtentTestManager.setFailMessageInReport("The Processing fee or total fee calculation is not correct");
		}
	}
//
//	public void clickAddCreditCard() {
//		click(btnAddCredit, "Add Crdit Card");
//	}

}
