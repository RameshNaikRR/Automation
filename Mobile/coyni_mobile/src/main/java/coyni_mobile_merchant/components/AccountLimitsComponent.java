package coyni_mobile_merchant.components;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class AccountLimitsComponent extends MobileFunctions {

	private By lblHeading = MobileBy.xpath("");
	private By lblPayRequest = MobileBy.xpath("");
	private By lblBuyTokens = MobileBy.xpath("");
	private By lblWithdraw = MobileBy.xpath("");
	private By lblPayRequestLimit = MobileBy.xpath("");
	private By lblBuyTokenBankLimit = MobileBy.xpath("");
	private By lblBuyTokenCardsLimit =MobileBy.xpath("");
    private By lblWithdrawBankLimit =MobileBy.xpath("");
	private By lblInstantPayLimit = MobileBy.xpath("");
	private By lblGiftCardLimit = MobileBy.xpath("");
	
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
