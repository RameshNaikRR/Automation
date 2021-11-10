package coyni_mobile.pages;

import org.openqa.selenium.By;

import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class InstantPayPage extends MobileFunctions {
	private By lnkAddaNewPaymentMethod = MobileBy.xpath(" ");
	 
	public void clickAddaNewPaymentMethod() {
		click(lnkAddaNewPaymentMethod, "AddaNewPaymentMethod");
	}

}
