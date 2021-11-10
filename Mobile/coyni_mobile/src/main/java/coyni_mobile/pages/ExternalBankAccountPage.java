package coyni_mobile.pages;

import org.openqa.selenium.By;

import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class ExternalBankAccountPage extends MobileFunctions {
	private By btnBank = MobileBy.xpath(" ");
	private By lnkAddaNewPaymentMethod = MobileBy.xpath(" ");
	
	public void clickBank() {
		click(btnBank, "Bank");
	}
	public void clickAddaNewPaymentMethod() {
		click(lnkAddaNewPaymentMethod, "AddaNewPaymentMethod");
	}

}
