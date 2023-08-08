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
	private By lblInsuffHeading = MobileBy.id("com.coyni.mapp:id/tvHead");
	private By lblInsuffDescription = MobileBy.id("com.coyni.mapp:id/tvMessage");
	private By btnNewAmt = MobileBy.xpath("//*[@text='New Amount']");
	private By btnReload = MobileBy.id("com.coyni.mapp:id/reloadCV");
	private By btnAddDebit = MobileBy.id("com.coyni.mapp:id/lyDebitCard");
	private By btnAddCredit = MobileBy.id("com.coyni.mapp:id/lyCreditCard");
	private By lblReloadHeading = MobileBy.xpath("//*[@text='Reload Amount']");
	private By txtAmount = MobileBy.id("com.coyni.mapp:id/setAmountET");
	private By btnPaymentMethod = MobileBy.id("com.coyni.mapp:id/payment_method_ll");
	private By btnAddPayment = MobileBy.xpath("//*[@text='Add New Payment Method']");
	private By lblAddPaymentHeading = MobileBy.id("com.coyni.mapp:id/tvHeadTop");
	private By btnLoad = MobileBy.id("com.coyni.mapp:id/keyActionLL");
	private By txtCVV = MobileBy.id("com.coyni.mapp:id/etCVV");
	private By btnOk = MobileBy.xpath("//*[@text='OK']");
	private By lblWalletFees = MobileBy.id("com.coyni.mapp:id/headingTV");
	private By lblReloadErrorMsg = MobileBy.id("com.coyni.mapp:id/tvError");

//	You Will Receive Popup details or Order preview details

	private By lblYouWillReceive = MobileBy.xpath("//*[@text='You Will Receive']|//*[contains(@text,'Gift Card')]");
	private By lblamount = MobileBy
			.xpath("//*[contains(@resource-id,'setAmountET')]|//*[contains(@resource-id,'tvGet')]");
	private By lblPurchaseAmount = MobileBy.xpath(
			"//*[@text='Purchase Amount']/following-sibling::*|//*[@text='Withdraw Amount']/following-sibling::*");
	private By lblTotal = MobileBy.xpath(
			"//*[@text='Total']/following-sibling::*|//*[contains(@resource-id,'tvTotal')]|//*[contains(@resource-id,'total_amount_usd')]");
	private By lblPaymentMethod = MobileBy.xpath(
			"//*[contains(@resource-id,'gcTypeTV')]|//*[contains(@resource-id,'tvBankName')]|//*[contains(@resource-id,'tvPayMethod')]|//*[contains(@resource-id,'card_number')]");
	private By lblProcessingFee = MobileBy.xpath(
			"//*[contains(@text,'Processing Fee')]/preceding-sibling::*|//*[contains(@resource-id,'tvProcessFee')]");
	private By btnProsFeeInfo = MobileBy
			.xpath("//*[contains(@text,'Processing Fee')]/following-sibling::*|//*[contains(@resource-id,'info')]");
	private By lblProcessingFeePercen = MobileBy.id("com.coyni.mapp:id/feePercentageTV");
	private By lnkViewFees = MobileBy.xpath("//*[contains(@resource-id,'feePercentageTV')]/following-sibling::*");
	private By btnConfirm = MobileBy.id("com.coyni.mapp:id/cvConfirm");

	WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 30);
	DecimalFormat df = new DecimalFormat("#.##");

//	String[] transAmount = getText(lblPurchaseAmount).split(" ");
//	String[] ProcessingFee = getText(lblProcessingFee).split(" ");
//	Double total = Double.parseDouble(transAmount[0]) + Double.parseDouble(ProcessingFee[0]);
//	DecimalFormat df = new DecimalFormat("#.##");

