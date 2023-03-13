package coyni_mobile.pages;

import org.openqa.selenium.By;

import coyni_mobile.components.FiltersComponent;
import coyni_mobile.components.NavigationComponent;
import coyni_mobile.components.TransactionDetailsComponent;
import coyni_mobile.components.TransactionDetailsComponent2;
import coyni_mobile.popups.FilterPopup;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class TransactionPage extends MobileFunctions {

	private By lblTransactions = MobileBy.xpath("//*[@text='Transactions']");

	private By searchOption = MobileBy.xpath("//*[contains(@resource-id,'searchET')]");

	private By filtersIcon = MobileBy.xpath("//*[contains(@resource-id,'filterIconIV')]");

	private By closeIcon = MobileBy.xpath("//*[contains(@resource-id,'closeBtnIV')]");

	private By lblMerchantAndeferenceID = MobileBy.xpath("//*[@text='Reference ID.']");

	private By message = MobileBy.xpath("(//*[contains(@resource-id,'messageTV')])[3]|(//*[contains(@resource-id,'messageTV')])[1]");

	private By btnfiltericon = MobileBy.xpath("//*[@name='filter']");

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

	private By lblNoTransactions = MobileBy.xpath("//*[@text='You have no more transactions']");

	private By lblNoMore = MobileBy.xpath("//*[contains(@name,'more transactions')]");
	
	

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

	public void clickfilter() {
		click(btnfiltericon, "filter icon");
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

	public void ScrollTransactions() {
		if (getElementList(lblNoTransactions, "").size() == 0) {
			scrollDownToElement(lblNoTransactions, "You have no more transactions");
		}
	}

	public void verifyTransactions(String expHeading) {
		scrollDownToElement(lblNoTransactions, "No More Transactions");
		new CommonFunctions().verifyLabelText(lblNoTransactions, "No More Transactions", expHeading);
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
