package coyni_mobile_merchant.components;

import java.sql.Driver;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import coyni_mobile.utilities.Direction;
import coyni_mobile_merchant.pages.PayoutTransactionsPage;
import coyni_mobile_merchant.popups.FilterPopup;
import coyni_mobile_merchant.popups.OrderPreviewPopup;
import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class BatchPayOutComponent extends MobileFunctions {

	private By lblBatchPayOuts = MobileBy.xpath("//*[@text='Batch Payouts']");

	private By lblNextPayOut = MobileBy.xpath("//*[contains(@resource-id,'nextPayoutAmountTV')]");

	private By lblLastPayOut = MobileBy.xpath("//*[contains(@resource-id,'lastPayoutAmountTV')]");

	private By lnkViewFullPayOutHistory = MobileBy.xpath("//*[contains(@resource-id,'tv_PayoutFullHistory')]");

	private By btnBatchNow = MobileBy.xpath("//*[contains(@resource-id,'batch_now')]");

	private By btnBatchNowHeading = MobileBy.xpath("//*[contains(@text,'Closing Batch')]");

	private By btnBatchNowAmount = MobileBy.xpath("//*[contains(@resource-id,'Amount')]");

	private By btnBatchNowSendTo = MobileBy.xpath("//*[contains(@resource-id,'sentToDescription')]");

	private By btnBatchNowSlideToConfirm = MobileBy.xpath("//*[contains(@resource-id,'slideToConfirmm')]");

	public void verifyLabelBatchPayOuts(String expHeading) {
		scrollDownToElement(lblBatchPayOuts, "Batch PayOuts");
		new CommonFunctions().verifyLabelText(lblBatchPayOuts, "Batch PayOuts", expHeading);
	}

	public void clickBatchNow() {
		scrollDownToElement(btnBatchNow, "Batch Now");
		if (verifyElementDisplayed(btnBatchNow, "Click Batch Now")) {
			click(btnBatchNow, "Batch Now");
		} else {
			ExtentTestManager.setInfoMessageInReport("Batch Now is disabled");
		}
	}

	public void clickFullPayOutHistory() {
		scrollDownToElement(lnkViewFullPayOutHistory, "Full Pay Out History");
		click(lnkViewFullPayOutHistory, "Full PayOut History");
	}

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(btnBatchNowHeading, "Batch Now Processing Heading", expHeading);
	}

	public double verifyTransactionAmount() {
		String quantityText = getText(lblNextPayOut);
		double value = Double.parseDouble(quantityText);
		return value;
//		Integer qty = Integer.valueOf(quantityText);
	}

//	public int TransactionAmount() {
//		return DriverFactory.getDrive
//	}

	public void slideToConfirm() {
		new CommonFunctions().swipeElement(btnBatchNowSlideToConfirm, Direction.RIGHT);
	}

	public void getNextPayOut() {
		scrollDownToElement(lblNextPayOut, "Next PayOut");
		ExtentTestManager.setInfoMessageInReport("Next PayOut " + getText(lblNextPayOut));
	}

	public void getLastPayOut() {
		ExtentTestManager.setInfoMessageInReport("Last PayOut " + getText(lblLastPayOut));
	}

	public void getBatchPayoutAmount() {
		ExtentTestManager.setInfoMessageInReport("Batch Payout Amount" + getText(btnBatchNowAmount));
	}

	public void getBatchPayoutSentto() {
		ExtentTestManager.setInfoMessageInReport("Sent to" + getText(btnBatchNowSendTo));
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}

	public PayoutTransactionsPage payoutTransactionsPage() {
		return new PayoutTransactionsPage();
	}

	public FilterPopup filterPopup() {
		return new FilterPopup();
	}

	public EnterYourPINComponent enterYourPINComponent() {
		return new EnterYourPINComponent();
	}

	public FieldValidationsComponent fieldValidationsComponent() {
		return new FieldValidationsComponent();
	}
}