//	System.out.println(feees);
//	return feees;
	public void verifyInsuffHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblInsuffHeading, "Insufficient Balance Heading", expHeading);
		new CommonFunctions().elementView(lblInsuffDescription, "Insufficient Description");
	}

	public void verifyAddCardReloadHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblInsuffHeading, "Add Card Reload Heading", expHeading);
		new CommonFunctions().elementView(lblInsuffDescription, "Add Card Reload Description");
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

	public void clickConfirm() {
		click(btnConfirm, "Confirm");
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
		click(btnProsFeeInfo, "Processing Fee Info");
	}

	public void clickViewFees() {
		click(lnkViewFees, "View Fees");
	}

	public void viewWalletFees() {
		new CommonFunctions().elementView(lblWalletFees, "Wallet Fees");
	}

	public double verifyReloadAmount() {
		double amt = Double.parseDouble(getText(txtAmount));
		return amt;
	}

	public void verifyYouWillRecveHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblYouWillReceive, "Receive Popup Heading", expHeading);
		new CommonFunctions().elementView(lblamount, "Amount");
		new CommonFunctions().elementView(lblPaymentMethod, "Payment Method");
		ExtentTestManager.setPassMessageInReport(getText(lblPaymentMethod));
	}

	public double verifyProcessingFee() {
		double pocessingFee = Double.parseDouble(getText(lblProcessingFee).replace(" USD", "").replace(" CYN", ""));
		return pocessingFee;
	}

	public void validateReloadTransactionErrorMessage(String amt) {
		if (getText(lblReloadErrorMsg)
				.equals("Minimum amount of " + amt + ".00 CYN is required to complete transaction.")) {
			ExtentTestManager.setPassMessageInReport(getText(lblReloadErrorMsg) + "is displayed for Set Amount field");
		} else {
			ExtentTestManager
					.setFailMessageInReport(getText(lblReloadErrorMsg) + "is not displayed for Set Amount field");
		}
	}

	public void validateWithoutProcessingFee(String amount) {
		double reqstAmt = Double.parseDouble(amount);
		double amt = Double.parseDouble(getText(lblamount).replace("$", ""));
		double purchaseAmt = Double.parseDouble(getText(lblPurchaseAmount).replace(" USD", "").replace(" CYN", ""));
		double total = Double.parseDouble(getText(lblTotal).replace(" USD", "").replace(" CYN", ""));
		if (reqstAmt == purchaseAmt && reqstAmt == amt) {
			ExtentTestManager.setPassMessageInReport("Transaction amount and Purchase amount are same");
		} else {
			ExtentTestManager.setFailMessageInReport("Transaction amount and Purchase amount are not same");
		}
		if (reqstAmt == total) {
			ExtentTestManager
					.setPassMessageInReport("The Total amount is addition of Purchase amount and Processing Fee");
		} else {
			ExtentTestManager
					.setFailMessageInReport("The Total amount is not addition of Purchase amount and Processing Fee");
		}
	}

	public void validateProcessingFees(String amount) {
		double amt = Double.parseDouble(amount);
		System.out.println("amt" + amt);
		double purchaseAmt = Double.parseDouble(getText(lblPurchaseAmount).replace(" USD", "").replace(" CYN", ""));
		System.out.println("purchaseAmt" + purchaseAmt);
		double pocessingFee = Double.parseDouble(getText(lblProcessingFee).replace(" USD", "").replace(" CYN", ""));
		System.out.println("pocessingFee" + pocessingFee);
		double total = Double.parseDouble(getText(lblTotal).replace(" USD", "").replace(" CYN", ""));
		System.out.println("total" + total);
		if (amt == purchaseAmt) {
			ExtentTestManager.setPassMessageInReport("Transaction amount and Purchase amount are same");
		} else {
			ExtentTestManager.setFailMessageInReport("Transaction amount and Purchase amount are not same");
		}
		if (!getText(lblProcessingFeePercen)
				.contains(getText(lblProcessingFee).replace(" USD", "").replace(" CYN", ""))) {
			String fee = getText(lblProcessingFeePercen).replace("% processing fee for this transaction.", "");
			System.out.println("fee" + fee);

//if() {
//	
//}else {
//	
//}

			String[] fePer = fee.split("\\+");
			System.out.println("fePer" + fePer);
			double percentage = Double.parseDouble(fePer[1]);
			System.out.println("percentage" + percentage);
			double feePercentage = (amt / 100) * percentage;
			System.out.println("feePercentage" + feePercentage);
			double feeDollars = Double.parseDouble(fePer[0].replace("$", ""));
			double testFee = Double.parseDouble(df.format(feeDollars + feePercentage));
			double testtotal = Double.parseDouble(df.format(feeDollars + feePercentage + amt));
			System.out.println("testFee" + testFee);
			System.out.println("testtotal" + testtotal);
			System.out.println("feeDollars" + feeDollars);
			if (testFee == pocessingFee) {
				ExtentTestManager.setPassMessageInReport("Processing fee calculated as per Condition");
			} else {
				ExtentTestManager.setFailMessageInReport("Processing fee not calculated as per Condition");
			}
			if (testtotal == total) {
				ExtentTestManager
						.setPassMessageInReport("The Total amount is addition of Purchase amount and Processing Fee");
			} else {
				ExtentTestManager.setFailMessageInReport(
						"The Total amount is not addition of Purchase amount and Processing Fee");
			}
		} else {
			if (total == purchaseAmt + pocessingFee) {
				ExtentTestManager
						.setPassMessageInReport("The Total amount is addition of Purchase amount and Processing Fee");
			} else {
				ExtentTestManager.setFailMessageInReport(
						"The Total amount is not addition of Purchase amount and Processing Fee");
			}
		}
	}

