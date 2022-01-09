package coyni_mobile.components;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class AccountLimitsComponent extends MobileFunctions {

	private By lblHeading = MobileBy.xpath("//*[@text='Account Limits']");
	private By lblPayRequest = MobileBy.xpath("(//*[contains(@text,'Pay/Request')])[1]");
	private By lblBuyTokens = MobileBy.xpath("//*[contains(@text,'Buy Tokens')]");
	private By lblWithdraw = MobileBy.xpath("//*[contains(@text,'Withdraw')]");
	private By lblPayRequestLimit = MobileBy.xpath("//*[contains(@resource-id,'tvPayRequestTransactionLimit')]");
	private By lblBuyTokenBankLimit = MobileBy.xpath("//*[contains(@resource-id,'tvBuyTokenBankLimit')]");
	private By lblBuyTokenCardsLimit =MobileBy.xpath("//*[contains(@resource-id,'tvBuyTokenDebitLimit')]");
    private By lblWithdrawBankLimit =MobileBy.xpath("//*[contains(@resource-id,'tvWithTokenBankLimit')]");
	private By lblInstantPayLimit = MobileBy.xpath("//*[contains(@resource-id,'tvWithTokenInstantLimit')]");
	private By lblGiftCardLimit = MobileBy.xpath("//*[contains(@resource-id,'tvWithdrawTokenGiftCardLimit')]");
	
	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Page Heading", expHeading);
	}
	public void verifyPayRequestLabel(String expHeading) {
		new CommonFunctions().verifyLabelText(lblPayRequest, "Label", expHeading);
	}
	public void verifyBuyTokensLabel(String expHeading) {
		new CommonFunctions().verifyLabelText(lblBuyTokens, "Label", expHeading);
	}
	public void VerifyWithdrawLabel(String expHeading) {
		new CommonFunctions().verifyLabelText(lblWithdraw, "Label", expHeading);
	}
	public void getPayRequestLimit() {
		ExtentTestManager.setInfoMessageInReport("Pay/Request limit is "+ getText(lblPayRequestLimit));
	}
	public void getBuyTokenBankLimit() {
		ExtentTestManager.setInfoMessageInReport("Buy Token Bank limit is "+ getText(lblBuyTokenBankLimit));
	}
	public void getCardsLimit() {
		ExtentTestManager.setInfoMessageInReport("Cards limit is "+ getText(lblBuyTokenCardsLimit));
	}
	public void getWithdrawBankLimit() {
		ExtentTestManager.setInfoMessageInReport("Withdraw Bank limit is "+ getText(lblWithdrawBankLimit));
	}
	public void getInstantPayLimit() {
		ExtentTestManager.setInfoMessageInReport("Instant Pay limit is "+ getText(lblInstantPayLimit));
	}
	public void getGiftCardLimit() {
		ExtentTestManager.setInfoMessageInReport("Gift Card limit is"+ getText(lblGiftCardLimit));
	}
	
	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}
}
