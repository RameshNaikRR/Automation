package coyni_mobile.components;

import org.openqa.selenium.By;

import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class TokenHomeComponent extends MobileFunctions {
	private By btnScan = MobileBy.xpath(" ");
	private By btnPayRequest = MobileBy.xpath(" ");
	private By btnBuyTokens = MobileBy.xpath(" ");
	private By btnWithdrawToUSD = MobileBy.xpath(" ");
	    
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
	
	 

}
