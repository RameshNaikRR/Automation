package coyni_mobile.components;

import org.openqa.selenium.By;

import coyni_mobile.pages.PayRequestPage;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class TokenHomeComponent extends MobileFunctions {
	private By btnScan = MobileBy.xpath("(//*[@name='Scan'])[1]");
	private By btnPayRequest = MobileBy.xpath("(//*[@name='Pay/Request'])[1]");
	private By btnBuyTokens = MobileBy.xpath("(//*[@name='Buy Tokens'])[1]");
	private By btnWithdrawToUSD = MobileBy.xpath("(//*[@name='Withdraw to USD'])[1]");
	    
	public void clickScan() {
		click(btnScan , "Scan");
	}
	public void clickPayRequest() {
		click(btnPayRequest, "PayRequest");
	}
	public void clickBuyTokens() {
		click(btnBuyTokens, "BuyTokens");
	}
	public void clickWithdrawToUSD() {
		click(btnWithdrawToUSD,"Withdraw to USD");
	}
	public PayRequestPage payRequestPage() {
		return new PayRequestPage();
	}
	 

}
