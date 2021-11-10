package coyni_mobile.pages;

import org.openqa.selenium.By;

import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class PreAuthorizationPage extends MobileFunctions{
	
	private By txtAmount = MobileBy.xpath("");
	private By btnVerify = MobileBy.xpath("");
	
	public void fillAmount(String amount) {
		enterText(txtAmount, amount, "Amount");
	}
	public void clickVerify() {
		click(btnVerify, "Verify");
	}
    public AllDonePage allDonePage() {
    	return new AllDonePage();
    }
}
