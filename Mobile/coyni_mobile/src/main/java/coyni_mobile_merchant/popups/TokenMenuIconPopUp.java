package coyni_mobile_merchant.popups;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import coyni_mobile_merchant.components.WithdrawMenuComponent;
import coyni_mobile_merchant.pages.PaymentMethodsPage;
import coyni_mobile_merchant.pages.ReceivePaymentPage;
import coyni_mobile_merchant.pages.ScanPage;
import coyni_mobile_merchant.pages.SelectPaymentmethod;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class TokenMenuIconPopUp extends MobileFunctions {

	private By btnScan = MobileBy.xpath("//*[contains(@resource-id,'llScan')]|//*[contains(@resource-id,'scanQrLL')]");
	private By btnReceivePayment = MobileBy.xpath("//*[contains(@resource-id,'receive_PaymentLL')]");
	private By btnBuyTokens = MobileBy.xpath("//*[contains(@resource-id,'buy_TokenLL')]");
	private By btnWithdrawTokens = MobileBy.xpath("//*[contains(@text,'Withdraw Tokens')]");

	public void clickScan() {
		click(btnScan, "Scan");
	}

	public void viewScan() {
		new CommonFunctions().elementView(btnScan, "Scan");
	}

	public void clickReceivePayment() {
		click(btnReceivePayment, "Receive Payment");
	}

	public void viewReceivePayment() {
		new CommonFunctions().elementView(btnReceivePayment, "Receive Payment");
	}

	public void clickBuyTokens() {
		click(btnBuyTokens, "BuyTokens");
	}

	public void viewBuyTokens() {
		new CommonFunctions().elementView(btnBuyTokens, "Buy Tokens");
	}

	public void clickWithdrawTokens() {
		click(btnWithdrawTokens, "Withdraw Tokens");
	}

	public void viewWithdrawTokens() {
		new CommonFunctions().elementView(btnWithdrawTokens, "Withdraw Tokens");
	}

	public ScanPage scanPage() {
		return new ScanPage();
	}

	public ReceivePaymentPage receivePaymentPage() {
		return new ReceivePaymentPage();
	}

	public SelectPaymentmethod selectPaymentmethod() {
		return new SelectPaymentmethod();
	}

	public WithdrawMenuComponent withdrawMenuComponent() {
		return new WithdrawMenuComponent();
	}

	public PaymentMethodsPage paymentMethodsPage() {
		return new PaymentMethodsPage();
	}

}
