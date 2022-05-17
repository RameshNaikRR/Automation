package coyni_mobile_merchant.components;

import org.openqa.selenium.By;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class AccountLimitsComponent extends MobileFunctions {

	private By headingAccountLimits = MobileBy.xpath("//*[contains(@resource-id,'cpAccountLimitsLL')]");
	private By headingMerchantProcessing = MobileBy.xpath("//*[@text='Merchant Processing (CYN)']");
	private By lblMonthlyProcessingVolumeLimit = MobileBy.xpath("//*[@text='Monthly Processing Volume']");
	private By lblHighTicketLimit = MobileBy.xpath("//*[@text='High Ticket Limit']");
	private By headingBuyToken = MobileBy.xpath("//*[@text='Buy Tokens (CYN)']");
	private By lblSignetAccountLimit = MobileBy.xpath("//*[@text='Signet Account']");
	private By headingWithdrawTokenLimit = MobileBy.xpath("//*[@text='Withdraw (CYN)']");
	private By lblInstantPayLimit = MobileBy.xpath("//*[@text='Withdraw (CYN)']");
	private By lblGiftCardLimit = MobileBy.xpath("//*[@text='Gift Card']");

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(headingAccountLimits, "Page Heading", expHeading);
	}

	public void verifyLabelMonthlyProcessingVolume(String expHeading) {
		new CommonFunctions().verifyLabelText(lblMonthlyProcessingVolumeLimit, "Label", expHeading);
	}

	public void verifyHighTicketLabel(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHighTicketLimit, "Label", expHeading);
	}

	public void verifyBuyTokenHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(headingBuyToken, "Page Heading", expHeading);
	}

	public void getMonthlyProcessingVolumeLimit() {
		ExtentTestManager.setInfoMessageInReport("Pay/Request limit is " + getText(lblMonthlyProcessingVolumeLimit));
	}

	public void getHighTicketLimit() {
		ExtentTestManager.setInfoMessageInReport("Buy Token Bank limit is " + getText(lblHighTicketLimit));
	}

	private By verifyBankAccount(String Value) {
		return By.xpath(String.format("(//*[contains(@text,'Bank Account')])[%s]", Value));
	}

	public void getBuyTokenBankAccount() {
		String buyTokenBankAccount = getText(verifyBankAccount("1"));
		ExtentTestManager.setInfoMessageInReport("buyTokenBankAccount: " + buyTokenBankAccount);
	}

	public void getWithdrawBankAccount() {
		String withdrawBankAccount = getText(verifyBankAccount("2"));
		ExtentTestManager.setInfoMessageInReport("withdrawBankAccount: " + withdrawBankAccount);
	}

	public void getInstantPayLimit() {
		ExtentTestManager.setInfoMessageInReport("Instant Pay limit is " + getText(lblInstantPayLimit));
	}

	public void getGiftCardLimit() {
		ExtentTestManager.setInfoMessageInReport("Gift Card limit is" + getText(lblGiftCardLimit));
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}
}
