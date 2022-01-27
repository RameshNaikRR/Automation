package coyni_mobile.components;

import org.openqa.selenium.By;

import coyni_mobile.pages.PayRequestPage;
import coyni_mobile.pages.PaymentMethodsPage;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class TokenHomePopUp extends MobileFunctions {

	private By btnScan = MobileBy.xpath("(//*[@name='Scan'])[1]");
	private By btnPayRequest = MobileBy.xpath("(//*[@name='Pay/Request'])[3]");
	private By btnBuyTokens = MobileBy.xpath("(//*[@name='Buy Tokens'])[1]|//*[contains(@resource-id,'buyTokenLL')]");
	private By btnWithdrawToUSD = MobileBy.xpath("//*[@text='Withdraw to USD']");

	public void clickScan() {
		click(btnScan, "Scan");
	}

	public void clickPayRequest() {
		click(btnPayRequest, "PayRequest");
	}

	public void clickBuyTokens() {
		click(btnBuyTokens, "BuyTokens");
	}

	public void clickWithdrawToUSD() {
		click(btnWithdrawToUSD, "Withdraw to USD");
	}

	public PayRequestPage payRequestPage() {
		return new PayRequestPage();
	}

	public PaymentMethodsPage paymentMethodsPage() {
		return new PaymentMethodsPage();
	}
	public WithdrawMenuComponent withdrawMenuComponent() {
		return new WithdrawMenuComponent();
	}

}
