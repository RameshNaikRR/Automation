
package coyni_mobile.popups;

import org.openqa.selenium.By;

import coyni_mobile.components.CalendarComponent;
import coyni_mobile.components.NavigationComponent;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class FiltersPopup extends MobileFunctions {
	private By lblFilters = MobileBy.xpath("//*[@text='Filter']");
	private By imgCalendar = MobileBy
			.xpath("//*[contains(@resource-id,'datePickET')]/following-sibling::android.widget.ImageView");

	public void verifyHeading(String expText) {
		new CommonFunctions().verifyLabelText(lblFilters, "Filters Heading", expText);
	}

	public void clickCalendar() {
		scrollDownToElement(imgCalendar, "Calendar");
		click(imgCalendar, "Calendar");
	}

// Transaction Statuses and Id Located elements
	public By getResourceIDElements(String resourceId) {
		return MobileBy.id(String.format("%s", resourceId));
	}

	public void clickCompletedStatus() {
		scrollDownToElement(getResourceIDElements("com.coyni.mapp:id/transStatusCompleted"), "Completed");
		click(getResourceIDElements("com.coyni.mapp:id/transStatusCompleted"), "Completed");
	}

	public void clickInProgress() {
		click(getResourceIDElements("com.coyni.mapp:id/transStatusInProgress"), "In Progress");
	}

	public void clickPending() {
		click(getResourceIDElements("com.coyni.mapp:id/transStatusPending"), "Pending");
	}

	public void clickFailed() {
		click(getResourceIDElements("com.coyni.mapp:id/transStatusFailed"), "Failed");
	}

	public void clickRefundStatus() {
		click(getResourceIDElements("com.coyni.mapp:id/transStatusRefund"), "Refund");
	}

	public void clickPartialRefund() {
		click(getResourceIDElements("com.coyni.mapp:id/transStatusPartialRefund"), "Partial Refund");
	}

	public void fillFromAmount(String amount) {
		scrollDownToElement(getResourceIDElements("com.coyni.mapp:id/transAmountStartET"), "From Amount");
		enterText(getResourceIDElements("com.coyni.mapp:id/transAmountStartET"), amount, "From Amount");
	}

	public void fillToAmount(String amount) {
		scrollDownToElement(getResourceIDElements("com.coyni.mapp:id/transAmountEndET"), "To Amount");
		enterText(getResourceIDElements("com.coyni.mapp:id/transAmountEndET"), amount, "To Amount");
	}

	public void clickApplyFilter() {
		click(getResourceIDElements("com.coyni.mapp:id/applyFilterBtnCV"), "Apply Filters");
	}

	public void clickResetFilters() {
		click(getResourceIDElements("com.coyni.mapp:id/resetFiltersTV"), "Reset Filters");
	}

//	Main Transactions Types
	public By getTransactionType(String transactionType) {
		return MobileBy.xpath(String.format("//*[@text='%s']/preceding-sibling::*[contains(@resource-id,'checkCB')]",
				transactionType));
	}

	public void clickSent() {
		click(getTransactionType("Sent"), "Sent");
	}

	public void clickReceived() {
		click(getTransactionType("Received"), "Received");
	}

	public void clickSaleOrder() {
		click(getTransactionType("Sale Order"), "Sale Order");
	}

	public void clickRefund() {
		click(getTransactionType("Refund"), "Refund");
	}

	public void clickBuyTokens() {
		click(getTransactionType("Buy Tokens"), "Buy Tokens");
	}

	public void clickWithdraw() {
		click(getTransactionType("Withdraw"), "Withdraw");
	}

//	Transactions Plus Icon
	public By getTransactionSubTypePlus(String transactionType) {
		return MobileBy.xpath(String.format("//*[@text='%s']/following-sibling::*[contains(@resource-id,'plusImage')]",
				transactionType));
	}

	public void clickSaleOderPlus() {
		click(getTransactionSubTypePlus("Sale Order"), "Sale Order");
	}

	public void clickRefundPlus() {
		click(getTransactionSubTypePlus("Refund"), "Refund");
	}

	public void clickBuyTokenPlus() {
		click(getTransactionSubTypePlus("Buy Tokens"), "Buy Tokens");
	}

	public void clickWithdrawTokenPlus() {
		click(getTransactionSubTypePlus("Withdraw"), "Withdraw");
	}

//	Transaction SubTypes
	public By getTransactionSubTypes(String transactionType) {
		return MobileBy.xpath(String.format("//*[@text='%s']/preceding-sibling::*[contains(@resource-id,'chechBoxCB')]",
				transactionType));
	}

	public void clickeCommerseType() {
		click(getTransactionSubTypes("eCommerce"), "eCommerce");
	}

	public void clickRetailMobileType() {
		click(getTransactionSubTypes("Retail / Mobile"), "Retail / Mobile");
	}

	public void clickFullType() {
		click(getTransactionSubTypes("Full"), "Full");
	}

	public void clickPartialType() {
		click(getTransactionSubTypes("Partial"), "Partial");
	}

	public void clickBuyBankAccountType() {
		click(getTransactionSubTypes("Bank Account"), "Bank Account");
	}

	public void clickDebitCardType() {
		click(getTransactionSubTypes("Debit Card"), "Debit Card");
	}

	public void clickCreditCardType() {
		click(getTransactionSubTypes("Credit Card"), "Credit Card");
	}

	public void clickWithdrawBankAccount() {
		click(getTransactionSubTypes("Bank Account"), "Bank Account");
	}

	public void clickInstantPayType() {
		click(getTransactionSubTypes("Instant Pay"), "Instant Pay");
	}

	public void clickGiftCardType() {
		click(getTransactionSubTypes("Gift Card"), "Gift Card");
	}

	public void clickFailedWithdrawType() {
		click(getTransactionSubTypes("Failed Withdraw"), "Failed Withdraw");
	}

	public void clickWithdraFailedFee() {
		click(getTransactionSubTypes("Failed Withdraw Fee"), "Failed Withdraw Fee");
	}

	public CalendarComponent calendarComponent() {
		return new CalendarComponent();
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}

}
