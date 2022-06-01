package coyni_mobile_merchant.popups;

import org.openqa.selenium.By;

import coyni_mobile_merchant.pages.ReceivePaymentPage;
import coyni_mobile_merchant.pages.ScanPage;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class TokenHomePopUp extends MobileFunctions {

	private By btnScan = MobileBy.xpath("//*[contains(@resource-id,'llScan')]");
	private By btnReceivePayment = MobileBy.xpath("//*[contains(@resource-id,'receive_PaymentLL')]");
	private By btnBuyTokens = MobileBy.xpath("//*[contains(@resource-id,'buy_TokenLL')]");
	private By btnWithdrawToUSD = MobileBy.xpath("//*[contains(@resource-id,'widthdrawtoLL')]");

	public void clickScan() {
		click(btnScan, "Scan");
	}

	public void clickReceivePayment() {
		click(btnReceivePayment, "Receive Payment");
	}

	public void clickBuyTokens() {
		click(btnBuyTokens, "BuyTokens");
	}

	public void clickWithdrawToUSD() {
		click(btnWithdrawToUSD, "Withdraw to USD");
	}

	public ScanPage scanPage() {
		return new ScanPage();
	}
	public ReceivePaymentPage receivePaymentPage() {
		return new ReceivePaymentPage();
	}

}
