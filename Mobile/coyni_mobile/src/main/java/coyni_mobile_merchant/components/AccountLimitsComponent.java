package coyni_mobile_merchant.components;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class AccountLimitsComponent extends MobileFunctions {
	private By lblHeading = MobileBy.xpath("//*[contains(@text,'Account Limits')]");
	private By lblMerchantProcessingHeading = MobileBy.xpath("//*[contains(@text,'Merchant Processing')]");
	private By lblBuyTokensHeading = MobileBy.xpath("//*[contains(@text,'Buy Tokens ')]");
	private By lblWithdrawHeading = MobileBy.xpath("//*[contains(@text,'Withdraw (CYN)')]");
	
	private By getProcessingVolume = MobileBy.xpath("//*[contains(@resource-id,'MonthlyProcessing')]");
	private By getTicketLimit = MobileBy.xpath("//*[contains(@resource-id,'HighTicket')]");
	private By getBuyBankAcc = MobileBy.xpath("//*[contains(@resource-id,'BUYBank')]");
	private By getBuySignetAcc = MobileBy.xpath("//*[contains(@resource-id,'BuySignet')]");
	private By getWithdrawBankAcc = MobileBy.xpath("//*[contains(@resource-id,'WithdrawBank')]");
	private By getWithdrawInstantPay = MobileBy.xpath("//*[contains(@resource-id,'B_InstantPay')]");
	private By getWithdrawGiftcard = MobileBy.xpath("//*[contains(@resource-id,'B_GiftCard')]");
	private By getWithdrawSignetAcc = MobileBy.xpath("//*[contains(@resource-id,'WithdrawSignet')]");
	private By btnBack = MobileBy.xpath("//*[contains(@resource-id,'Back')]");

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Account Limits Heading", expHeading);
	}

	
	public void verifyMerchantProcessingHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblMerchantProcessingHeading, "Merchant Processing Heading", expHeading);
	}

	public void verifyBuyTokensHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblBuyTokensHeading, "Buy Tokens Heading", expHeading);
	}

	public void verifyWithdrawHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblWithdrawHeading, "Withdraw Heading", expHeading);
	}

	public void getBuyBankAcc() {
		String str = getText(getBuyBankAcc);
		ExtentTestManager.setInfoMessageInReport("Buy Bank Account : " + str);
	}

	public void getBuySignetAcc() {
		String str = getText(getBuySignetAcc);
		ExtentTestManager.setInfoMessageInReport("Buy Signet Account : " + str);
	}

	public void getWithdrawBankAcc() {
		String str = getText(getWithdrawBankAcc);
		ExtentTestManager.setInfoMessageInReport("Withdraw Bank Account : " + str);
	}

	public void getWithdrawInstantPay() {
		String str = getText(getWithdrawInstantPay);
		ExtentTestManager.setInfoMessageInReport("Withdraw Instant Pay : " + str);
	}

	public void getWithdrawGiftcard() {
		String str = getText(getWithdrawGiftcard);
		ExtentTestManager.setInfoMessageInReport("Withdraw Gift Card : " + str);
	}

	public void getWithdrawSignetAcc() {
		String str = getText(getWithdrawSignetAcc);
		ExtentTestManager.setInfoMessageInReport("Withdraw Signet Account : " + str);
	}

	public void getProcessingVolume() {
		String str = getText(getProcessingVolume);
		ExtentTestManager.setInfoMessageInReport("Monthly Processing Volume : " + str);
	}

	public void getTicketLimit() {
		String str = getText(getTicketLimit);
		ExtentTestManager.setInfoMessageInReport("TicketLimit : " + str);
	}

	public void clickBack() {
		click(btnBack, "Back");
//		scrollDownToElement(getProcessingVolume, ()getCopiedData);
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}
}