//	public void validateProcessingFees(String amount) {
//		double amt = Double.parseDouble(amount);
//		System.out.println("amt" + amt);
//		double purchaseAmt = Double.parseDouble(getText(lblPurchaseAmount).replace(" USD", "").replace(" CYN", ""));
//		System.out.println("purchaseAmt" + purchaseAmt);
//		double pocessingFee = Double.parseDouble(getText(lblProcessingFee).replace(" USD", "").replace(" CYN", ""));
//		System.out.println("pocessingFee" + pocessingFee);
//		String fee = getText(lblProcessingFeePercen).replace("% processing fee for this transaction.", "");
//		System.out.println("fee" + fee);
//		String[] fePer = fee.split("\\+");
//		System.out.println("fePer" + fePer);
//		double percentage = Double.parseDouble(fePer[1]);
//		System.out.println("percentage" + percentage);
//		double feePercentage = (amt / 100) * percentage;
//		System.out.println("feePercentage" + feePercentage);
//		double feeDollars = Double.parseDouble(fePer[0].replace("$", ""));
//		System.out.println("feeDollars" + feeDollars);
//		double total = Double.parseDouble(getText(lblTotal).replace(" USD", "").replace(" CYN", ""));
//		System.out.println("total" + total);
//		if (amt == purchaseAmt) {
//			ExtentTestManager.setPassMessageInReport("Transaction amount and Purchase amount are same");
//		} else {
//			ExtentTestManager.setFailMessageInReport("Transaction amount and Purchase amount are not same");
//		}
//		if (feeDollars + feePercentage == pocessingFee) {
//			ExtentTestManager.setPassMessageInReport("Processing fee calculated as per Condition");
//		} else {
//			ExtentTestManager.setFailMessageInReport("Processing fee not calculated as per Condition");
//		}
//		if (feeDollars + feePercentage + amt == total) {
//			ExtentTestManager
//					.setPassMessageInReport("The Total amount is addition of Purchase amount and Processing Fee");
//		} else {
//			ExtentTestManager
//					.setFailMessageInReport("The Total amount is not addition of Purchase amount and Processing Fee");
//		}
//	}

//	Withdraw processing fee calculation
	public double verifyWithdrawProcessingFee() {
		double pocessingFee = Double.parseDouble(getText(lblProcessingFee).replace(" CYN", ""));
		return pocessingFee;
	}

	public void validateWithdrawWithoutProcessingFee(String amount) {
		double reqstAmt = Double.parseDouble(amount);
		double amt = Double.parseDouble(getText(lblamount));
		double purchaseAmt = Double.parseDouble(getText(lblPurchaseAmount).replace(" CYN", ""));
		double total = Double.parseDouble(getText(lblTotal).replace(" CYN", ""));
		if (reqstAmt == purchaseAmt && reqstAmt == amt) {
			ExtentTestManager.setPassMessageInReport("Transaction amount and Purchase amount are same");
		} else {
			ExtentTestManager.setFailMessageInReport("Transaction amount and Purchase amount are not same");
		}
		if (reqstAmt == total) {
			ExtentTestManager
					.setPassMessageInReport("The Total amount is addition of Purchase amount and Processing Fee");
		} else {
			ExtentTestManager
					.setFailMessageInReport("The Total amount is not addition of Purchase amount and Processing Fee");
		}
	}

	public void validateWithdrawProcessingFees(String amount) {
		double amt = Double.parseDouble(amount);
		System.out.println("amt" + amt);
		double purchaseAmt = Double.parseDouble(getText(lblPurchaseAmount).replace(" CYN", ""));
		System.out.println("purchaseAmt" + purchaseAmt);
		double pocessingFee = Double.parseDouble(getText(lblProcessingFee).replace(" CYN", ""));
		System.out.println("pocessingFee" + pocessingFee);
		double total = Double.parseDouble(getText(lblTotal).replace(" CYN", ""));
		System.out.println("total" + total);
		if (amt == purchaseAmt) {
			ExtentTestManager.setPassMessageInReport("Transaction amount and Purchase amount are same");
		} else {
			ExtentTestManager.setFailMessageInReport("Transaction amount and Purchase amount are not same");
		}
		if (!getText(lblProcessingFeePercen).contains(getText(lblProcessingFee).replace(" CYN", ""))) {
			String fee = getText(lblProcessingFeePercen).replace("% processing fee for this transaction.", "");
			System.out.println("fee" + fee);
			String[] fePer = fee.split("\\+");
			System.out.println("fePer" + fePer);
			double percentage = Double.parseDouble(fePer[1]);
			System.out.println("percentage" + percentage);
			double feePercentage = (amt / 100) * percentage;
			System.out.println("feePercentage" + feePercentage);
			double feeDollars = Double.parseDouble(fePer[0].replace("$", ""));
			System.out.println("feeDollars" + feeDollars);
			if (feeDollars + feePercentage == pocessingFee) {
				ExtentTestManager.setPassMessageInReport("Processing fee calculated as per Condition");
			} else {
				ExtentTestManager.setFailMessageInReport("Processing fee not calculated as per Condition");
			}
			if (feeDollars + feePercentage + amt == total) {
				ExtentTestManager
						.setPassMessageInReport("The Total amount is addition of Purchase amount and Processing Fee");
			} else {
				ExtentTestManager.setFailMessageInReport(
						"The Total amount is not addition of Purchase amount and Processing Fee");
			}
		} else {
			if (total == purchaseAmt + pocessingFee) {
				ExtentTestManager
						.setPassMessageInReport("The Total amount is addition of Purchase amount and Processing Fee");
			} else {
				ExtentTestManager.setFailMessageInReport(
						"The Total amount is not addition of Purchase amount and Processing Fee");
			}
		}
	}

//
//	public void clickAddCreditCard() {
//		click(btnAddCredit, "Add Crdit Card");
//	}

}
