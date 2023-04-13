package coyni_mobile.pages;

import java.time.Duration;

import org.openqa.selenium.By;

import coyni_mobile.components.FiltersComponent;
import coyni_mobile.components.NavigationComponent;
import coyni_mobile.components.TransactionDetailsComponent;
import coyni_mobile.components.TransactionDetailsComponent2;
import coyni_mobile.popups.FilterPopup;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class TransactionPage extends MobileFunctions {
	private By lblTransactions = MobileBy.xpath("//*[@text='Transactions']");
	private By searchOption = MobileBy.xpath("//*[contains(@resource-id,'searchET')]");
	private By filtersIcon = MobileBy.xpath("//*[contains(@resource-id,'filterIcon')]");
	private By closeIcon = MobileBy.xpath("//*[contains(@resource-id,'closeBtnIV')]");
	private By lblMerchantAndeferenceID = MobileBy.xpath("//*[@text='Reference ID.']");
	private By message = MobileBy
			.xpath("(//*[contains(@resource-id,'messageTV')])[3]|(//*[contains(@resource-id,'messageTV')])[1]");
	private By btnfiltericon = MobileBy.xpath("//*[@name='filter']");
	private By transactionOne = MobileBy.xpath("(//*[contains(@resource-id,'layoutTopRadiusRL')])[1]");
	private By lblReferenceId = MobileBy.xpath("//*[@text='Reference ID']");
	private By status = MobileBy.xpath("(//*[contains(@resource-id,'statusTV')])[3]");
	private By lblSendFunds = MobileBy.xpath("//*[@text='Sent funds to Manikanth Vallapureddy']");
	private By lblWithdrawFunds = MobileBy
			.xpath("(//*[contains(@text,'Withdraw')])[1]/following-sibling::*[contains(@resource-id,'amountTV')]");
	private By lblWithdrawAmount = MobileBy.xpath(
			"(//*[contains(@text,'Withdraw')])[1]/../following-sibling::*[1]/*[contains(@resource-id,'balanceTV')]");
	private By lblReceivedFunds = MobileBy
			.xpath("(//*[contains(@text,'Received')])[1]/following-sibling::*[contains(@resource-id,'amountTV')]");
	private By lblGiftCard = MobileBy.xpath("//*[@text='Gift Card purchase for Santosh Pr']");
	private By sendAmount = MobileBy.xpath("(//*[contains(@text,'-')])[4]");
	private By RecieveAmount = MobileBy.xpath(
			"(//*[contains(@text,'Received')])[1]/../following-sibling::*[1]/*[contains(@resource-id,'balanceTV')]");
	private By giftCardAmount = MobileBy.xpath("(//*[contains(@text,'-')])[1]");
	private By amount = MobileBy.xpath("(//*[contains(@resource-id,'amountTV')])[3]");
	private By lblNoRecent = MobileBy
			.xpath("//*[@text='You have no more transactions']|//*[contains(@resource-id,'noTxnTV')]|//*[contains(@resource-id,'noTransactions')]");
	private By lblNoMore = MobileBy.xpath("//*[contains(@resource-id,'noMoreTransactions')]|//*[contains(@resource-id,'noTransactions')]");
//	private By copyIcon = MobileBy.xpath("//*[contains(@resource-id,'refidTV')]|//*[contains(@resource-id,'withdrawRefID')]|//*[contains(@resource-id,'refIdIV')]|//*[contains(@resource-id,'ref')]|//*[contains(@resource-id,'refid')]|//*[contains(@resource-id,'referenceIDTV')|(//*[contains(@resource-id,'ref')])[2]]");
	private By copyIcon = MobileBy.xpath("(//*[contains(@resource-id,'ref')])[1]");
	private By btnBack = MobileBy.xpath("//*[@text='Transaction Details']/preceding-sibling::*|//*[contains(@resource-id,'previous')]");

	public void clickfilter() throws InterruptedException {
		Thread.sleep(1000);
		click(filtersIcon, "filter icon");
	}

	public FiltersPopup filtersPopup() {
		return new FiltersPopup();
	}

	public void ScrollTransactions() {
		if (getElementList(lblNoRecent, "").size() == 0) {
			scrollDownToElement(lblNoMore, "You have no transactions");
		} else {
			ExtentTestManager.setInfoMessageInReport("You have no recent transactions");
		}
	}

	public void VerifySearchWithPasteOption(By ele) {
		TouchAction action = new TouchAction(DriverFactory.getDriver());
		MobileElement search = (MobileElement) DriverFactory.getDriver().findElement(ele);
		Duration duration = Duration.ofMillis(1000);
		action.longPress(
		LongPressOptions.longPressOptions().withElement(ElementOption.element(search)).withDuration(duration))
		.release().perform();
		action.tap(PointOption.point(120, 350)).perform();
	}

	public void clickFirstTransaction() throws InterruptedException {
		if (getElementList(lblNoRecent, "").size() == 0) {
			Thread.sleep(1000);
			click(transactionOne, "transaction");
			click(copyIcon, "Copy");
			Thread.sleep(1000);
			click(btnBack, "back");
			VerifySearchWithPasteOption(searchOption);
//			click(searchOption, "Search");
//			click(searchOption, "Search");
//			click(btnPaste, "Paste");
		} else {
			ExtentTestManager.setPassMessageInReport("No Transactions found");
		}
	}

	public int getUITransactionCount() {
		if (getElementList(lblTransactions, "").size() > 0) {
			ExtentTestManager
					.setInfoMessageInReport("Transaction Count: " + getElementList(lblTransactions, "").size());
		}
		return getElementList(lblTransactions, "").size();
	}

	public void verifySendTransactions(String sendFunds) {
		if (!verifyElementDisplayed(lblSendFunds, "Send Funds")) {
			scrollDownToElement(lblSendFunds, "Send Funds");

		}
		new CommonFunctions().verifyLabelText(lblSendFunds, sendFunds, "Send Funds");
		new CommonFunctions().elementView(sendAmount, "Send Amount");

	}

	public void verifyReceivedTransactions(String receiveFunds) {
		if (!verifyElementDisplayed(lblReceivedFunds, "Received Funds")) {
			scrollDownToElement(lblReceivedFunds, "Received Funds");

		}
		new CommonFunctions().verifyLabelText(lblReceivedFunds, receiveFunds, "Receive Funds");
		new CommonFunctions().elementView(RecieveAmount, "Receive Amountf");

	}

	public void verifyWithdrawTransactions(String withdrawFunds) {
		if (!verifyElementDisplayed(lblWithdrawFunds, "Withdraw Funds")) {
			scrollDownToElement(lblWithdrawFunds, "Withdraw Funds");

		}
		new CommonFunctions().verifyLabelText(lblWithdrawFunds, withdrawFunds, "Withdraw Funds");
		new CommonFunctions().elementView(lblWithdrawAmount, "withdraw Amount");

	}

	public void verifyGiftCardTransactions(String giftCard) {
		if (!verifyElementDisplayed(lblGiftCard, "Gift Card")) {
			scrollDownToElement(lblGiftCard, "Gift Card");

		}
		new CommonFunctions().verifyLabelText(lblGiftCard, giftCard, "Gift Card");
		new CommonFunctions().elementView(giftCardAmount, "Gift Card Amount");

	}

	public void clickOnMessage() {
		click(message, "Message");
	}

	public void verifyTransactionReferenceID(String referenceID) {
		new CommonFunctions().verifyLabelText(lblReferenceId, "Reference ID", referenceID);
	}

	public void verifyLabelTransactions(String expHeading) {
		new CommonFunctions().verifyLabelText(lblTransactions, "Transactions", expHeading);
	}

	public void verifyTransactionsHeading() {
		new CommonFunctions().elementView(lblTransactions, "Transactions");
	}

	public void verifySearchOption() {
		new CommonFunctions().elementView(searchOption, "Search Option");
	}

	public void verifyFiltersIcon() {
		new CommonFunctions().elementView(filtersIcon, "Filters Icon");
	}

	public void verifyReferenceID() {
		new CommonFunctions().elementView(lblMerchantAndeferenceID, "Merchant & Reference ID");
	}

	public void verifyCloseView() {
		new CommonFunctions().elementView(closeIcon, "Close Icon");
	}

	public void verifyMessage() {
		new CommonFunctions().elementView(message, "message " + getText(message));
	}

	public void verifyAmount() {
		new CommonFunctions().elementView(amount, "amount " + getText(amount));
	}

	public void getStatus() {
		new CommonFunctions().elementView(status, "Status " + getText(status));
	}

	public void verifyTransactions(String expHeading) {
		scrollDownToElement(lblNoRecent, "No More Transactions");
		new CommonFunctions().verifyLabelText(lblNoRecent, "No More Transactions", expHeading);
	}

	public FiltersComponent FiltersComponent() {
		return new FiltersComponent();
	}

	public TransactionDetailsComponent transactionDetailsComponent() {
		return new TransactionDetailsComponent();
	}

	public void verifyHeading(String heading) {
		new CommonFunctions().verifyLabelText(lblTransactions, "Transaction Heading is", heading);
	}

	public void clickFilter() {
		click(filtersIcon, "Filter");
	}

	public FilterPopup filterPopup() {
		return new FilterPopup();
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}

	public TransactionDetailsComponent2 transactionDetailsComponent2() {
		return new TransactionDetailsComponent2();
	}
}
